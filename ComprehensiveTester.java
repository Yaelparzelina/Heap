import java.util.*;

public class ComprehensiveTester {

    // Global counters for test summary
    private static int testsPassed = 0;
    private static int testsFailed = 0;

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("      Starting Corrected Heap Tester");
        System.out.println("      (HeapItem / HeapNode Separation)");
        System.out.println("=================================================\n");

        try {
            // 1. Basic Functionality
            testBasicFibonacciOperations();
            
            // 2. Specific Logic for the new requirement (Item Swap vs Node Swap)
            testBinomialHeapifyUp_ItemSwap();
            
            // 3. Advanced Operations
            testCascadingCuts();
            testMeld();
            testDeleteSpecific();
            testEdgeCases();
            
            // 4. Randomized Stress Test
            testStressRandomized(); 

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("CRITICAL: Test runner crashed with exception: " + e.getMessage());
        }

        System.out.println("\n=================================================");
        System.out.println(String.format("SUMMARY: Passed: %d | Failed: %d", testsPassed, testsFailed));
        System.out.println("=================================================");
    }

    // --- Helper Assertion Methods ---

    private static void pass(String testName) {
        System.out.println("[PASS] " + testName);
        testsPassed++;
    }

    private static void fail(String testName, String message) {
        System.out.println("[FAIL] " + testName + ": " + message);
        testsFailed++;
        // Optional: throw exception to stop immediately, or continue to see other failures
        // throw new RuntimeException(message); 
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) throw new RuntimeException(message);
    }

    // --- Tests ---

    /**
     * Test 1: Basic Insert, FindMin, DeleteMin (Lazy/Lazy)
     */
    private static void testBasicFibonacciOperations() {
        System.out.println("\n--- Test 1: Basic Operations ---");
        try {
            Heap heap = new Heap(true, true);

            assertTrue(heap.size() == 0, "New heap size should be 0");
            assertTrue(heap.findMin() == null, "New heap min should be null");

            Heap.HeapItem item10 = heap.insert(10, "Ten");
            Heap.HeapItem item5 = heap.insert(5, "Five");
            Heap.HeapItem item20 = heap.insert(20, "Twenty");

            assertTrue(heap.size() == 3, "Size should be 3");
            assertTrue(heap.findMin().key == 5, "Min should be 5");
            assertTrue(heap.findMin() == item5, "Min item reference mismatch");

            validateHeapStructure(heap);

            heap.deleteMin(); // Remove 5
            
            assertTrue(heap.size() == 2, "Size after deleteMin should be 2");
            assertTrue(heap.findMin().key == 10, "New min should be 10");

            validateHeapStructure(heap);
            pass("Basic Operations");
        } catch (Exception e) {
            fail("Basic Operations", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Test 2: Verify strict HeapifyUp logic (Item Swap)
     * Requirement: When lazyDecreaseKeys=false, swap HeapItems, NOT HeapNodes.
     */
    private static void testBinomialHeapifyUp_ItemSwap() {
        System.out.println("\n--- Test 2: HeapifyUp Item Swap Logic ---");
        try {
            // Non-lazy decrease keys = Binomial behavior for heapify
            Heap heap = new Heap(false, false); 

            // 1. Build a small tree manually via deleteMin consolidation
            // Insert 10, 20. deleteMin on empty structure (if any) or simple linking.
            
            // Insert 10 (Root)
            Heap.HeapItem itemRoot = heap.insert(10, "Root");
            // Insert 20 (Child candidate)
            Heap.HeapItem itemChild = heap.insert(20, "Child");
            
            // In non-lazy meld (if implemented) or simple insert, they might be roots.
            // Force link by calling deleteMin on a dummy min.
            Heap.HeapItem dummy = heap.insert(5, "Dummy");
            heap.deleteMin(); // This removes 5 and links 10 and 20. 
            
            // Now 10 should be parent of 20 (since 10 < 20).
            // Let's capture the physical HeapNode objects
            Heap.HeapNode nodeA = itemRoot.node;
            Heap.HeapNode nodeB = itemChild.node;
            
            // Verify structure before decreaseKey
            boolean isALinkingToB = (nodeA.child == nodeB || nodeA.child == nodeB.next || nodeB.parent == nodeA);
            // Or B linking to A (unlikely since 10 < 20)
            
            if (!isALinkingToB) {
                // Try the other way if implementation differs
                if (nodeB.child == nodeA || nodeB.child == nodeA.next || nodeA.parent == nodeB) {
                     // Swap our ref variables to match reality: A is parent, B is child
                     Heap.HeapNode temp = nodeA; nodeA = nodeB; nodeB = temp;
                     Heap.HeapItem tempI = itemRoot; itemRoot = itemChild; itemChild = tempI;
                }
            }
            
            // We assume nodeA is parent, nodeB is child.
            // itemRoot is in nodeA, itemChild is in nodeB.
            
            // 2. Perform DecreaseKey on the CHILD item to be smaller than PARENT
            // Decrease 20 -> 5.
            heap.decreaseKey(itemChild, 15); // 20 - 15 = 5.
            
            // Now 5 < 10. HeapifyUp should happen.
            
            // 3. VERIFY THE SWAP:
            // ACCORDING TO SPECS: "HeapItem of son will be in HeapNode where father was"
            // So: 
            // - nodeA (the physical parent node) should now hold itemChild (key 5).
            // - nodeB (the physical child node) should now hold itemRoot (key 10).
            // - nodeA should STILL be the parent of nodeB.
            
            assertTrue(nodeA.item == itemChild, "HeapNode A (Parent) should now hold the Child Item");
            assertTrue(nodeB.item == itemRoot, "HeapNode B (Child) should now hold the Parent Item");
            
            // Verify items point to new nodes
            assertTrue(itemChild.node == nodeA, "Item Child should point to Node A");
            assertTrue(itemRoot.node == nodeB, "Item Root should point to Node B");
            
            // Verify physical structure DID NOT change
            // nodeA should still be parent of nodeB
            boolean structurePreserved = (nodeB.parent == nodeA);
            assertTrue(structurePreserved, "Physical HeapNode structure changed! (Nodes shouldn't move, only items)");
            
            pass("HeapifyUp Item Swap Logic");
        } catch (Exception e) {
            fail("HeapifyUp Item Swap Logic", e.getMessage());
        }
    }

    /**
     * Test 3: Cascading Cuts logic check
     */
    private static void testCascadingCuts() {
        System.out.println("\n--- Test 3: Cascading Cuts ---");
        try {
            Heap heap = new Heap(true, true); // Lazy mode
            
            // We need a tree with depth. 
            // Insert 0..15.
            List<Heap.HeapItem> items = new ArrayList<>();
            for (int i = 0; i < 16; i++) {
                items.add(heap.insert(i, "v"+i));
            }
            heap.deleteMin(); // Consolidate. Should create a tree of rank ~4 (since 15 nodes left).
            
            // This is a statistical check because we can't easily traverse deep internal structure 
            // without knowing exact linking order.
            // However, we can check totalCuts increases.
            
            int initialCuts = heap.totalCuts();
            
            // We need to cut a node that is NOT a root.
            // The consolidation usually makes a Binomial tree structure.
            // If we decrease a key of a leaf to -infinity, it will be cut.
            
            // Let's take the last inserted item (likely high key, likely leaf or low rank)
            Heap.HeapItem target = items.get(15); 
            // Ensure it's not the min (which was 0, deleted). 15 is in there.
            
            heap.decreaseKey(target, 1000); // Make it negative, surely smaller than parent
            
            int cutsAfter = heap.totalCuts();
            assertTrue(cutsAfter > initialCuts, "Total cuts should increase after decreasing a non-root node");
            
            pass("Cascading Cuts (Stats Check)");
        } catch (Exception e) {
            fail("Cascading Cuts", e.getMessage());
        }
    }

    /**
     * Test 4: Meld
     */
    private static void testMeld() {
        System.out.println("\n--- Test 4: Meld ---");
        try {
            Heap h1 = new Heap(true, true);
            h1.insert(10, "10");
            h1.insert(20, "20");
            
            Heap h2 = new Heap(true, true);
            h2.insert(5, "5");
            h2.insert(15, "15");
            
            h1.meld(h2);
            
            assertTrue(h1.size() == 4, "Meld size incorrect");
            assertTrue(h1.findMin().key == 5, "Meld min incorrect");
            
            // h2 should be disregarded, but let's check h1 behaves
            h1.deleteMin(); // 5 gone
            assertTrue(h1.findMin().key == 10, "Next min should be 10");
            
            pass("Meld");
        } catch (Exception e) {
            fail("Meld", e.getMessage());
        }
    }

    /**
     * Test 5: Delete Specific Node
     */
    private static void testDeleteSpecific() {
        System.out.println("\n--- Test 5: Delete Specific ---");
        try {
            Heap heap = new Heap(true, true);
            Heap.HeapItem i1 = heap.insert(100, "100");
            Heap.HeapItem i2 = heap.insert(50, "50");
            Heap.HeapItem i3 = heap.insert(150, "150");
            
            heap.delete(i2); // Delete 50
            
            assertTrue(heap.size() == 2, "Size should be 2");
            assertTrue(heap.findMin().key == 100, "Min should be 100");
            
            heap.delete(i1); // Delete 100
            assertTrue(heap.findMin().key == 150, "Min should be 150");
            
            pass("Delete Specific");
        } catch (Exception e) {
            fail("Delete Specific", e.getMessage());
        }
    }

    /**
     * Test 6: Edge Cases
     */
    private static void testEdgeCases() {
        System.out.println("\n--- Test 6: Edge Cases ---");
        try {
            Heap heap = new Heap(true, true);
            
            // 1. Empty Delete
            heap.deleteMin(); // Should not crash
            
            // 2. Single Node Delete
            heap.insert(1, "1");
            heap.deleteMin();
            assertTrue(heap.size() == 0, "Heap should be empty");
            assertTrue(heap.findMin() == null, "Min should be null");
            
            // 3. Duplicates
            Heap.HeapItem a = heap.insert(10, "A");
            Heap.HeapItem b = heap.insert(10, "B");
            assertTrue(heap.size() == 2, "Duplicates size");
            heap.delete(a);
            assertTrue(heap.size() == 1, "After delete duplicate");
            assertTrue(heap.findMin().key == 10, "Remaining key is 10");
            
            pass("Edge Cases");
        } catch (Exception e) {
            fail("Edge Cases", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Test 7: Randomized Stress Test
     */
    private static void testStressRandomized() {
        System.out.println("\n--- Test 7: Randomized Stress Test ---");
        try {
            // Test configuration: Lazy Melds, Non-Lazy Decrease (Mix)
            runStressTest(true, false);
            pass("Randomized Stress Test");
        } catch (Exception e) {
            fail("Randomized Stress Test", e.getMessage());
            e.printStackTrace();
        }
    }

    private static void runStressTest(boolean lazyMelds, boolean lazyDecrease) {
        Heap heap = new Heap(lazyMelds, lazyDecrease);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Heap.HeapItem> liveItems = new ArrayList<>();
        Random rand = new Random(12345);
        
        int iterations = 3000;
        
        for (int i = 0; i < iterations; i++) {
            int op = rand.nextInt(100);
            
            if (op < 40) { // Insert
                int val = rand.nextInt(1000) + 1;
                pq.add(val);
                liveItems.add(heap.insert(val, "Val" + val));
            } 
            else if (op < 60) { // Delete Min
                if (!pq.isEmpty()) {
                    int expected = pq.poll();
                    Heap.HeapItem min = heap.findMin();
                    assertTrue(min != null, "Heap min is null but Oracle is not");
                    assertTrue(min.key == expected, "Min mismatch: Exp " + expected + " Got " + min.key);
                    
                    heap.deleteMin();
                    
                    // We need to remove the deleted item from liveItems to avoid touching it again
                    // Since we don't know exactly which Item object was deleted (if duplicates exist),
                    // we remove the first one matching the key.
                    removeFromList(liveItems, expected);
                }
            } 
            else if (op < 80) { // Decrease Key
                if (!liveItems.isEmpty()) {
                    Heap.HeapItem item = liveItems.get(rand.nextInt(liveItems.size()));
                    // Ensure we don't decrease below 0 or something weird, though heap supports it
                    if (item.key > 10) {
                        int diff = rand.nextInt(item.key - 1) + 1;
                        int oldKey = item.key;
                        
                        // Update Oracle
                        pq.remove(oldKey);
                        pq.add(oldKey - diff);
                        
                        // Update Heap
                        heap.decreaseKey(item, diff);
                    }
                }
            } 
            else { // Delete specific
                if (!liveItems.isEmpty()) {
                    Heap.HeapItem item = liveItems.get(rand.nextInt(liveItems.size()));
                    
                    pq.remove(item.key);
                    heap.delete(item);
                    liveItems.remove(item);
                }
            }
            
            if (i % 500 == 0) validateHeapStructure(heap);
        }
        
        assertTrue(heap.size() == pq.size(), "Final size mismatch");
    }

    private static void removeFromList(List<Heap.HeapItem> list, int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                list.remove(i);
                return;
            }
        }
    }

    /**
     * STRUCTURAL VALIDATION (Sanity Check)
     */
    private static void validateHeapStructure(Heap heap) {
        if (heap.size() == 0) return;

        Heap.HeapItem minItem = heap.findMin();
        assertTrue(minItem != null, "Non-empty heap has null min");
        Heap.HeapNode minNode = minItem.node;
        assertTrue(minNode != null, "Min item has null node");

        // Traverse the root list
        Heap.HeapNode current = minNode;
        int count = 0;
        Set<Heap.HeapNode> visited = new HashSet<>();
        
        if (current != null) {
            Heap.HeapNode start = current;
            do {
                count += validateTree(current, visited);
                
                // Check list consistency
                assertTrue(current.next.prev == current, "Broken next/prev link");
                assertTrue(current.prev.next == current, "Broken prev/next link");
                assertTrue(current.parent == null, "Root node has parent");
                
                current = current.next;
            } while (current != start);
        }
        
        assertTrue(count == heap.size(), "Traversed node count " + count + " != heap size " + heap.size());
    }

    private static int validateTree(Heap.HeapNode node, Set<Heap.HeapNode> visited) {
        if (visited.contains(node)) throw new RuntimeException("Cycle detected in tree!");
        visited.add(node);
        
        // Check Item-Node duality
        assertTrue(node.item != null, "Node has null item");
        assertTrue(node.item.node == node, "Item does not point back to Node");
        
        // Heap property check (Local)
        if (node.parent != null) {
            assertTrue(node.item.key >= node.parent.item.key, "Heap property violated: Child < Parent");
        }

        int size = 1;
        if (node.child != null) {
            Heap.HeapNode child = node.child;
            Heap.HeapNode start = child;
            do {
                assertTrue(child.parent == node, "Child's parent pointer is wrong");
                size += validateTree(child, visited);
                child = child.next;
            } while (child != start);
        }
        return size;
    }
}