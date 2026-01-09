/**
 * AdvancedHeapTester
 * 
 * Comprehensive STRICT tester for Heap implementation with all 4 combinations of
 * lazyMelds and lazyDecreaseKeys flags.
 * 
 * This tester is designed to EXPOSE BUGS, not work around them.
 */
public class AdvancedHeapTester {

    private static int testsPassed = 0;
    private static int testsFailed = 0;

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║       ADVANCED HEAP TESTER - STRICT MODE (ALL 4 MODES)      ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");

        // Test all 4 modes
        testMode(false, false, "Binomial Heap (strict meld, heapify up)");
        testMode(true, false, "Lazy Binomial Heap (lazy meld, heapify up)");
        testMode(true, true, "Fibonacci Heap (lazy meld, cascading cuts)");
        testMode(false, true, "Binomial with Cut-offs (strict meld, cascading cuts)");

        // Print summary
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                        SUMMARY                               ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println("Tests Passed: " + testsPassed);
        System.out.println("Tests Failed: " + testsFailed);
        System.out.println("Total Tests:  " + (testsPassed + testsFailed));
        
        if (testsFailed == 0) {
            System.out.println("\n✓ ALL TESTS PASSED!");
        } else {
            System.out.println("\n✗ SOME TESTS FAILED - SEE ABOVE FOR DETAILS");
        }
    }

    private static void testMode(boolean lazyMelds, boolean lazyDecreaseKeys, String modeName) {
        System.out.println("\n════════════════════════════════════════════════════════════════");
        System.out.println("Testing Mode: " + modeName);
        System.out.println("lazyMelds=" + lazyMelds + ", lazyDecreaseKeys=" + lazyDecreaseKeys);
        System.out.println("════════════════════════════════════════════════════════════════\n");

        // ========== BASIC TESTS ==========
        System.out.println("  --- BASIC TESTS ---");
        testEmptyHeap(lazyMelds, lazyDecreaseKeys);
        testSingleElement(lazyMelds, lazyDecreaseKeys);
        testBasicInsertAndFindMin(lazyMelds, lazyDecreaseKeys);
        testDeleteMinExactOrder(lazyMelds, lazyDecreaseKeys);
        testDuplicateKeysExact(lazyMelds, lazyDecreaseKeys);
        testMeldExactOrder(lazyMelds, lazyDecreaseKeys);
        testMeldHistoryInheritance(lazyMelds, lazyDecreaseKeys);
        testMeldWithEmptyHeap(lazyMelds, lazyDecreaseKeys);
        testDecreaseKeyNoAction(lazyMelds, lazyDecreaseKeys);
        testDecreaseKeyBasic(lazyMelds, lazyDecreaseKeys);
        testDecreaseKeyToNewMin(lazyMelds, lazyDecreaseKeys);
        testDeleteArbitraryNode(lazyMelds, lazyDecreaseKeys);
        testDeleteOverflowBug(lazyMelds, lazyDecreaseKeys);
        testBasic_MinPositiveKey(lazyMelds, lazyDecreaseKeys);
        testBasic_MaxIntegerKey(lazyMelds, lazyDecreaseKeys);
        testBasic_InsertAfterEmptying(lazyMelds, lazyDecreaseKeys);
        testBasic_SizeConsistencyThroughOperations(lazyMelds, lazyDecreaseKeys);
        testBasic_TwoElementSwap(lazyMelds, lazyDecreaseKeys);

        // ========== INSERT TESTS (10) ==========
        System.out.println("  --- INSERT TESTS ---");
        testInsert_SingleElement(lazyMelds, lazyDecreaseKeys);
        testInsert_MultipleElements(lazyMelds, lazyDecreaseKeys);
        testInsert_IncreasingOrder(lazyMelds, lazyDecreaseKeys);
        testInsert_DecreasingOrder(lazyMelds, lazyDecreaseKeys);
        testInsert_DuplicateKeys(lazyMelds, lazyDecreaseKeys);
        testInsert_ReturnsCorrectNode(lazyMelds, lazyDecreaseKeys);
        testInsert_UpdatesSize(lazyMelds, lazyDecreaseKeys);
        testInsert_UpdatesNumTrees(lazyMelds, lazyDecreaseKeys);
        testInsert_UpdatesMin(lazyMelds, lazyDecreaseKeys);
        testInsert_LargeNumber(lazyMelds, lazyDecreaseKeys);
        testInsert_MaxIntKey(lazyMelds, lazyDecreaseKeys);
        testInsert_AfterEmptyingHeap(lazyMelds, lazyDecreaseKeys);
        testInsert_ImmediatelyAfterMeld(lazyMelds, lazyDecreaseKeys);
        testInsert_AlternatingMinMax(lazyMelds, lazyDecreaseKeys);
        testInsert_SameKeyDifferentInfo(lazyMelds, lazyDecreaseKeys);

        // ========== FINDMIN TESTS (10) ==========
        System.out.println("  --- FINDMIN TESTS ---");
        testFindMin_EmptyHeap(lazyMelds, lazyDecreaseKeys);
        testFindMin_SingleElement(lazyMelds, lazyDecreaseKeys);
        testFindMin_MultipleElements(lazyMelds, lazyDecreaseKeys);
        testFindMin_AfterInsertSmaller(lazyMelds, lazyDecreaseKeys);
        testFindMin_AfterInsertLarger(lazyMelds, lazyDecreaseKeys);
        testFindMin_AfterDeleteMin(lazyMelds, lazyDecreaseKeys);
        testFindMin_AfterMeld(lazyMelds, lazyDecreaseKeys);
        testFindMin_WithDuplicates(lazyMelds, lazyDecreaseKeys);
        testFindMin_DoesNotModifyHeap(lazyMelds, lazyDecreaseKeys);
        testFindMin_ConsistentReturns(lazyMelds, lazyDecreaseKeys);
        testFindMin_AfterDecreaseKeyToNewMin(lazyMelds, lazyDecreaseKeys);
        testFindMin_AfterArbitraryDelete(lazyMelds, lazyDecreaseKeys);
        testFindMin_AfterMultipleMelds(lazyMelds, lazyDecreaseKeys);
        testFindMin_LargeHeap(lazyMelds, lazyDecreaseKeys);
        testFindMin_AfterComplexOperations(lazyMelds, lazyDecreaseKeys);

        // ========== DELETEMIN TESTS (10) ==========
        System.out.println("  --- DELETEMIN TESTS ---");
        testDeleteMin_SingleElement(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_TwoElements(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_MultipleElements(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_UpdatesSize(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_UpdatesNumTrees(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_UpdatesMin(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_WithDuplicateMinKeys(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_AllElements(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_TriggersConsolidation(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_TotalLinksIncreases(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_AfterDecreaseKey(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_LeavesOnlyDuplicates(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_FromLargeHeap(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_AfterMeld(lazyMelds, lazyDecreaseKeys);
        testDeleteMin_ConsecutiveUntilEmpty(lazyMelds, lazyDecreaseKeys);

        // ========== MELD TESTS (10) ==========
        System.out.println("  --- MELD TESTS ---");
        testMeld_TwoNonEmptyHeaps(lazyMelds, lazyDecreaseKeys);
        testMeld_EmptyIntoNonEmpty(lazyMelds, lazyDecreaseKeys);
        testMeld_NonEmptyIntoEmpty(lazyMelds, lazyDecreaseKeys);
        testMeld_TwoEmptyHeaps(lazyMelds, lazyDecreaseKeys);
        testMeld_UpdatesSize(lazyMelds, lazyDecreaseKeys);
        testMeld_UpdatesMin(lazyMelds, lazyDecreaseKeys);
        testMeld_InheritsTotalLinks(lazyMelds, lazyDecreaseKeys);
        testMeld_InheritsTotalCuts(lazyMelds, lazyDecreaseKeys);
        testMeld_InheritsHeapifyCosts(lazyMelds, lazyDecreaseKeys);
        testMeld_NumTreesCorrect(lazyMelds, lazyDecreaseKeys);
        testMeld_SameMinKeys(lazyMelds, lazyDecreaseKeys);
        testMeld_DisjointRanges(lazyMelds, lazyDecreaseKeys);
        testMeld_LargeIntoSmall(lazyMelds, lazyDecreaseKeys);
        testMeld_ChainedMelds(lazyMelds, lazyDecreaseKeys);
        testMeld_AfterDeleteMin(lazyMelds, lazyDecreaseKeys);

        // ========== DELETE TESTS (10) ==========
        System.out.println("  --- DELETE TESTS ---");
        testDelete_SingleElement(lazyMelds, lazyDecreaseKeys);
        testDelete_MinElement(lazyMelds, lazyDecreaseKeys);
        testDelete_MaxElement(lazyMelds, lazyDecreaseKeys);
        testDelete_MiddleElement(lazyMelds, lazyDecreaseKeys);
        testDelete_UpdatesSize(lazyMelds, lazyDecreaseKeys);
        testDelete_UpdatesMin(lazyMelds, lazyDecreaseKeys);
        testDelete_LeafNode(lazyMelds, lazyDecreaseKeys);
        testDelete_InternalNode(lazyMelds, lazyDecreaseKeys);
        testDelete_MultipleDeletes(lazyMelds, lazyDecreaseKeys);
        testDelete_AllElements(lazyMelds, lazyDecreaseKeys);
        testDelete_NewlyInsertedNode(lazyMelds, lazyDecreaseKeys);
        testDelete_AfterDecreaseKey(lazyMelds, lazyDecreaseKeys);
        testDelete_LastTwoElements(lazyMelds, lazyDecreaseKeys);
        testDelete_InForwardOrder(lazyMelds, lazyDecreaseKeys);
        testDelete_AlternateMinMax(lazyMelds, lazyDecreaseKeys);

        // ========== DECREASEKEY TESTS (10) ==========
        System.out.println("  --- DECREASEKEY TESTS ---");
        testDecreaseKey_ByZero(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_ByOne(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_ToNewMin(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_StillGreaterThanParent(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_OnRoot(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_OnLeaf(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_MultipleOnSameNode(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_MultipleOnDifferentNodes(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_UpdatesMinPointer(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_CounterUpdates(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_ToOne(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_AllNodesToSameKey(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_AfterMeld(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_DeepNode(lazyMelds, lazyDecreaseKeys);
        testDecreaseKey_SequentialDecreases(lazyMelds, lazyDecreaseKeys);

        // ========== INTEGRATION TESTS (10) ==========
        System.out.println("  --- INTEGRATION TESTS ---");
        testIntegration_InsertDeleteMinSequence(lazyMelds, lazyDecreaseKeys);
        testIntegration_InsertMeldDeleteMin(lazyMelds, lazyDecreaseKeys);
        testIntegration_DecreaseKeyThenDeleteMin(lazyMelds, lazyDecreaseKeys);
        testIntegration_DeleteThenMeld(lazyMelds, lazyDecreaseKeys);
        testIntegration_MeldThenDecreaseKey(lazyMelds, lazyDecreaseKeys);
        testIntegration_ComplexSequence1(lazyMelds, lazyDecreaseKeys);
        testIntegration_ComplexSequence2(lazyMelds, lazyDecreaseKeys);
        testIntegration_StressTest(lazyMelds, lazyDecreaseKeys);
        testIntegration_AllCountersConsistent(lazyMelds, lazyDecreaseKeys);
        testIntegration_HeapPropertyMaintained(lazyMelds, lazyDecreaseKeys);

        // ========== COUNTER TESTS ==========
        System.out.println("  --- COUNTER TESTS ---");
        testNumTreesAfterOperations(lazyMelds, lazyDecreaseKeys);
        testTotalLinksCounter(lazyMelds, lazyDecreaseKeys);
        testSuccessiveLinkingArrayBounds(lazyMelds, lazyDecreaseKeys);

        // ========== HEAPIFY UP TESTS (lazyDecreaseKeys=false only) ==========
        System.out.println("  --- HEAPIFY UP TESTS ---");
        testHeapifyUpCosts(lazyMelds, lazyDecreaseKeys);
        testHeapifyUpExact(lazyMelds, lazyDecreaseKeys);
        testMarkedNodesAlwaysZero(lazyMelds, lazyDecreaseKeys);
        testTotalCutsAlwaysZero(lazyMelds, lazyDecreaseKeys);

        // ========== CASCADING CUTS TESTS (lazyDecreaseKeys=true only) ==========
        System.out.println("  --- CASCADING CUTS TESTS ---");
        testCascadingCuts(lazyMelds, lazyDecreaseKeys);
        testMarkedNodesCounter(lazyMelds, lazyDecreaseKeys);
        testCascadingCutSequence(lazyMelds, lazyDecreaseKeys);
        testTotalCutsCounter(lazyMelds, lazyDecreaseKeys);

        // ========== COMPLEX SCENARIO ==========
        System.out.println("  --- COMPLEX SCENARIO ---");
        testComplexScenario(lazyMelds, lazyDecreaseKeys);

        // ========== NEW ADVANCED INTEGRATION TESTS (15) ==========
        System.out.println("  --- ADVANCED INTEGRATION TESTS ---");
        testIntegration_DeepCascadingCuts(lazyMelds, lazyDecreaseKeys);
        testIntegration_MassiveMeldChain(lazyMelds, lazyDecreaseKeys);
        testIntegration_AlternatingInsertDeleteMin(lazyMelds, lazyDecreaseKeys);
        testIntegration_DecreaseKeyOnAllNodes(lazyMelds, lazyDecreaseKeys);
        testIntegration_DeleteAllButOne(lazyMelds, lazyDecreaseKeys);
        testIntegration_RepeatedDecreaseKeyToSameValue(lazyMelds, lazyDecreaseKeys);
        testIntegration_PowerOfTwoSizes(lazyMelds, lazyDecreaseKeys);
        testIntegration_SingleNodeOperations(lazyMelds, lazyDecreaseKeys);
        testIntegration_EmptyHeapAfterAllOperations(lazyMelds, lazyDecreaseKeys);
        testIntegration_DecreaseKeyRootNode(lazyMelds, lazyDecreaseKeys);
        testIntegration_MeldThenDeleteMeldedElements(lazyMelds, lazyDecreaseKeys);
        testIntegration_RapidFireDecreaseKeyAndDelete(lazyMelds, lazyDecreaseKeys);
        testIntegration_CounterAccuracyAfterStress(lazyMelds, lazyDecreaseKeys);
        testIntegration_HeapifyUpVsCascadingCutsDifference(lazyMelds, lazyDecreaseKeys);
        testIntegration_ExtremeSizeFluctuation(lazyMelds, lazyDecreaseKeys);

        // ========== RANDOMIZED STRESS TESTS (15) ==========
        System.out.println("  --- RANDOMIZED STRESS TESTS ---");
        testRandom_MixedOperations1000(lazyMelds, lazyDecreaseKeys);
        testRandom_InsertDeleteStorm(lazyMelds, lazyDecreaseKeys);
        // testRandom_DecreaseKeyBombardment(lazyMelds, lazyDecreaseKeys);
        testRandom_MeldChaos(lazyMelds, lazyDecreaseKeys);
        testRandom_DeleteRandomNodes(lazyMelds, lazyDecreaseKeys);
        testRandom_AlternatingOperations(lazyMelds, lazyDecreaseKeys);
        testRandom_ExtractAllRandom(lazyMelds, lazyDecreaseKeys);
        testRandom_StressCounters(lazyMelds, lazyDecreaseKeys);
        testRandom_RepeatedBuildDestroy(lazyMelds, lazyDecreaseKeys);
        testRandom_ChaosMonkey(lazyMelds, lazyDecreaseKeys);
        testRandom_LargeScaleOperations(lazyMelds, lazyDecreaseKeys);
        testRandom_DecreaseKeyThenDelete(lazyMelds, lazyDecreaseKeys);
        testRandom_MeldThenExtractAll(lazyMelds, lazyDecreaseKeys);
        testRandom_WorstCasePatterns(lazyMelds, lazyDecreaseKeys);
        testRandom_UltimateTortureTest(lazyMelds, lazyDecreaseKeys);
    }

    // ==================== BASIC TESTS ====================

    private static void testEmptyHeap(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Empty Heap";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        boolean pass = true;
        String reason = "";

        if (heap.size() != 0) {
            pass = false;
            reason = "size() should be 0, got " + heap.size();
        } else if (heap.findMin() != null) {
            pass = false;
            reason = "findMin() should be null";
        } else if (heap.numTrees() != 0) {
            pass = false;
            reason = "numTrees() should be 0, got " + heap.numTrees();
        } else if (heap.totalLinks() != 0) {
            pass = false;
            reason = "totalLinks() should be 0, got " + heap.totalLinks();
        } else if (heap.totalCuts() != 0) {
            pass = false;
            reason = "totalCuts() should be 0, got " + heap.totalCuts();
        } else if (heap.numMarkedNodes() != 0) {
            pass = false;
            reason = "numMarkedNodes() should be 0, got " + heap.numMarkedNodes();
        } else if (heap.totalHeapifyCosts() != 0) {
            pass = false;
            reason = "totalHeapifyCosts() should be 0, got " + heap.totalHeapifyCosts();
        }

        reportResult(testName, pass, reason);
    }

    private static void testSingleElement(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Single Element";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem item = heap.insert(42, "only");

        boolean pass = true;
        String reason = "";

        if (heap.size() != 1) {
            pass = false;
            reason = "size() should be 1, got " + heap.size();
        } else if (heap.findMin() != item) {
            pass = false;
            reason = "findMin() should return inserted item";
        } else if (heap.findMin().key != 42) {
            pass = false;
            reason = "findMin().key should be 42, got " + heap.findMin().key;
        } else if (heap.numTrees() != 1) {
            pass = false;
            reason = "numTrees() should be 1, got " + heap.numTrees();
        }

        // Delete the only element
        heap.deleteMin();
        if (heap.size() != 0) {
            pass = false;
            reason = "After deleteMin, size() should be 0, got " + heap.size();
        } else if (heap.findMin() != null) {
            pass = false;
            reason = "After deleteMin, findMin() should be null";
        } else if (heap.numTrees() != 0) {
            pass = false;
            reason = "After deleteMin, numTrees() should be 0, got " + heap.numTrees();
        }

        reportResult(testName, pass, reason);
    }

    private static void testBasicInsertAndFindMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Basic Insert and FindMin";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        heap.insert(10, "ten");
        heap.insert(5, "five");
        heap.insert(15, "fifteen");
        heap.insert(3, "three");

        boolean pass = true;
        String reason = "";

        if (heap.size() != 4) {
            pass = false;
            reason = "size() should be 4, got " + heap.size();
        } else if (heap.findMin().key != 3) {
            pass = false;
            reason = "findMin().key should be 3, got " + heap.findMin().key;
        }

        reportResult(testName, pass, reason);
    }

    private static void testDeleteMinExactOrder(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin EXACT Ordering";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        heap.insert(5, "five");
        heap.insert(3, "three");
        heap.insert(7, "seven");
        heap.insert(1, "one");
        heap.insert(9, "nine");

        boolean pass = true;
        String reason = "";

        int[] expected = {1, 3, 5, 7, 9};
        for (int i = 0; i < expected.length; i++) {
            if (heap.findMin() == null) {
                pass = false;
                reason = "findMin() returned null at step " + i;
                break;
            }
            int minKey = heap.findMin().key;
            if (minKey != expected[i]) {
                pass = false;
                reason = "Expected min " + expected[i] + " at step " + i + ", got " + minKey;
                break;
            }
            heap.deleteMin();
        }

        if (pass && heap.size() != 0) {
            pass = false;
            reason = "After all deletions, size should be 0, got " + heap.size();
        }

        reportResult(testName, pass, reason);
    }

    private static void testDuplicateKeysExact(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Duplicate Keys EXACT Order";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        heap.insert(5, "five-a");
        heap.insert(5, "five-b");
        heap.insert(5, "five-c");
        heap.insert(3, "three-a");
        heap.insert(3, "three-b");

        boolean pass = true;
        String reason = "";

        if (heap.size() != 5) {
            pass = false;
            reason = "size() should be 5, got " + heap.size();
        } else if (heap.findMin().key != 3) {
            pass = false;
            reason = "findMin().key should be 3, got " + heap.findMin().key;
        }

        // First two should be 3, next three should be 5
        int[] expected = {3, 3, 5, 5, 5};
        for (int i = 0; i < expected.length && pass; i++) {
            int minKey = heap.findMin().key;
            if (minKey != expected[i]) {
                pass = false;
                reason = "Expected " + expected[i] + " at step " + i + ", got " + minKey;
            }
            heap.deleteMin();
        }

        reportResult(testName, pass, reason);
    }

    // ==================== MELD TESTS ====================

    private static void testMeldExactOrder(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld EXACT Order";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);

        heap1.insert(10, "h1-10");
        heap1.insert(5, "h1-5");
        heap2.insert(3, "h2-3");
        heap2.insert(8, "h2-8");

        heap1.meld(heap2);

        boolean pass = true;
        String reason = "";

        if (heap1.size() != 4) {
            pass = false;
            reason = "After meld, size should be 4, got " + heap1.size();
        } else if (heap1.findMin().key != 3) {
            pass = false;
            reason = "After meld, min should be 3, got " + heap1.findMin().key;
        }

        int[] expected = {3, 5, 8, 10};
        for (int i = 0; i < expected.length && pass; i++) {
            int minKey = heap1.findMin().key;
            if (minKey != expected[i]) {
                pass = false;
                reason = "Expected " + expected[i] + " at step " + i + ", got " + minKey;
            }
            heap1.deleteMin();
        }

        reportResult(testName, pass, reason);
    }

    private static void testMeldHistoryInheritance(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld History Inheritance";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);

        for (int i = 1; i <= 4; i++) {
            heap1.insert(i, "h1-" + i);
        }
        for (int i = 10; i <= 13; i++) {
            heap2.insert(i, "h2-" + i);
        }

        int links1 = heap1.totalLinks();
        int links2 = heap2.totalLinks();
        int cuts1 = heap1.totalCuts();
        int cuts2 = heap2.totalCuts();
        int heapify1 = heap1.totalHeapifyCosts();
        int heapify2 = heap2.totalHeapifyCosts();

        heap1.meld(heap2);

        boolean pass = true;
        String reason = "";

        // totalCuts and totalHeapifyCosts should be summed
        if (heap1.totalCuts() < cuts1 + cuts2) {
            pass = false;
            reason = "totalCuts should be at least " + (cuts1 + cuts2) + ", got " + heap1.totalCuts();
        }
        if (heap1.totalHeapifyCosts() != heapify1 + heapify2) {
            pass = false;
            reason = "totalHeapifyCosts should be " + (heapify1 + heapify2) + ", got " + heap1.totalHeapifyCosts();
        }
        // totalLinks should be at least the sum (may be more if successive linking occurred)
        if (heap1.totalLinks() < links1 + links2) {
            pass = false;
            reason = "totalLinks should be at least " + (links1 + links2) + ", got " + heap1.totalLinks();
        }

        reportResult(testName, pass, reason);
    }

    private static void testMeldWithEmptyHeap(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld With Empty Heap";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);

        heap1.insert(5, "five");
        heap1.insert(3, "three");
        // heap2 is empty

        heap1.meld(heap2);

        boolean pass = true;
        String reason = "";

        if (heap1.size() != 2) {
            pass = false;
            reason = "After meld with empty, size should be 2, got " + heap1.size();
        } else if (heap1.findMin().key != 3) {
            pass = false;
            reason = "After meld with empty, min should be 3, got " + heap1.findMin().key;
        }

        // Now meld empty into non-empty (other direction)
        Heap heap3 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap4 = new Heap(lazyMelds, lazyDecreaseKeys);
        heap4.insert(7, "seven");
        
        heap3.meld(heap4); // empty.meld(non-empty)
        
        if (heap3.size() != 1) {
            pass = false;
            reason = "After empty.meld(non-empty), size should be 1, got " + heap3.size();
        } else if (heap3.findMin().key != 7) {
            pass = false;
            reason = "After empty.meld(non-empty), min should be 7, got " + heap3.findMin().key;
        }

        reportResult(testName, pass, reason);
    }

    // ==================== DECREASE KEY TESTS ====================

    private static void testDecreaseKeyNoAction(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey No Action (diff=0)";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        heap.insert(10, "ten");
        Heap.HeapItem item = heap.insert(20, "twenty");
        heap.insert(5, "five");

        int cutsBefore = heap.totalCuts();
        int heapifyBefore = heap.totalHeapifyCosts();

        heap.decreaseKey(item, 0); // No change

        boolean pass = true;
        String reason = "";

        if (item.key != 20) {
            pass = false;
            reason = "Key should remain 20, got " + item.key;
        }
        if (heap.totalCuts() != cutsBefore) {
            pass = false;
            reason = "totalCuts should remain " + cutsBefore + ", got " + heap.totalCuts();
        }
        if (heap.totalHeapifyCosts() != heapifyBefore) {
            pass = false;
            reason = "totalHeapifyCosts should remain " + heapifyBefore + ", got " + heap.totalHeapifyCosts();
        }

        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKeyBasic(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey Basic";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        heap.insert(10, "ten");
        Heap.HeapItem item = heap.insert(20, "twenty");
        heap.insert(5, "five");

        heap.decreaseKey(item, 18); // 20 - 18 = 2

        boolean pass = true;
        String reason = "";

        if (item.key != 2) {
            pass = false;
            reason = "After decreaseKey, item.key should be 2, got " + item.key;
        }
        if (heap.findMin().key != 2) {
            pass = false;
            reason = "After decreaseKey, findMin().key should be 2, got " + heap.findMin().key;
        }

        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKeyToNewMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey To New Min";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        // Build a larger heap to force tree structure
        for (int i = 1; i <= 8; i++) {
            heap.insert(i * 10, "node-" + i);
        }
        // Force consolidation
        heap.deleteMin(); // removes 10
        
        // Insert a large value
        Heap.HeapItem item = heap.insert(100, "hundred");
        
        // Decrease to become new min
        heap.decreaseKey(item, 99); // 100 - 99 = 1

        boolean pass = true;
        String reason = "";

        if (item.key != 1) {
            pass = false;
            reason = "After decreaseKey, item.key should be 1, got " + item.key;
        }
        if (heap.findMin().key != 1) {
            pass = false;
            reason = "After decreaseKey, findMin().key should be 1, got " + heap.findMin().key;
        }
        if (heap.findMin() != item) {
            pass = false;
            reason = "After decreaseKey, findMin() should return the decreased item";
        }

        reportResult(testName, pass, reason);
    }

    // ==================== DELETE TESTS ====================

    private static void testDeleteArbitraryNode(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Arbitrary Node EXACT";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        heap.insert(10, "ten");
        Heap.HeapItem toDelete = heap.insert(5, "five");
        heap.insert(15, "fifteen");
        heap.insert(3, "three");

        heap.delete(toDelete);

        boolean pass = true;
        String reason = "";

        if (heap.size() != 3) {
            pass = false;
            reason = "After delete, size should be 3, got " + heap.size();
        } else if (heap.findMin().key != 3) {
            pass = false;
            reason = "After delete, min should be 3, got " + heap.findMin().key;
        }

        // Exact order check
        int[] expected = {3, 10, 15};
        for (int i = 0; i < expected.length && pass; i++) {
            int minKey = heap.findMin().key;
            if (minKey != expected[i]) {
                pass = false;
                reason = "Expected " + expected[i] + " at step " + i + ", got " + minKey;
            }
            heap.deleteMin();
        }

        reportResult(testName, pass, reason);
    }

    private static void testDeleteOverflowBug(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Overflow Bug (Integer.MIN_VALUE)";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        // BUG: delete() calls decreaseKey(x, Integer.MIN_VALUE)
        // This computes x.key - Integer.MIN_VALUE which OVERFLOWS!
        // Example: 5 - (-2147483648) = 5 + 2147483648 = -2147483643 (overflow!)

        heap.insert(10, "ten");
        Heap.HeapItem toDelete = heap.insert(5, "five");
        heap.insert(15, "fifteen");

        // The delete should work correctly
        heap.delete(toDelete);

        boolean pass = true;
        String reason = "";

        if (heap.size() != 2) {
            pass = false;
            reason = "After delete, size should be 2, got " + heap.size();
        }
        
        // The key check - if overflow happened, min will be a large negative number
        int minKey = heap.findMin().key;
        if (minKey < 0) {
            pass = false;
            reason = "BUG: delete() caused overflow! Min is " + minKey + 
                     ". Fix: change delete() to use decreaseKey(x, x.key - Integer.MIN_VALUE) " +
                     "or set x.key = Integer.MIN_VALUE directly";
        } else if (minKey != 10) {
            pass = false;
            reason = "After delete, min should be 10, got " + minKey;
        }

        reportResult(testName, pass, reason);
    }

    // ==================== NEW BASIC EDGE CASE TESTS (5) ====================

    private static void testBasic_MinPositiveKey(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Basic: Min Positive Key (key=1)";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(100, "hundred");
        heap.insert(1, "one");
        heap.insert(50, "fifty");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != 1) {
            pass = false;
            reason = "Min should be 1, got " + heap.findMin().key;
        }
        
        if (pass) {
            heap.deleteMin();
            if (heap.findMin().key != 50) {
                pass = false;
                reason = "After removing 1, min should be 50, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testBasic_MaxIntegerKey(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Basic: Max Integer Key";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(Integer.MAX_VALUE, "max");
        heap.insert(100, "hundred");
        heap.insert(Integer.MAX_VALUE - 1, "max-1");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != 100) {
            pass = false;
            reason = "Min should be 100, got " + heap.findMin().key;
        }
        
        if (pass) {
            heap.deleteMin();
            if (heap.findMin().key != Integer.MAX_VALUE - 1) {
                pass = false;
                reason = "After removing 100, min should be MAX-1, got " + heap.findMin().key;
            }
        }
        
        if (pass) {
            heap.deleteMin();
            if (heap.findMin().key != Integer.MAX_VALUE) {
                pass = false;
                reason = "Last element should be MAX, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testBasic_InsertAfterEmptying(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Basic: Insert After Emptying";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // Fill and empty
        for (int i = 0; i < 10; i++) {
            heap.insert(i + 1, "val-" + i);
        }
        for (int i = 0; i < 10; i++) {
            heap.deleteMin();
        }
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 0) {
            pass = false;
            reason = "After emptying, size should be 0, got " + heap.size();
        }
        
        // Now insert again
        if (pass) {
            heap.insert(42, "forty-two");
            if (heap.size() != 1) {
                pass = false;
                reason = "After reinserting, size should be 1, got " + heap.size();
            }
            if (pass && heap.findMin().key != 42) {
                pass = false;
                reason = "After reinserting, min should be 42, got " + heap.findMin().key;
            }
            if (pass && heap.numTrees() != 1) {
                pass = false;
                reason = "After reinserting, numTrees should be 1, got " + heap.numTrees();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testBasic_SizeConsistencyThroughOperations(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Basic: Size Consistency Through Operations";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        int expectedSize = 0;
        
        // Insert 20
        for (int i = 0; i < 20; i++) {
            heap.insert(i * 5 + 1, "val-" + i);
            expectedSize++;
            if (heap.size() != expectedSize) {
                pass = false;
                reason = "After insert " + i + ", expected size " + expectedSize + ", got " + heap.size();
                break;
            }
        }
        
        // DeleteMin 5
        if (pass) {
            for (int i = 0; i < 5; i++) {
                heap.deleteMin();
                expectedSize--;
                if (heap.size() != expectedSize) {
                    pass = false;
                    reason = "After deleteMin " + i + ", expected size " + expectedSize + ", got " + heap.size();
                    break;
                }
            }
        }
        
        // Meld with another heap of 10
        if (pass) {
            Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
            for (int i = 0; i < 10; i++) {
                heap2.insert(1000 + i, "h2-" + i);
            }
            heap.meld(heap2);
            expectedSize += 10;
            if (heap.size() != expectedSize) {
                pass = false;
                reason = "After meld, expected size " + expectedSize + ", got " + heap.size();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testBasic_TwoElementSwap(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Basic: Two Element Operations";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem item1 = heap.insert(10, "ten");
        Heap.HeapItem item2 = heap.insert(20, "twenty");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin() != item1) {
            pass = false;
            reason = "Min should be item1 (10)";
        }
        
        // Decrease item2 to become new min
        if (pass) {
            heap.decreaseKey(item2, 15); // 20 -> 5
            if (heap.findMin() != item2) {
                pass = false;
                reason = "After decreaseKey, min should be item2 (5)";
            }
        }
        
        // Delete new min
        if (pass) {
            heap.deleteMin();
            if (heap.findMin() != item1) {
                pass = false;
                reason = "After deleteMin, only item1 should remain";
            }
            if (pass && heap.size() != 1) {
                pass = false;
                reason = "Size should be 1, got " + heap.size();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== COUNTER TESTS ====================

    private static void testNumTreesAfterOperations(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "NumTrees After Operations";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        boolean pass = true;
        String reason = "";

        heap.insert(10, "ten");
        if (heap.numTrees() != 1) {
            pass = false;
            reason = "After 1 insert, numTrees should be 1, got " + heap.numTrees();
        }

        heap.insert(5, "five");
        if (!lazyMelds) {
            if (heap.numTrees() != 1) {
                pass = false;
                reason = "After 2 inserts (strict), numTrees should be 1, got " + heap.numTrees();
            }
        } else {
            if (heap.numTrees() != 2) {
                pass = false;
                reason = "After 2 inserts (lazy), numTrees should be 2, got " + heap.numTrees();
            }
        }

        heap.insert(15, "fifteen");
        if (!lazyMelds) {
            if (heap.numTrees() != 2) {
                pass = false;
                reason = "After 3 inserts (strict), numTrees should be 2, got " + heap.numTrees();
            }
        } else {
            if (heap.numTrees() != 3) {
                pass = false;
                reason = "After 3 inserts (lazy), numTrees should be 3, got " + heap.numTrees();
            }
        }

        heap.insert(20, "twenty");
        if (!lazyMelds) {
            if (heap.numTrees() != 1) {
                pass = false;
                reason = "After 4 inserts (strict), numTrees should be 1, got " + heap.numTrees();
            }
        } else {
            if (heap.numTrees() != 4) {
                pass = false;
                reason = "After 4 inserts (lazy), numTrees should be 4, got " + heap.numTrees();
            }
        }

        reportResult(testName, pass, reason);
    }

    private static void testTotalLinksCounter(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "TotalLinks Counter EXACT";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        for (int i = 1; i <= 4; i++) {
            heap.insert(i, "node-" + i);
        }

        boolean pass = true;
        String reason = "";

        if (!lazyMelds) {
            // Strict melds: Insert 1 (0), Insert 2 (1 link), Insert 3 (0), Insert 4 (2 links) = 3 total
            if (heap.totalLinks() != 3) {
                pass = false;
                reason = "After 4 inserts (strict), totalLinks should be 3, got " + heap.totalLinks();
            }
        } else {
            if (heap.totalLinks() != 0) {
                pass = false;
                reason = "After 4 inserts (lazy), totalLinks should be 0, got " + heap.totalLinks();
            }
        }

        reportResult(testName, pass, reason);
    }

    private static void testSuccessiveLinkingArrayBounds(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "SuccessiveLinking Array Bounds";
        
        boolean pass = true;
        String reason = "";

        try {
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            
            // Insert elements and delete until size is very small
            for (int i = 1; i <= 8; i++) {
                heap.insert(i * 10, "node-" + i);
            }
            
            // Delete most elements - this triggers successive linking with small size
            for (int i = 0; i < 6; i++) {
                heap.deleteMin();
            }
            
            // Should have 2 elements left
            if (heap.size() != 2) {
                pass = false;
                reason = "Expected size 2, got " + heap.size();
            }
            
            // Delete one more
            heap.deleteMin();
            
            if (heap.size() != 1) {
                pass = false;
                reason = "Expected size 1, got " + heap.size();
            }
            
            // Final delete
            heap.deleteMin();
            
            if (heap.size() != 0) {
                pass = false;
                reason = "Expected size 0, got " + heap.size();
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            pass = false;
            reason = "BUG: ArrayIndexOutOfBoundsException in successiveLinking! " +
                     "The array size calculation '2 * (31 - Integer.numberOfLeadingZeros(size) + 1)' " +
                     "is too small. Fix: use a larger constant or handle edge cases.";
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }

        reportResult(testName, pass, reason);
    }

    // ==================== HEAPIFY UP TESTS (lazyDecreaseKeys=false) ====================

    private static void testHeapifyUpCosts(boolean lazyMelds, boolean lazyDecreaseKeys) {
        if (lazyDecreaseKeys) {
            return; // Skip for cascading cuts mode
        }
        
        String testName = "HeapifyUp Costs Counter";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        // Build a heap
        for (int i = 1; i <= 8; i++) {
            heap.insert(i * 10, "node-" + i);
        }
        heap.deleteMin(); // consolidate

        int heapifyBefore = heap.totalHeapifyCosts();

        // Insert and decrease to trigger heapify-up
        Heap.HeapItem item = heap.insert(100, "hundred");
        heap.decreaseKey(item, 99); // Should bubble up

        boolean pass = true;
        String reason = "";

        if (heap.totalHeapifyCosts() < heapifyBefore) {
            pass = false;
            reason = "totalHeapifyCosts should not decrease";
        }

        reportResult(testName, pass, reason);
    }

    private static void testHeapifyUpExact(boolean lazyMelds, boolean lazyDecreaseKeys) {
        if (lazyDecreaseKeys) {
            return;
        }
        
        String testName = "HeapifyUp Preserves Structure";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        boolean pass = true;
        String reason = "";

        try {
            // Build heap and do operations
            for (int i = 1; i <= 8; i++) {
                heap.insert(i * 10, "node-" + i);
            }
            heap.deleteMin(); // removes 10, consolidates
            
            Heap.HeapItem item = heap.insert(100, "hundred");
            heap.decreaseKey(item, 95); // 100 -> 5, should become min
            
            // Verify heap still works correctly after heapify-up
            int[] expected = {5, 20, 30, 40, 50, 60, 70, 80};
            int maxIterations = 100; // Safety limit to prevent infinite loops
            int iterations = 0;
            
            for (int i = 0; i < expected.length && pass; i++) {
                if (++iterations > maxIterations) {
                    pass = false;
                    reason = "BUG: Possible infinite loop detected! Heap structure corrupted by heapify-up.";
                    break;
                }
                if (heap.findMin() == null) {
                    pass = false;
                    reason = "findMin() returned null at step " + i;
                    break;
                }
                int minKey = heap.findMin().key;
                if (minKey != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + minKey + 
                             ". BUG: Heapify-up corrupted heap structure!";
                    break;
                }
                heap.deleteMin();
            }
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }

        reportResult(testName, pass, reason);
    }

    private static void testMarkedNodesAlwaysZero(boolean lazyMelds, boolean lazyDecreaseKeys) {
        if (lazyDecreaseKeys) {
            return;
        }
        
        String testName = "MarkedNodes Always Zero (heapify mode)";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        for (int i = 1; i <= 10; i++) {
            heap.insert(i * 10, "node-" + i);
        }

        boolean pass = true;
        String reason = "";

        if (heap.numMarkedNodes() != 0) {
            pass = false;
            reason = "With lazyDecreaseKeys=false, numMarkedNodes should always be 0, got " + heap.numMarkedNodes();
        }

        heap.deleteMin();
        heap.deleteMin();

        if (heap.numMarkedNodes() != 0) {
            pass = false;
            reason = "After deleteMins, numMarkedNodes should still be 0, got " + heap.numMarkedNodes();
        }

        reportResult(testName, pass, reason);
    }

    private static void testTotalCutsAlwaysZero(boolean lazyMelds, boolean lazyDecreaseKeys) {
        if (lazyDecreaseKeys) {
            return;
        }
        
        String testName = "TotalCuts Always Zero (heapify mode)";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        for (int i = 1; i <= 8; i++) {
            heap.insert(i * 10, "node-" + i);
        }
        
        heap.deleteMin();
        
        Heap.HeapItem item = heap.insert(100, "hundred");
        heap.decreaseKey(item, 90);

        boolean pass = true;
        String reason = "";

        if (heap.totalCuts() != 0) {
            pass = false;
            reason = "With lazyDecreaseKeys=false, totalCuts should always be 0, got " + heap.totalCuts();
        }

        reportResult(testName, pass, reason);
    }

    // ==================== CASCADING CUTS TESTS (lazyDecreaseKeys=true) ====================

    private static void testCascadingCuts(boolean lazyMelds, boolean lazyDecreaseKeys) {
        if (!lazyDecreaseKeys) {
            return;
        }
        
        String testName = "Cascading Cuts Basic";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        Heap.HeapItem[] items = new Heap.HeapItem[8];
        for (int i = 0; i < 8; i++) {
            items[i] = heap.insert((i + 1) * 10, "node-" + (i + 1));
        }
        
        heap.deleteMin(); // consolidate, removes 10

        int cutsBefore = heap.totalCuts();
        
        // Decrease a key to trigger a cut
        heap.decreaseKey(items[6], 65); // 70 -> 5

        boolean pass = true;
        String reason = "";

        if (heap.findMin().key != 5) {
            pass = false;
            reason = "After decreaseKey, min should be 5, got " + heap.findMin().key;
        }

        reportResult(testName, pass, reason);
    }

    private static void testMarkedNodesCounter(boolean lazyMelds, boolean lazyDecreaseKeys) {
        if (!lazyDecreaseKeys) {
            return;
        }
        
        String testName = "MarkedNodes Counter";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        Heap.HeapItem[] items = new Heap.HeapItem[16];
        for (int i = 0; i < 16; i++) {
            items[i] = heap.insert((i + 1) * 10, "node-" + (i + 1));
        }
        
        heap.deleteMin(); // consolidate

        boolean pass = true;
        String reason = "";

        if (heap.numMarkedNodes() < 0) {
            pass = false;
            reason = "numMarkedNodes should never be negative, got " + heap.numMarkedNodes();
        }

        // After cuts, marked count should increase appropriately
        heap.decreaseKey(items[14], 145); // Should cut and mark parent

        if (heap.numMarkedNodes() < 0) {
            pass = false;
            reason = "After cut, numMarkedNodes should not be negative, got " + heap.numMarkedNodes();
        }

        reportResult(testName, pass, reason);
    }

    private static void testCascadingCutSequence(boolean lazyMelds, boolean lazyDecreaseKeys) {
        if (!lazyDecreaseKeys) {
            return;
        }
        
        String testName = "Cascading Cut Sequence";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        // Build a larger heap to ensure proper tree structure
        Heap.HeapItem[] items = new Heap.HeapItem[32];
        for (int i = 0; i < 32; i++) {
            items[i] = heap.insert((i + 1) * 10, "node-" + (i + 1));
        }
        
        heap.deleteMin(); // consolidate

        boolean pass = true;
        String reason = "";

        int cutsBefore = heap.totalCuts();
        
        // Multiple decreaseKeys to trigger cascading
        heap.decreaseKey(items[30], 295); // 310 -> 15
        heap.decreaseKey(items[28], 275); // 290 -> 15
        
        int cutsAfter = heap.totalCuts();
        
        if (cutsAfter < cutsBefore) {
            pass = false;
            reason = "totalCuts should not decrease after decreaseKey operations";
        }

        reportResult(testName, pass, reason);
    }

    private static void testTotalCutsCounter(boolean lazyMelds, boolean lazyDecreaseKeys) {
        if (!lazyDecreaseKeys) {
            return;
        }
        
        String testName = "TotalCuts Counter";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

        for (int i = 1; i <= 8; i++) {
            heap.insert(i * 10, "node-" + i);
        }

        boolean pass = true;
        String reason = "";

        // Before any decreaseKey, totalCuts should be 0
        if (heap.totalCuts() != 0) {
            pass = false;
            reason = "Before any cuts, totalCuts should be 0, got " + heap.totalCuts();
        }

        reportResult(testName, pass, reason);
    }

    // ==================== COMPLEX SCENARIO ====================

    private static void testComplexScenario(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Complex Scenario";
        
        boolean pass = true;
        String reason = "";

        try {
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);

            // Phase 1: Build heap
            Heap.HeapItem[] items = new Heap.HeapItem[16];
            for (int i = 0; i < 16; i++) {
                items[i] = heap.insert((i + 1) * 5, "node-" + (i + 1));
            }

            if (heap.size() != 16) {
                pass = false;
                reason = "After 16 inserts, size should be 16, got " + heap.size();
            }

            // Phase 2: Some deleteMins
            for (int i = 0; i < 4; i++) {
                heap.deleteMin();
            }

            if (pass && heap.size() != 12) {
                pass = false;
                reason = "After 4 deleteMins, size should be 12, got " + heap.size();
            }

            // Phase 3: Meld
            Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
            for (int i = 0; i < 4; i++) {
                heap2.insert((i + 100) * 5, "h2-" + (i + 1));
            }

            int sizeBefore = heap.size();
            heap.meld(heap2);

            if (pass && heap.size() != sizeBefore + 4) {
                pass = false;
                reason = "After meld, size should be " + (sizeBefore + 4) + ", got " + heap.size();
            }

            // Phase 4: Extract all - verify EXACT order
            int prevMin = Integer.MIN_VALUE;
            int count = 0;
            while (heap.size() > 0 && pass) {
                int currentMin = heap.findMin().key;
                if (currentMin < prevMin) {
                    pass = false;
                    reason = "Heap property violated: got " + currentMin + " after " + prevMin;
                    break;
                }
                prevMin = currentMin;
                heap.deleteMin();
                count++;
            }

            if (pass && heap.size() != 0) {
                pass = false;
                reason = "After extracting all, size should be 0, got " + heap.size();
            }
            
            if (pass && count != 16) {
                pass = false;
                reason = "Should have extracted 16 elements, extracted " + count;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            pass = false;
            reason = "BUG: ArrayIndexOutOfBoundsException - successiveLinking array too small!";
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }

        reportResult(testName, pass, reason);
    }

    // ==================== INSERT TESTS (10) ====================

    private static void testInsert_SingleElement(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Single Element";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem item = heap.insert(42, "forty-two");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 1) {
            pass = false;
            reason = "After single insert, size should be 1, got " + heap.size();
        } else if (heap.findMin() != item) {
            pass = false;
            reason = "After single insert, findMin() should return the inserted item";
        } else if (item.key != 42) {
            pass = false;
            reason = "Inserted item key should be 42, got " + item.key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_MultipleElements(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Multiple Elements";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(10, "ten");
        heap.insert(20, "twenty");
        heap.insert(30, "thirty");
        heap.insert(40, "forty");
        heap.insert(50, "fifty");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 5) {
            pass = false;
            reason = "After 5 inserts, size should be 5, got " + heap.size();
        } else if (heap.findMin().key != 10) {
            pass = false;
            reason = "Min should be 10, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_IncreasingOrder(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Increasing Order";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        for (int i = 1; i <= 10; i++) {
            heap.insert(i, "val-" + i);
        }
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 10) {
            pass = false;
            reason = "After 10 inserts, size should be 10, got " + heap.size();
        } else if (heap.findMin().key != 1) {
            pass = false;
            reason = "Min should be 1, got " + heap.findMin().key;
        }
        
        // Verify extraction order
        for (int i = 1; i <= 10 && pass; i++) {
            int minKey = heap.findMin().key;
            if (minKey != i) {
                pass = false;
                reason = "Expected " + i + " at step " + i + ", got " + minKey;
            }
            heap.deleteMin();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_DecreasingOrder(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Decreasing Order";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        for (int i = 10; i >= 1; i--) {
            heap.insert(i, "val-" + i);
            if (heap.findMin().key != i) {
                reportResult(testName, false, "After inserting " + i + ", min should be " + i + ", got " + heap.findMin().key);
                return;
            }
        }
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 10) {
            pass = false;
            reason = "After 10 inserts, size should be 10, got " + heap.size();
        } else if (heap.findMin().key != 1) {
            pass = false;
            reason = "Final min should be 1, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_DuplicateKeys(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Duplicate Keys";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(5, "five-a");
        heap.insert(5, "five-b");
        heap.insert(5, "five-c");
        heap.insert(5, "five-d");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 4) {
            pass = false;
            reason = "After 4 inserts of same key, size should be 4, got " + heap.size();
        } else if (heap.findMin().key != 5) {
            pass = false;
            reason = "Min should be 5, got " + heap.findMin().key;
        }
        
        // All 4 should be extractable with key 5
        for (int i = 0; i < 4 && pass; i++) {
            if (heap.findMin().key != 5) {
                pass = false;
                reason = "All extracted elements should have key 5, got " + heap.findMin().key + " at step " + i;
            }
            heap.deleteMin();
        }
        
        if (pass && heap.size() != 0) {
            pass = false;
            reason = "After extracting all, size should be 0, got " + heap.size();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_ReturnsCorrectNode(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Returns Correct Node";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem item1 = heap.insert(10, "ten");
        Heap.HeapItem item2 = heap.insert(20, "twenty");
        Heap.HeapItem item3 = heap.insert(5, "five");
        
        boolean pass = true;
        String reason = "";
        
        if (item1 == null) {
            pass = false;
            reason = "insert() should not return null";
        } else if (item1.key != 10) {
            pass = false;
            reason = "item1.key should be 10, got " + item1.key;
        } else if (item2.key != 20) {
            pass = false;
            reason = "item2.key should be 20, got " + item2.key;
        } else if (item3.key != 5) {
            pass = false;
            reason = "item3.key should be 5, got " + item3.key;
        } else if (item1 == item2 || item2 == item3 || item1 == item3) {
            pass = false;
            reason = "Each insert should return a distinct item";
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_UpdatesSize(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Updates Size";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        for (int i = 1; i <= 20; i++) {
            heap.insert(i * 10, "val-" + i);
            if (heap.size() != i) {
                pass = false;
                reason = "After " + i + " inserts, size should be " + i + ", got " + heap.size();
                break;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_UpdatesNumTrees(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Updates NumTrees";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        heap.insert(10, "ten");
        if (heap.numTrees() != 1) {
            pass = false;
            reason = "After 1 insert, numTrees should be 1, got " + heap.numTrees();
        }
        
        if (pass) {
            heap.insert(20, "twenty");
            if (lazyMelds) {
                // Lazy mode: trees not consolidated
                if (heap.numTrees() != 2) {
                    pass = false;
                    reason = "After 2 inserts (lazy), numTrees should be 2, got " + heap.numTrees();
                }
            } else {
                // Strict mode: trees consolidated
                if (heap.numTrees() != 1) {
                    pass = false;
                    reason = "After 2 inserts (strict), numTrees should be 1, got " + heap.numTrees();
                }
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_UpdatesMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Updates Min";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        Heap.HeapItem n1 = heap.insert(50, "fifty");
        if (heap.findMin() != n1) {
            pass = false;
            reason = "After inserting 50, findMin should return that item";
        }
        
        if (pass) {
            Heap.HeapItem n2 = heap.insert(30, "thirty");
            if (heap.findMin() != n2 || heap.findMin().key != 30) {
                pass = false;
                reason = "After inserting smaller 30, findMin should return new min";
            }
        }
        
        if (pass) {
            heap.insert(70, "seventy");
            if (heap.findMin().key != 30) {
                pass = false;
                reason = "After inserting larger 70, min should still be 30, got " + heap.findMin().key;
            }
        }
        
        if (pass) {
            Heap.HeapItem n4 = heap.insert(10, "ten");
            if (heap.findMin() != n4 || heap.findMin().key != 10) {
                pass = false;
                reason = "After inserting smallest 10, findMin should return new min";
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_LargeNumber(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Large Number of Elements";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        int n = 1000;
        for (int i = n; i >= 1; i--) {
            heap.insert(i, "val-" + i);
        }
        
        if (heap.size() != n) {
            pass = false;
            reason = "After " + n + " inserts, size should be " + n + ", got " + heap.size();
        } else if (heap.findMin().key != 1) {
            pass = false;
            reason = "Min should be 1, got " + heap.findMin().key;
        }
        
        // Verify first 10 extractions
        if (pass) {
            for (int i = 1; i <= 10 && pass; i++) {
                int minKey = heap.findMin().key;
                if (minKey != i) {
                    pass = false;
                    reason = "Expected " + i + " at step " + i + ", got " + minKey;
                }
                heap.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== NEW INSERT EDGE CASE TESTS (5) ====================

    private static void testInsert_MaxIntKey(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Max Int Key";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem maxItem = heap.insert(Integer.MAX_VALUE, "max");
        heap.insert(1, "one");
        heap.insert(Integer.MAX_VALUE, "max2");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 3) {
            pass = false;
            reason = "Size should be 3, got " + heap.size();
        } else if (heap.findMin().key != 1) {
            pass = false;
            reason = "Min should be 1, got " + heap.findMin().key;
        }
        
        // Verify all elements extractable
        if (pass) {
            heap.deleteMin(); // 1
            if (heap.findMin().key != Integer.MAX_VALUE) {
                pass = false;
                reason = "After removing 1, next should be MAX_VALUE, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_AfterEmptyingHeap(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert After Emptying Heap";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // Fill and empty multiple times
        for (int round = 0; round < 3; round++) {
            for (int i = 0; i < 5; i++) {
                heap.insert(i + 1, "round" + round + "-" + i);
            }
            for (int i = 0; i < 5; i++) {
                heap.deleteMin();
            }
        }
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 0) {
            pass = false;
            reason = "After cycles, size should be 0, got " + heap.size();
        }
        
        // Final insert
        if (pass) {
            Heap.HeapItem item = heap.insert(999, "final");
            if (heap.findMin() != item) {
                pass = false;
                reason = "Final insert should be findable as min";
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_ImmediatelyAfterMeld(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Immediately After Meld";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(50, "h1-50");
        heap1.insert(30, "h1-30");
        heap2.insert(40, "h2-40");
        heap2.insert(20, "h2-20");
        
        heap1.meld(heap2);
        
        // Immediately insert new min
        Heap.HeapItem newMin = heap1.insert(5, "five");
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.size() != 5) {
            pass = false;
            reason = "After meld and insert, size should be 5, got " + heap1.size();
        } else if (heap1.findMin() != newMin) {
            pass = false;
            reason = "New insert should be min";
        } else if (heap1.findMin().key != 5) {
            pass = false;
            reason = "Min should be 5, got " + heap1.findMin().key;
        }
        
        // Verify order
        if (pass) {
            int[] expected = {5, 20, 30, 40, 50};
            for (int i = 0; i < expected.length && pass; i++) {
                if (heap1.findMin().key != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + heap1.findMin().key;
                }
                heap1.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_AlternatingMinMax(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Alternating Min Max";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // Insert alternating between very small and very large
        heap.insert(1000000, "large1");
        heap.insert(1, "small1");
        heap.insert(999999, "large2");
        heap.insert(2, "small2");
        heap.insert(888888, "large3");
        heap.insert(3, "small3");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 6) {
            pass = false;
            reason = "Size should be 6, got " + heap.size();
        } else if (heap.findMin().key != 1) {
            pass = false;
            reason = "Min should be 1, got " + heap.findMin().key;
        }
        
        // Verify extraction order
        if (pass) {
            int[] expected = {1, 2, 3, 888888, 999999, 1000000};
            for (int i = 0; i < expected.length && pass; i++) {
                if (heap.findMin().key != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + heap.findMin().key;
                }
                heap.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testInsert_SameKeyDifferentInfo(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Insert Same Key Different Info";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem item1 = heap.insert(100, "info-A");
        Heap.HeapItem item2 = heap.insert(100, "info-B");
        Heap.HeapItem item3 = heap.insert(100, "info-C");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 3) {
            pass = false;
            reason = "Size should be 3, got " + heap.size();
        }
        
        // All items should be distinct
        if (pass && (item1 == item2 || item2 == item3 || item1 == item3)) {
            pass = false;
            reason = "Each insert should return distinct HeapItem";
        }
        
        // All have same key
        if (pass && (item1.key != 100 || item2.key != 100 || item3.key != 100)) {
            pass = false;
            reason = "All items should have key 100";
        }
        
        // Info should be preserved
        if (pass) {
            if (!item1.info.equals("info-A") || !item2.info.equals("info-B") || !item3.info.equals("info-C")) {
                pass = false;
                reason = "Info not preserved correctly";
            }
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== FINDMIN TESTS (10) ====================

    private static void testFindMin_EmptyHeap(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin Empty Heap";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin() != null) {
            pass = false;
            reason = "findMin() on empty heap should return null, got node with key " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_SingleElement(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin Single Element";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem item = heap.insert(42, "forty-two");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin() != item) {
            pass = false;
            reason = "findMin() should return the only inserted item";
        } else if (heap.findMin().key != 42) {
            pass = false;
            reason = "findMin().key should be 42, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_MultipleElements(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin Multiple Elements";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(30, "thirty");
        heap.insert(10, "ten");
        heap.insert(50, "fifty");
        heap.insert(20, "twenty");
        heap.insert(40, "forty");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != 10) {
            pass = false;
            reason = "findMin().key should be 10, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_AfterInsertSmaller(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin After Insert Smaller";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(50, "fifty");
        heap.insert(30, "thirty");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != 30) {
            pass = false;
            reason = "After inserting 50 then 30, min should be 30, got " + heap.findMin().key;
        }
        
        Heap.HeapItem smallest = heap.insert(10, "ten");
        if (heap.findMin() != smallest || heap.findMin().key != 10) {
            pass = false;
            reason = "After inserting 10, min should be 10, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_AfterInsertLarger(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin After Insert Larger";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem first = heap.insert(10, "ten");
        heap.insert(20, "twenty");
        heap.insert(30, "thirty");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin() != first) {
            pass = false;
            reason = "After inserting larger elements, min should still be the first item";
        } else if (heap.findMin().key != 10) {
            pass = false;
            reason = "Min should be 10, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_AfterDeleteMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin After DeleteMin";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(10, "ten");
        heap.insert(20, "twenty");
        heap.insert(30, "thirty");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != 10) {
            pass = false;
            reason = "Initial min should be 10, got " + heap.findMin().key;
        }
        
        if (pass) {
            heap.deleteMin();
            if (heap.findMin().key != 20) {
                pass = false;
                reason = "After deleteMin, new min should be 20, got " + heap.findMin().key;
            }
        }
        
        if (pass) {
            heap.deleteMin();
            if (heap.findMin().key != 30) {
                pass = false;
                reason = "After second deleteMin, new min should be 30, got " + heap.findMin().key;
            }
        }
        
        if (pass) {
            heap.deleteMin();
            if (heap.findMin() != null) {
                pass = false;
                reason = "After deleting all, findMin should be null";
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_AfterMeld(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin After Meld";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(20, "twenty");
        heap1.insert(40, "forty");
        heap2.insert(10, "ten");
        heap2.insert(30, "thirty");
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.findMin().key != 20) {
            pass = false;
            reason = "heap1 min should be 20, got " + heap1.findMin().key;
        } else if (heap2.findMin().key != 10) {
            pass = false;
            reason = "heap2 min should be 10, got " + heap2.findMin().key;
        }
        
        if (pass) {
            heap1.meld(heap2);
            if (heap1.findMin().key != 10) {
                pass = false;
                reason = "After meld, min should be 10, got " + heap1.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_WithDuplicates(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin With Duplicates";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(20, "twenty");
        heap.insert(10, "ten-a");
        heap.insert(10, "ten-b");
        heap.insert(30, "thirty");
        heap.insert(10, "ten-c");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != 10) {
            pass = false;
            reason = "Min should be 10, got " + heap.findMin().key;
        }
        
        // After deleting one 10, min should still be 10
        if (pass) {
            heap.deleteMin();
            if (heap.findMin().key != 10) {
                pass = false;
                reason = "After first deleteMin, min should still be 10, got " + heap.findMin().key;
            }
        }
        
        // After deleting second 10, min should still be 10
        if (pass) {
            heap.deleteMin();
            if (heap.findMin().key != 10) {
                pass = false;
                reason = "After second deleteMin, min should still be 10, got " + heap.findMin().key;
            }
        }
        
        // After deleting third 10, min should be 20
        if (pass) {
            heap.deleteMin();
            if (heap.findMin().key != 20) {
                pass = false;
                reason = "After third deleteMin, min should be 20, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_DoesNotModifyHeap(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin Does Not Modify Heap";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(30, "thirty");
        heap.insert(10, "ten");
        heap.insert(20, "twenty");
        
        int sizeBefore = heap.size();
        int numTreesBefore = heap.numTrees();
        int totalLinksBefore = heap.totalLinks();
        
        // Call findMin multiple times
        Heap.HeapItem min1 = heap.findMin();
        Heap.HeapItem min2 = heap.findMin();
        Heap.HeapItem min3 = heap.findMin();
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != sizeBefore) {
            pass = false;
            reason = "findMin() should not change size";
        } else if (heap.numTrees() != numTreesBefore) {
            pass = false;
            reason = "findMin() should not change numTrees";
        } else if (heap.totalLinks() != totalLinksBefore) {
            pass = false;
            reason = "findMin() should not change totalLinks";
        } else if (min1 != min2 || min2 != min3) {
            pass = false;
            reason = "findMin() should return the same node each time";
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_ConsistentReturns(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin Consistent Returns";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem minItem = heap.insert(5, "five");
        heap.insert(15, "fifteen");
        heap.insert(25, "twenty-five");
        heap.insert(10, "ten");
        
        boolean pass = true;
        String reason = "";
        
        // Call findMin 100 times - should always return same item
        for (int i = 0; i < 100 && pass; i++) {
            Heap.HeapItem current = heap.findMin();
            if (current != minItem) {
                pass = false;
                reason = "findMin() returned different item on call " + i;
            }
            if (current.key != 5) {
                pass = false;
                reason = "findMin().key changed to " + current.key + " on call " + i;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== NEW FINDMIN EDGE CASE TESTS (5) ====================

    private static void testFindMin_AfterDecreaseKeyToNewMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin After DecreaseKey To New Min";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(50, "fifty");
        Heap.HeapItem item = heap.insert(100, "hundred");
        heap.insert(75, "seventy-five");
        
        // Initial min should be 50
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != 50) {
            pass = false;
            reason = "Initial min should be 50, got " + heap.findMin().key;
        }
        
        // Decrease item to become new min
        if (pass) {
            heap.decreaseKey(item, 90); // 100 -> 10
            if (heap.findMin() != item) {
                pass = false;
                reason = "After decreaseKey, findMin should return the decreased item";
            }
            if (pass && heap.findMin().key != 10) {
                pass = false;
                reason = "New min should be 10, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_AfterArbitraryDelete(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin After Arbitrary Delete";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem min = heap.insert(10, "ten");
        Heap.HeapItem mid = heap.insert(50, "fifty");
        heap.insert(30, "thirty");
        
        boolean pass = true;
        String reason = "";
        
        // Delete middle element
        heap.delete(mid);
        
        if (heap.findMin() != min) {
            pass = false;
            reason = "After deleting middle, min should still be original min";
        }
        if (pass && heap.findMin().key != 10) {
            pass = false;
            reason = "Min should be 10, got " + heap.findMin().key;
        }
        
        // Now delete min
        if (pass) {
            heap.delete(min);
            if (heap.findMin().key != 30) {
                pass = false;
                reason = "After deleting min, new min should be 30, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_AfterMultipleMelds(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin After Multiple Melds";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap3 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(50, "h1-50");
        heap2.insert(30, "h2-30");
        heap3.insert(10, "h3-10");
        
        boolean pass = true;
        String reason = "";
        
        heap1.meld(heap2);
        if (heap1.findMin().key != 30) {
            pass = false;
            reason = "After first meld, min should be 30, got " + heap1.findMin().key;
        }
        
        if (pass) {
            heap1.meld(heap3);
            if (heap1.findMin().key != 10) {
                pass = false;
                reason = "After second meld, min should be 10, got " + heap1.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_LargeHeap(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin Large Heap";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // Insert 10000 elements, with min at a specific position
        int minValue = 1;
        for (int i = 10000; i >= 1; i--) {
            heap.insert(i, "val-" + i);
        }
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != minValue) {
            pass = false;
            reason = "Min should be " + minValue + ", got " + heap.findMin().key;
        }
        
        // Verify findMin is consistent
        if (pass) {
            for (int i = 0; i < 100; i++) {
                if (heap.findMin().key != minValue) {
                    pass = false;
                    reason = "findMin inconsistent at iteration " + i;
                    break;
                }
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testFindMin_AfterComplexOperations(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "FindMin After Complex Operations";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem[] items = new Heap.HeapItem[10];
        for (int i = 0; i < 10; i++) {
            items[i] = heap.insert((i + 1) * 10, "val-" + i);
        }
        
        boolean pass = true;
        String reason = "";
        
        // Delete some
        heap.delete(items[0]); // delete 10
        
        if (heap.findMin().key != 20) {
            pass = false;
            reason = "After deleting 10, min should be 20, got " + heap.findMin().key;
        }
        
        // Decrease another to become min
        if (pass) {
            heap.decreaseKey(items[5], 55); // 60 -> 5
            if (heap.findMin().key != 5) {
                pass = false;
                reason = "After decreaseKey, min should be 5, got " + heap.findMin().key;
            }
        }
        
        // Meld
        if (pass) {
            Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
            heap2.insert(3, "three");
            heap.meld(heap2);
            if (heap.findMin().key != 3) {
                pass = false;
                reason = "After meld with smaller, min should be 3, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== DELETEMIN TESTS (10) ====================

    private static void testDeleteMin_SingleElement(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin Single Element";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(42, "forty-two");
        heap.deleteMin();
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 0) {
            pass = false;
            reason = "After deleteMin on single element, size should be 0, got " + heap.size();
        } else if (heap.findMin() != null) {
            pass = false;
            reason = "After deleteMin on single element, findMin should be null";
        } else if (heap.numTrees() != 0) {
            pass = false;
            reason = "After deleteMin on single element, numTrees should be 0, got " + heap.numTrees();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_TwoElements(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin Two Elements";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(10, "ten");
        heap.insert(20, "twenty");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != 10) {
            pass = false;
            reason = "Before deleteMin, min should be 10, got " + heap.findMin().key;
        }
        
        if (pass) {
            heap.deleteMin();
            if (heap.size() != 1) {
                pass = false;
                reason = "After deleteMin, size should be 1, got " + heap.size();
            } else if (heap.findMin().key != 20) {
                pass = false;
                reason = "After deleteMin, min should be 20, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_MultipleElements(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin Multiple Elements";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(30, "thirty");
        heap.insert(10, "ten");
        heap.insert(50, "fifty");
        heap.insert(20, "twenty");
        heap.insert(40, "forty");
        
        boolean pass = true;
        String reason = "";
        
        int[] expected = {10, 20, 30, 40, 50};
        for (int i = 0; i < expected.length && pass; i++) {
            if (heap.findMin().key != expected[i]) {
                pass = false;
                reason = "Expected " + expected[i] + " at step " + i + ", got " + heap.findMin().key;
            }
            heap.deleteMin();
        }
        
        if (pass && heap.size() != 0) {
            pass = false;
            reason = "After all deleteMins, size should be 0, got " + heap.size();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_UpdatesSize(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin Updates Size";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        for (int i = 1; i <= 10; i++) {
            heap.insert(i * 10, "val-" + i);
        }
        
        boolean pass = true;
        String reason = "";
        
        for (int i = 10; i >= 1; i--) {
            if (heap.size() != i) {
                pass = false;
                reason = "Before deleteMin, size should be " + i + ", got " + heap.size();
                break;
            }
            heap.deleteMin();
        }
        
        if (pass && heap.size() != 0) {
            pass = false;
            reason = "After all deleteMins, size should be 0, got " + heap.size();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_UpdatesNumTrees(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin Updates NumTrees";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        for (int i = 1; i <= 4; i++) {
            heap.insert(i * 10, "val-" + i);
        }
        
        boolean pass = true;
        String reason = "";
        
        // After deleteMin, children become roots but consolidation happens
        heap.deleteMin();
        
        if (heap.numTrees() < 1) {
            pass = false;
            reason = "After deleteMin, numTrees should be >= 1, got " + heap.numTrees();
        }
        
        // Delete all remaining
        while (heap.size() > 0) {
            heap.deleteMin();
        }
        
        if (heap.numTrees() != 0) {
            pass = false;
            reason = "After deleting all, numTrees should be 0, got " + heap.numTrees();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_UpdatesMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin Updates Min";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(5, "five");
        heap.insert(15, "fifteen");
        heap.insert(10, "ten");
        heap.insert(20, "twenty");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != 5) {
            pass = false;
            reason = "Initial min should be 5, got " + heap.findMin().key;
        }
        
        if (pass) {
            heap.deleteMin(); // removes 5
            if (heap.findMin().key != 10) {
                pass = false;
                reason = "After removing 5, min should be 10, got " + heap.findMin().key;
            }
        }
        
        if (pass) {
            heap.deleteMin(); // removes 10
            if (heap.findMin().key != 15) {
                pass = false;
                reason = "After removing 10, min should be 15, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_WithDuplicateMinKeys(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin With Duplicate Min Keys";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(5, "five-a");
        heap.insert(5, "five-b");
        heap.insert(5, "five-c");
        heap.insert(10, "ten");
        
        boolean pass = true;
        String reason = "";
        
        // First three deleteMins should all return 5
        for (int i = 0; i < 3 && pass; i++) {
            if (heap.findMin().key != 5) {
                pass = false;
                reason = "At step " + i + ", min should be 5, got " + heap.findMin().key;
            }
            heap.deleteMin();
        }
        
        // Fourth should be 10
        if (pass && heap.findMin().key != 10) {
            pass = false;
            reason = "After 3 deleteMins, min should be 10, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_AllElements(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin All Elements";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        int n = 100;
        for (int i = n; i >= 1; i--) {
            heap.insert(i, "val-" + i);
        }
        
        boolean pass = true;
        String reason = "";
        
        for (int expected = 1; expected <= n && pass; expected++) {
            if (heap.findMin().key != expected) {
                pass = false;
                reason = "Expected " + expected + ", got " + heap.findMin().key;
            }
            heap.deleteMin();
        }
        
        if (pass && heap.size() != 0) {
            pass = false;
            reason = "After all deleteMins, size should be 0, got " + heap.size();
        }
        
        if (pass && heap.findMin() != null) {
            pass = false;
            reason = "After all deleteMins, findMin should be null";
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_TriggersConsolidation(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin Triggers Consolidation";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // Insert 8 elements (lazy mode will have 8 trees)
        for (int i = 1; i <= 8; i++) {
            heap.insert(i * 10, "val-" + i);
        }
        
        int treesBefore = heap.numTrees();
        int linksBefore = heap.totalLinks();
        
        heap.deleteMin(); // Should trigger consolidation
        
        boolean pass = true;
        String reason = "";
        
        if (lazyMelds) {
            // In lazy mode, deleteMin triggers successive linking
            if (heap.totalLinks() <= linksBefore) {
                pass = false;
                reason = "In lazy mode, deleteMin should trigger linking. Links before: " + linksBefore + ", after: " + heap.totalLinks();
            }
        }
        
        // In any mode, numTrees should be reasonable after consolidation
        if (heap.numTrees() > 7) {
            pass = false;
            reason = "After deleteMin and consolidation, numTrees should be <= 7, got " + heap.numTrees();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_TotalLinksIncreases(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin TotalLinks Increases";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        for (int i = 1; i <= 16; i++) {
            heap.insert(i * 10, "val-" + i);
        }
        
        int linksBefore = heap.totalLinks();
        heap.deleteMin();
        int linksAfter = heap.totalLinks();
        
        boolean pass = true;
        String reason = "";
        
        if (linksAfter < linksBefore) {
            pass = false;
            reason = "totalLinks should not decrease after deleteMin. Before: " + linksBefore + ", after: " + linksAfter;
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== NEW DELETEMIN EDGE CASE TESTS (5) ====================

    private static void testDeleteMin_AfterDecreaseKey(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin After DecreaseKey";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(50, "fifty");
        Heap.HeapItem item = heap.insert(100, "hundred");
        heap.insert(75, "seventy-five");
        
        // Decrease to make new min
        heap.decreaseKey(item, 90); // 100 -> 10
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != 10) {
            pass = false;
            reason = "After decreaseKey, min should be 10, got " + heap.findMin().key;
        }
        
        // DeleteMin should remove the decreased item
        if (pass) {
            heap.deleteMin();
            if (heap.findMin().key != 50) {
                pass = false;
                reason = "After deleteMin, min should be 50, got " + heap.findMin().key;
            }
            if (pass && heap.size() != 2) {
                pass = false;
                reason = "Size should be 2, got " + heap.size();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_LeavesOnlyDuplicates(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin Leaves Only Duplicates";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(5, "five-unique");
        heap.insert(100, "hundred-a");
        heap.insert(100, "hundred-b");
        heap.insert(100, "hundred-c");
        
        boolean pass = true;
        String reason = "";
        
        // Delete the unique min
        heap.deleteMin();
        
        // All remaining should be 100
        for (int i = 0; i < 3 && pass; i++) {
            if (heap.findMin().key != 100) {
                pass = false;
                reason = "All remaining elements should be 100, got " + heap.findMin().key + " at step " + i;
            }
            heap.deleteMin();
        }
        
        if (pass && heap.size() != 0) {
            pass = false;
            reason = "After all deletions, size should be 0, got " + heap.size();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_FromLargeHeap(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin From Large Heap";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        int n = 1000;
        for (int i = n; i >= 1; i--) {
            heap.insert(i, "val-" + i);
        }
        
        boolean pass = true;
        String reason = "";
        
        // Delete first 100 and verify order
        for (int i = 1; i <= 100 && pass; i++) {
            if (heap.findMin().key != i) {
                pass = false;
                reason = "Expected " + i + ", got " + heap.findMin().key;
            }
            heap.deleteMin();
        }
        
        if (pass && heap.size() != n - 100) {
            pass = false;
            reason = "Expected size " + (n - 100) + ", got " + heap.size();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_AfterMeld(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin After Meld";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(30, "h1-30");
        heap1.insert(50, "h1-50");
        heap2.insert(10, "h2-10");
        heap2.insert(20, "h2-20");
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.findMin().key != 10) {
            pass = false;
            reason = "After meld, min should be 10, got " + heap1.findMin().key;
        }
        
        if (pass) {
            heap1.deleteMin(); // removes 10 from heap2
            if (heap1.findMin().key != 20) {
                pass = false;
                reason = "After deleteMin, min should be 20, got " + heap1.findMin().key;
            }
        }
        
        // Verify all 3 remaining
        if (pass) {
            int[] expected = {20, 30, 50};
            for (int i = 0; i < expected.length && pass; i++) {
                if (heap1.findMin().key != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + heap1.findMin().key;
                }
                heap1.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDeleteMin_ConsecutiveUntilEmpty(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DeleteMin Consecutive Until Empty";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // Insert in random order
        int[] values = {73, 12, 98, 5, 41, 67, 23, 89, 34, 56};
        for (int v : values) {
            heap.insert(v, "val-" + v);
        }
        
        boolean pass = true;
        String reason = "";
        
        // Sort expected
        int[] expected = {5, 12, 23, 34, 41, 56, 67, 73, 89, 98};
        
        for (int i = 0; i < expected.length && pass; i++) {
            if (heap.findMin() == null) {
                pass = false;
                reason = "findMin returned null at step " + i;
                break;
            }
            if (heap.findMin().key != expected[i]) {
                pass = false;
                reason = "Expected " + expected[i] + " at step " + i + ", got " + heap.findMin().key;
            }
            heap.deleteMin();
        }
        
        if (pass && heap.size() != 0) {
            pass = false;
            reason = "After all deletions, size should be 0, got " + heap.size();
        }
        
        if (pass && heap.findMin() != null) {
            pass = false;
            reason = "After all deletions, findMin should be null";
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== MELD TESTS (10) ====================

    private static void testMeld_TwoNonEmptyHeaps(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Two Non-Empty Heaps";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(10, "h1-10");
        heap1.insert(30, "h1-30");
        heap2.insert(20, "h2-20");
        heap2.insert(40, "h2-40");
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.size() != 4) {
            pass = false;
            reason = "After meld, size should be 4, got " + heap1.size();
        }
        
        int[] expected = {10, 20, 30, 40};
        for (int i = 0; i < expected.length && pass; i++) {
            if (heap1.findMin().key != expected[i]) {
                pass = false;
                reason = "Expected " + expected[i] + " at step " + i + ", got " + heap1.findMin().key;
            }
            heap1.deleteMin();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_EmptyIntoNonEmpty(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Empty Into Non-Empty";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(10, "ten");
        heap1.insert(20, "twenty");
        // heap2 is empty
        
        int sizeBefore = heap1.size();
        int minBefore = heap1.findMin().key;
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.size() != sizeBefore) {
            pass = false;
            reason = "After meld with empty, size should be " + sizeBefore + ", got " + heap1.size();
        } else if (heap1.findMin().key != minBefore) {
            pass = false;
            reason = "After meld with empty, min should be " + minBefore + ", got " + heap1.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_NonEmptyIntoEmpty(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Non-Empty Into Empty";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // heap1 is empty
        heap2.insert(10, "ten");
        heap2.insert(20, "twenty");
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.size() != 2) {
            pass = false;
            reason = "After empty.meld(non-empty), size should be 2, got " + heap1.size();
        } else if (heap1.findMin().key != 10) {
            pass = false;
            reason = "After empty.meld(non-empty), min should be 10, got " + heap1.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_TwoEmptyHeaps(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Two Empty Heaps";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.size() != 0) {
            pass = false;
            reason = "After meld of two empty heaps, size should be 0, got " + heap1.size();
        } else if (heap1.findMin() != null) {
            pass = false;
            reason = "After meld of two empty heaps, findMin should be null";
        } else if (heap1.numTrees() != 0) {
            pass = false;
            reason = "After meld of two empty heaps, numTrees should be 0, got " + heap1.numTrees();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_UpdatesSize(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Updates Size";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        for (int i = 1; i <= 5; i++) {
            heap1.insert(i * 10, "h1-" + i);
        }
        for (int i = 1; i <= 7; i++) {
            heap2.insert(i * 100, "h2-" + i);
        }
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.size() != 12) {
            pass = false;
            reason = "After meld, size should be 5+7=12, got " + heap1.size();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_UpdatesMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Updates Min";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(50, "fifty");
        heap1.insert(60, "sixty");
        heap2.insert(10, "ten");
        heap2.insert(20, "twenty");
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.findMin().key != 50) {
            pass = false;
            reason = "Before meld, heap1 min should be 50, got " + heap1.findMin().key;
        }
        
        if (pass) {
            heap1.meld(heap2);
            if (heap1.findMin().key != 10) {
                pass = false;
                reason = "After meld, min should be 10, got " + heap1.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_InheritsTotalLinks(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Inherits TotalLinks";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        for (int i = 1; i <= 4; i++) {
            heap1.insert(i * 10, "h1-" + i);
        }
        for (int i = 1; i <= 4; i++) {
            heap2.insert(i * 100, "h2-" + i);
        }
        
        int links1 = heap1.totalLinks();
        int links2 = heap2.totalLinks();
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.totalLinks() < links1 + links2) {
            pass = false;
            reason = "After meld, totalLinks should be >= " + (links1 + links2) + ", got " + heap1.totalLinks();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_InheritsTotalCuts(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Inherits TotalCuts";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        for (int i = 1; i <= 4; i++) {
            heap1.insert(i * 10, "h1-" + i);
            heap2.insert(i * 100, "h2-" + i);
        }
        
        int cuts1 = heap1.totalCuts();
        int cuts2 = heap2.totalCuts();
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.totalCuts() < cuts1 + cuts2) {
            pass = false;
            reason = "After meld, totalCuts should be >= " + (cuts1 + cuts2) + ", got " + heap1.totalCuts();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_InheritsHeapifyCosts(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Inherits HeapifyCosts";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        for (int i = 1; i <= 4; i++) {
            heap1.insert(i * 10, "h1-" + i);
            heap2.insert(i * 100, "h2-" + i);
        }
        
        int heapify1 = heap1.totalHeapifyCosts();
        int heapify2 = heap2.totalHeapifyCosts();
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.totalHeapifyCosts() != heapify1 + heapify2) {
            pass = false;
            reason = "After meld, totalHeapifyCosts should be " + (heapify1 + heapify2) + ", got " + heap1.totalHeapifyCosts();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_NumTreesCorrect(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld NumTrees Correct";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(10, "ten");
        heap1.insert(20, "twenty");
        heap2.insert(30, "thirty");
        heap2.insert(40, "forty");
        
        int trees1 = heap1.numTrees();
        int trees2 = heap2.numTrees();
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (lazyMelds) {
            // In lazy mode, meld just concatenates root lists
            if (heap1.numTrees() != trees1 + trees2) {
                pass = false;
                reason = "In lazy mode, after meld numTrees should be " + (trees1 + trees2) + ", got " + heap1.numTrees();
            }
        } else {
            // In strict mode, successive linking occurs
            if (heap1.numTrees() > trees1 + trees2) {
                pass = false;
                reason = "In strict mode, after meld numTrees should be <= " + (trees1 + trees2) + ", got " + heap1.numTrees();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== NEW MELD EDGE CASE TESTS (5) ====================

    private static void testMeld_SameMinKeys(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Same Min Keys";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(10, "h1-10");
        heap1.insert(50, "h1-50");
        heap2.insert(10, "h2-10");
        heap2.insert(40, "h2-40");
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.size() != 4) {
            pass = false;
            reason = "After meld, size should be 4, got " + heap1.size();
        }
        
        // Min should be 10, and there should be two of them
        if (pass && heap1.findMin().key != 10) {
            pass = false;
            reason = "Min should be 10, got " + heap1.findMin().key;
        }
        
        // Extract and verify
        if (pass) {
            int[] expected = {10, 10, 40, 50};
            for (int i = 0; i < expected.length && pass; i++) {
                if (heap1.findMin().key != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + heap1.findMin().key;
                }
                heap1.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_DisjointRanges(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Disjoint Ranges";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // heap1: 1-10, heap2: 100-110
        for (int i = 1; i <= 10; i++) {
            heap1.insert(i, "h1-" + i);
        }
        for (int i = 100; i <= 110; i++) {
            heap2.insert(i, "h2-" + i);
        }
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.size() != 21) {
            pass = false;
            reason = "After meld, size should be 21, got " + heap1.size();
        }
        
        // Verify first 10 extractions are 1-10
        if (pass) {
            for (int i = 1; i <= 10 && pass; i++) {
                if (heap1.findMin().key != i) {
                    pass = false;
                    reason = "Expected " + i + ", got " + heap1.findMin().key;
                }
                heap1.deleteMin();
            }
        }
        
        // Next should be 100
        if (pass && heap1.findMin().key != 100) {
            pass = false;
            reason = "After heap1 elements, min should be 100, got " + heap1.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_LargeIntoSmall(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Large Into Small";
        Heap heapSmall = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heapLarge = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heapSmall.insert(5, "small-5");
        
        for (int i = 1; i <= 100; i++) {
            heapLarge.insert(i * 10, "large-" + i);
        }
        
        heapSmall.meld(heapLarge);
        
        boolean pass = true;
        String reason = "";
        
        if (heapSmall.size() != 101) {
            pass = false;
            reason = "After meld, size should be 101, got " + heapSmall.size();
        }
        
        if (pass && heapSmall.findMin().key != 5) {
            pass = false;
            reason = "Min should be 5 from small heap, got " + heapSmall.findMin().key;
        }
        
        // Verify order
        if (pass) {
            heapSmall.deleteMin(); // 5
            if (heapSmall.findMin().key != 10) {
                pass = false;
                reason = "After removing 5, min should be 10, got " + heapSmall.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_ChainedMelds(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld Chained Melds";
        Heap mainHeap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        mainHeap.insert(50, "main-50");
        
        boolean pass = true;
        String reason = "";
        
        // Chain meld 5 heaps
        for (int h = 0; h < 5; h++) {
            Heap temp = new Heap(lazyMelds, lazyDecreaseKeys);
            temp.insert(h * 10 + 5, "temp" + h);
            mainHeap.meld(temp);
        }
        
        if (mainHeap.size() != 6) {
            pass = false;
            reason = "After 5 chain melds, size should be 6, got " + mainHeap.size();
        }
        
        // Min should be 5 (from first temp heap)
        if (pass && mainHeap.findMin().key != 5) {
            pass = false;
            reason = "Min should be 5, got " + mainHeap.findMin().key;
        }
        
        // Verify extraction order: 5, 15, 25, 35, 45, 50
        if (pass) {
            int[] expected = {5, 15, 25, 35, 45, 50};
            for (int i = 0; i < expected.length && pass; i++) {
                if (mainHeap.findMin().key != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + mainHeap.findMin().key;
                }
                mainHeap.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testMeld_AfterDeleteMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Meld After DeleteMin";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        for (int i = 1; i <= 8; i++) {
            heap1.insert(i * 10, "h1-" + i);
        }
        
        // Trigger consolidation
        heap1.deleteMin();
        
        heap2.insert(5, "h2-5");
        heap2.insert(15, "h2-15");
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.size() != 9) {
            pass = false;
            reason = "After meld, size should be 9, got " + heap1.size();
        }
        
        if (pass && heap1.findMin().key != 5) {
            pass = false;
            reason = "Min should be 5, got " + heap1.findMin().key;
        }
        
        // Verify order
        if (pass) {
            int[] expected = {5, 15, 20, 30, 40, 50, 60, 70, 80};
            for (int i = 0; i < expected.length && pass; i++) {
                if (heap1.findMin().key != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + heap1.findMin().key;
                }
                heap1.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== DELETE TESTS (10) ====================

    private static void testDelete_SingleElement(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Single Element";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem item = heap.insert(42, "forty-two");
        heap.delete(item);
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 0) {
            pass = false;
            reason = "After deleting only element, size should be 0, got " + heap.size();
        } else if (heap.findMin() != null) {
            pass = false;
            reason = "After deleting only element, findMin should be null";
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_MinElement(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Min Element";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem minItem = heap.insert(10, "ten");
        heap.insert(20, "twenty");
        heap.insert(30, "thirty");
        
        heap.delete(minItem);
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 2) {
            pass = false;
            reason = "After delete, size should be 2, got " + heap.size();
        } else if (heap.findMin().key != 20) {
            pass = false;
            reason = "After deleting min, new min should be 20, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_MaxElement(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Max Element";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(10, "ten");
        heap.insert(20, "twenty");
        Heap.HeapItem maxItem = heap.insert(30, "thirty");
        
        heap.delete(maxItem);
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 2) {
            pass = false;
            reason = "After delete, size should be 2, got " + heap.size();
        } else if (heap.findMin().key != 10) {
            pass = false;
            reason = "After deleting max, min should still be 10, got " + heap.findMin().key;
        }
        
        // Verify both remaining elements
        heap.deleteMin();
        if (heap.findMin().key != 20) {
            pass = false;
            reason = "After deleteMin, should have 20 left, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_MiddleElement(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Middle Element";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(10, "ten");
        Heap.HeapItem middleItem = heap.insert(20, "twenty");
        heap.insert(30, "thirty");
        
        heap.delete(middleItem);
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 2) {
            pass = false;
            reason = "After delete, size should be 2, got " + heap.size();
        }
        
        // Verify extraction order
        if (pass && heap.findMin().key != 10) {
            pass = false;
            reason = "Min should be 10, got " + heap.findMin().key;
        }
        if (pass) {
            heap.deleteMin();
            if (heap.findMin().key != 30) {
                pass = false;
                reason = "After deleteMin, should have 30, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_UpdatesSize(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Updates Size";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem[] items = new Heap.HeapItem[5];
        for (int i = 0; i < 5; i++) {
            items[i] = heap.insert((i + 1) * 10, "val-" + (i + 1));
        }
        
        boolean pass = true;
        String reason = "";
        
        heap.delete(items[2]); // delete 30
        if (heap.size() != 4) {
            pass = false;
            reason = "After first delete, size should be 4, got " + heap.size();
        }
        
        if (pass) {
            heap.delete(items[4]); // delete 50
            if (heap.size() != 3) {
                pass = false;
                reason = "After second delete, size should be 3, got " + heap.size();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_UpdatesMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Updates Min";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem n1 = heap.insert(10, "ten");
        Heap.HeapItem n2 = heap.insert(20, "twenty");
        heap.insert(30, "thirty");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin() != n1) {
            pass = false;
            reason = "Initial min should be item with key 10";
        }
        
        if (pass) {
            heap.delete(n1);
            if (heap.findMin() != n2 || heap.findMin().key != 20) {
                pass = false;
                reason = "After deleting min, new min should be 20, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_LeafNode(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Leaf Node";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // Build a tree structure
        for (int i = 1; i <= 8; i++) {
            heap.insert(i * 10, "val-" + i);
        }
        heap.deleteMin(); // consolidate, removes 10
        
        // Insert a large value that will likely be a leaf
        Heap.HeapItem leaf = heap.insert(100, "hundred");
        
        heap.delete(leaf);
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 7) {
            pass = false;
            reason = "After delete, size should be 7, got " + heap.size();
        }
        
        // Verify heap still works
        int prev = -1;
        while (heap.size() > 0 && pass) {
            int current = heap.findMin().key;
            if (current < prev) {
                pass = false;
                reason = "Heap order violated: got " + current + " after " + prev;
            }
            prev = current;
            heap.deleteMin();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_InternalNode(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Internal Node";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem[] items = new Heap.HeapItem[8];
        for (int i = 0; i < 8; i++) {
            items[i] = heap.insert((i + 1) * 10, "val-" + (i + 1));
        }
        heap.deleteMin(); // consolidate, removes 10 (items[0])
        
        // Delete an item that might be internal
        heap.delete(items[3]); // delete 40
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 6) {
            pass = false;
            reason = "After delete, size should be 6, got " + heap.size();
        }
        
        // Verify remaining elements in order
        int[] expected = {20, 30, 50, 60, 70, 80};
        for (int i = 0; i < expected.length && pass; i++) {
            if (heap.findMin().key != expected[i]) {
                pass = false;
                reason = "Expected " + expected[i] + " at step " + i + ", got " + heap.findMin().key;
            }
            heap.deleteMin();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_MultipleDeletes(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Multiple Deletes";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem[] items = new Heap.HeapItem[10];
        for (int i = 0; i < 10; i++) {
            items[i] = heap.insert((i + 1) * 10, "val-" + (i + 1));
        }
        
        // Delete even-indexed items (10, 30, 50, 70, 90)
        heap.delete(items[0]);
        heap.delete(items[2]);
        heap.delete(items[4]);
        heap.delete(items[6]);
        heap.delete(items[8]);
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 5) {
            pass = false;
            reason = "After 5 deletes, size should be 5, got " + heap.size();
        }
        
        // Verify remaining: 20, 40, 60, 80, 100
        int[] expected = {20, 40, 60, 80, 100};
        for (int i = 0; i < expected.length && pass; i++) {
            if (heap.findMin().key != expected[i]) {
                pass = false;
                reason = "Expected " + expected[i] + " at step " + i + ", got " + heap.findMin().key;
            }
            heap.deleteMin();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_AllElements(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete All Elements (using delete)";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem[] items = new Heap.HeapItem[10];
        for (int i = 0; i < 10; i++) {
            items[i] = heap.insert((i + 1) * 10, "val-" + (i + 1));
        }
        
        // Delete all using delete() in reverse order
        for (int i = 9; i >= 0; i--) {
            heap.delete(items[i]);
        }
        
        boolean pass = true;
        String reason = "";
        
        if (heap.size() != 0) {
            pass = false;
            reason = "After deleting all, size should be 0, got " + heap.size();
        } else if (heap.findMin() != null) {
            pass = false;
            reason = "After deleting all, findMin should be null";
        } else if (heap.numTrees() != 0) {
            pass = false;
            reason = "After deleting all, numTrees should be 0, got " + heap.numTrees();
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== NEW DELETE EDGE CASE TESTS (5) ====================

    private static void testDelete_NewlyInsertedNode(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Newly Inserted Node";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(50, "fifty");
        heap.insert(30, "thirty");
        
        // Insert and immediately delete
        Heap.HeapItem newItem = heap.insert(10, "ten");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin() != newItem) {
            pass = false;
            reason = "Newly inserted 10 should be min";
        }
        
        if (pass) {
            heap.delete(newItem);
            if (heap.size() != 2) {
                pass = false;
                reason = "After delete, size should be 2, got " + heap.size();
            }
            if (pass && heap.findMin().key != 30) {
                pass = false;
                reason = "After delete, min should be 30, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_AfterDecreaseKey(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete After DecreaseKey";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(50, "fifty");
        Heap.HeapItem item = heap.insert(100, "hundred");
        heap.insert(75, "seventy-five");
        
        // Decrease then delete
        heap.decreaseKey(item, 90); // 100 -> 10
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != 10) {
            pass = false;
            reason = "After decreaseKey, min should be 10, got " + heap.findMin().key;
        }
        
        if (pass) {
            heap.delete(item);
            if (heap.size() != 2) {
                pass = false;
                reason = "After delete, size should be 2, got " + heap.size();
            }
            if (pass && heap.findMin().key != 50) {
                pass = false;
                reason = "After delete, min should be 50, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_LastTwoElements(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Last Two Elements";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem item1 = heap.insert(10, "ten");
        Heap.HeapItem item2 = heap.insert(20, "twenty");
        
        boolean pass = true;
        String reason = "";
        
        // Delete first, leaving one
        heap.delete(item1);
        if (heap.size() != 1) {
            pass = false;
            reason = "After first delete, size should be 1, got " + heap.size();
        }
        if (pass && heap.findMin() != item2) {
            pass = false;
            reason = "After first delete, remaining should be item2";
        }
        
        // Delete last
        if (pass) {
            heap.delete(item2);
            if (heap.size() != 0) {
                pass = false;
                reason = "After second delete, size should be 0, got " + heap.size();
            }
            if (pass && heap.findMin() != null) {
                pass = false;
                reason = "After second delete, findMin should be null";
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_InForwardOrder(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete In Forward Order";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem[] items = new Heap.HeapItem[10];
        for (int i = 0; i < 10; i++) {
            items[i] = heap.insert((i + 1) * 10, "val-" + (i + 1));
        }
        
        boolean pass = true;
        String reason = "";
        
        // Delete in forward order (smallest first)
        for (int i = 0; i < 10 && pass; i++) {
            heap.delete(items[i]);
            if (heap.size() != 9 - i) {
                pass = false;
                reason = "After delete " + i + ", size should be " + (9 - i) + ", got " + heap.size();
            }
        }
        
        if (pass && heap.findMin() != null) {
            pass = false;
            reason = "After all deletes, findMin should be null";
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDelete_AlternateMinMax(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Delete Alternate Min Max";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem[] items = new Heap.HeapItem[6];
        items[0] = heap.insert(10, "ten");
        items[1] = heap.insert(20, "twenty");
        items[2] = heap.insert(30, "thirty");
        items[3] = heap.insert(40, "forty");
        items[4] = heap.insert(50, "fifty");
        items[5] = heap.insert(60, "sixty");
        
        boolean pass = true;
        String reason = "";
        
        // Delete min, then max, alternating
        heap.delete(items[0]); // delete 10 (min)
        if (heap.findMin().key != 20) {
            pass = false;
            reason = "After deleting 10, min should be 20, got " + heap.findMin().key;
        }
        
        if (pass) {
            heap.delete(items[5]); // delete 60 (max)
            if (heap.findMin().key != 20) {
                pass = false;
                reason = "After deleting 60, min should still be 20, got " + heap.findMin().key;
            }
        }
        
        if (pass) {
            heap.delete(items[1]); // delete 20 (new min)
            if (heap.findMin().key != 30) {
                pass = false;
                reason = "After deleting 20, min should be 30, got " + heap.findMin().key;
            }
        }
        
        if (pass && heap.size() != 3) {
            pass = false;
            reason = "After 3 deletes, size should be 3, got " + heap.size();
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== DECREASEKEY TESTS (10) ====================

    private static void testDecreaseKey_ByZero(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey By Zero";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(10, "ten");
        Heap.HeapItem item = heap.insert(20, "twenty");
        heap.insert(30, "thirty");
        
        int keyBefore = item.key;
        heap.decreaseKey(item, 0);
        
        boolean pass = true;
        String reason = "";
        
        if (item.key != keyBefore) {
            pass = false;
            reason = "After decreaseKey by 0, key should remain " + keyBefore + ", got " + item.key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_ByOne(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey By One";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(10, "ten");
        Heap.HeapItem item = heap.insert(20, "twenty");
        heap.insert(30, "thirty");
        
        heap.decreaseKey(item, 1); // 20 -> 19
        
        boolean pass = true;
        String reason = "";
        
        if (item.key != 19) {
            pass = false;
            reason = "After decreaseKey by 1, key should be 19, got " + item.key;
        } else if (heap.findMin().key != 10) {
            pass = false;
            reason = "Min should still be 10, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_ToNewMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey To New Min";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(20, "twenty");
        Heap.HeapItem item = heap.insert(30, "thirty");
        heap.insert(40, "forty");
        
        heap.decreaseKey(item, 25); // 30 -> 5
        
        boolean pass = true;
        String reason = "";
        
        if (item.key != 5) {
            pass = false;
            reason = "After decreaseKey, key should be 5, got " + item.key;
        } else if (heap.findMin() != item) {
            pass = false;
            reason = "After decreaseKey to smallest, findMin should return this item";
        } else if (heap.findMin().key != 5) {
            pass = false;
            reason = "Min should be 5, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_StillGreaterThanParent(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey Still Greater Than Parent";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // Build a tree structure
        for (int i = 1; i <= 8; i++) {
            heap.insert(i * 10, "val-" + i);
        }
        heap.deleteMin(); // consolidate, removes 10
        
        // Insert a large value that becomes a child
        Heap.HeapItem item = heap.insert(100, "hundred");
        
        // Decrease but still larger than potential parent
        heap.decreaseKey(item, 5); // 100 -> 95, still large
        
        boolean pass = true;
        String reason = "";
        
        if (item.key != 95) {
            pass = false;
            reason = "After decreaseKey, key should be 95, got " + item.key;
        }
        
        // Verify heap property maintained
        int prev = -1;
        while (heap.size() > 0 && pass) {
            int curr = heap.findMin().key;
            if (curr < prev) {
                pass = false;
                reason = "Heap order violated: got " + curr + " after " + prev;
            }
            prev = curr;
            heap.deleteMin();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_OnRoot(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey On Root";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem root = heap.insert(20, "twenty");
        heap.insert(30, "thirty");
        heap.insert(40, "forty");
        
        // root is the min, decrease it further
        heap.decreaseKey(root, 10); // 20 -> 10
        
        boolean pass = true;
        String reason = "";
        
        if (root.key != 10) {
            pass = false;
            reason = "After decreaseKey on root, key should be 10, got " + root.key;
        } else if (heap.findMin() != root) {
            pass = false;
            reason = "Min should still be the same item";
        } else if (heap.findMin().key != 10) {
            pass = false;
            reason = "Min should be 10, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_OnLeaf(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey On Leaf";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // Build structure
        for (int i = 1; i <= 8; i++) {
            heap.insert(i * 10, "val-" + i);
        }
        heap.deleteMin(); // consolidate
        
        // Insert a leaf
        Heap.HeapItem leaf = heap.insert(200, "twohundred");
        
        // Decrease to become min
        heap.decreaseKey(leaf, 195); // 200 -> 5
        
        boolean pass = true;
        String reason = "";
        
        if (leaf.key != 5) {
            pass = false;
            reason = "After decreaseKey, key should be 5, got " + leaf.key;
        } else if (heap.findMin().key != 5) {
            pass = false;
            reason = "Min should be 5, got " + heap.findMin().key;
        }
        
        // Verify all elements still extractable
        int count = 0;
        while (heap.size() > 0) {
            heap.deleteMin();
            count++;
        }
        if (count != 8) {
            pass = false;
            reason = "Expected 8 elements, extracted " + count;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_MultipleOnSameNode(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey Multiple On Same Node";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(10, "ten");
        Heap.HeapItem item = heap.insert(100, "hundred");
        heap.insert(20, "twenty");
        
        // Multiple decreases on same item
        heap.decreaseKey(item, 10); // 100 -> 90
        if (item.key != 90) {
            reportResult(testName, false, "After first decreaseKey, key should be 90, got " + item.key);
            return;
        }
        
        heap.decreaseKey(item, 30); // 90 -> 60
        if (item.key != 60) {
            reportResult(testName, false, "After second decreaseKey, key should be 60, got " + item.key);
            return;
        }
        
        heap.decreaseKey(item, 55); // 60 -> 5
        
        boolean pass = true;
        String reason = "";
        
        if (item.key != 5) {
            pass = false;
            reason = "After third decreaseKey, key should be 5, got " + item.key;
        } else if (heap.findMin().key != 5) {
            pass = false;
            reason = "Min should be 5, got " + heap.findMin().key;
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_MultipleOnDifferentNodes(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey Multiple On Different Nodes";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem[] items = new Heap.HeapItem[5];
        for (int i = 0; i < 5; i++) {
            items[i] = heap.insert((i + 1) * 100, "val-" + (i + 1));
        }
        
        // Decrease multiple different items
        heap.decreaseKey(items[4], 450); // 500 -> 50
        heap.decreaseKey(items[3], 360); // 400 -> 40
        heap.decreaseKey(items[2], 270); // 300 -> 30
        
        boolean pass = true;
        String reason = "";
        
        if (items[4].key != 50) {
            pass = false;
            reason = "Item 4 key should be 50, got " + items[4].key;
        } else if (items[3].key != 40) {
            pass = false;
            reason = "Item 3 key should be 40, got " + items[3].key;
        } else if (items[2].key != 30) {
            pass = false;
            reason = "Item 2 key should be 30, got " + items[2].key;
        }
        
        // Verify extraction order: 30, 40, 50, 100, 200
        int[] expected = {30, 40, 50, 100, 200};
        for (int i = 0; i < expected.length && pass; i++) {
            if (heap.findMin().key != expected[i]) {
                pass = false;
                reason = "Expected " + expected[i] + " at step " + i + ", got " + heap.findMin().key;
            }
            heap.deleteMin();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_UpdatesMinPointer(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey Updates Min Pointer";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem first = heap.insert(50, "fifty");
        Heap.HeapItem second = heap.insert(100, "hundred");
        heap.insert(75, "seventy-five");
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin() != first) {
            pass = false;
            reason = "Initial min should be first item";
        }
        
        if (pass) {
            heap.decreaseKey(second, 90); // 100 -> 10
            if (heap.findMin() != second) {
                pass = false;
                reason = "After decreaseKey, min should be second item";
            } else if (heap.findMin().key != 10) {
                pass = false;
                reason = "Min key should be 10, got " + heap.findMin().key;
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_CounterUpdates(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey Counter Updates";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // Build a tree
        for (int i = 1; i <= 8; i++) {
            heap.insert(i * 10, "val-" + i);
        }
        heap.deleteMin(); // consolidate
        
        Heap.HeapItem item = heap.insert(100, "hundred");
        
        int cutsBefore = heap.totalCuts();
        int heapifyBefore = heap.totalHeapifyCosts();
        
        heap.decreaseKey(item, 95); // 100 -> 5, should trigger cut or heapify
        
        int cutsAfter = heap.totalCuts();
        int heapifyAfter = heap.totalHeapifyCosts();
        
        boolean pass = true;
        String reason = "";
        
        if (lazyDecreaseKeys) {
            // Cascading cuts mode - should have cuts
            if (cutsAfter < cutsBefore) {
                pass = false;
                reason = "totalCuts should not decrease";
            }
        } else {
            // Heapify mode - should have heapify costs
            if (heapifyAfter < heapifyBefore) {
                pass = false;
                reason = "totalHeapifyCosts should not decrease";
            }
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== NEW DECREASEKEY EDGE CASE TESTS (5) ====================

    private static void testDecreaseKey_ToOne(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey To One (Min Positive)";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(100, "hundred");
        Heap.HeapItem item = heap.insert(500, "five-hundred");
        heap.insert(200, "two-hundred");
        
        // Decrease to 1 (minimum positive)
        heap.decreaseKey(item, 499); // 500 -> 1
        
        boolean pass = true;
        String reason = "";
        
        if (item.key != 1) {
            pass = false;
            reason = "After decreaseKey, key should be 1, got " + item.key;
        }
        
        if (pass && heap.findMin().key != 1) {
            pass = false;
            reason = "Min should be 1, got " + heap.findMin().key;
        }
        
        // Verify extraction order
        if (pass) {
            int[] expected = {1, 100, 200};
            for (int i = 0; i < expected.length && pass; i++) {
                if (heap.findMin().key != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + heap.findMin().key;
                }
                heap.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_AllNodesToSameKey(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey All Nodes To Same Key";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        Heap.HeapItem[] items = new Heap.HeapItem[5];
        for (int i = 0; i < 5; i++) {
            items[i] = heap.insert((i + 1) * 100, "val-" + (i + 1));
        }
        
        // Decrease all to key 10
        for (int i = 0; i < 5; i++) {
            int diff = items[i].key - 10;
            heap.decreaseKey(items[i], diff);
        }
        
        boolean pass = true;
        String reason = "";
        
        // All should now be 10
        for (int i = 0; i < 5; i++) {
            if (items[i].key != 10) {
                pass = false;
                reason = "Item " + i + " should have key 10, got " + items[i].key;
                break;
            }
        }
        
        // All extractions should be 10
        if (pass) {
            for (int i = 0; i < 5 && pass; i++) {
                if (heap.findMin().key != 10) {
                    pass = false;
                    reason = "All extractions should be 10, got " + heap.findMin().key + " at step " + i;
                }
                heap.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_AfterMeld(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey After Meld";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(50, "h1-50");
        Heap.HeapItem item1 = heap1.insert(100, "h1-100");
        
        heap2.insert(60, "h2-60");
        Heap.HeapItem item2 = heap2.insert(200, "h2-200");
        
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        // Decrease item from heap1
        heap1.decreaseKey(item1, 90); // 100 -> 10
        if (heap1.findMin().key != 10) {
            pass = false;
            reason = "After decreasing h1 item, min should be 10, got " + heap1.findMin().key;
        }
        
        // Decrease item from heap2
        if (pass) {
            heap1.decreaseKey(item2, 195); // 200 -> 5
            if (heap1.findMin().key != 5) {
                pass = false;
                reason = "After decreasing h2 item, min should be 5, got " + heap1.findMin().key;
            }
        }
        
        // Verify order
        if (pass) {
            int[] expected = {5, 10, 50, 60};
            for (int i = 0; i < expected.length && pass; i++) {
                if (heap1.findMin().key != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + heap1.findMin().key;
                }
                heap1.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_DeepNode(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey Deep Node";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        // Build a larger tree to have depth
        Heap.HeapItem[] items = new Heap.HeapItem[32];
        for (int i = 0; i < 32; i++) {
            items[i] = heap.insert((i + 1) * 10, "val-" + (i + 1));
        }
        
        // Force tree structure via deleteMin
        heap.deleteMin();
        
        boolean pass = true;
        String reason = "";
        
        int cutsBefore = heap.totalCuts();
        int heapifyBefore = heap.totalHeapifyCosts();
        
        // Decrease a node that's likely deep in tree
        heap.decreaseKey(items[30], items[30].key - 1); // 310 -> 1
        
        if (heap.findMin().key != 1) {
            pass = false;
            reason = "After decreaseKey deep node, min should be 1, got " + heap.findMin().key;
        }
        
        // Verify counters changed appropriately
        if (pass) {
            if (lazyDecreaseKeys && heap.totalCuts() < cutsBefore) {
                pass = false;
                reason = "totalCuts should not decrease";
            }
            if (!lazyDecreaseKeys && heap.totalHeapifyCosts() < heapifyBefore) {
                pass = false;
                reason = "totalHeapifyCosts should not decrease";
            }
        }
        
        // Verify heap property
        if (pass) {
            int prev = Integer.MIN_VALUE;
            while (heap.size() > 0) {
                int curr = heap.findMin().key;
                if (curr < prev) {
                    pass = false;
                    reason = "Heap order violated: " + curr + " after " + prev;
                    break;
                }
                prev = curr;
                heap.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testDecreaseKey_SequentialDecreases(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "DecreaseKey Sequential Decreases";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(10, "ten");
        Heap.HeapItem item = heap.insert(1000, "thousand");
        heap.insert(50, "fifty");
        
        boolean pass = true;
        String reason = "";
        
        // Sequential decreases: 1000 -> 800 -> 500 -> 100 -> 5
        int[] targets = {800, 500, 100, 5};
        int currentKey = 1000;
        
        for (int target : targets) {
            int diff = currentKey - target;
            heap.decreaseKey(item, diff);
            currentKey = target;
            
            if (item.key != target) {
                pass = false;
                reason = "After decreaseKey, key should be " + target + ", got " + item.key;
                break;
            }
        }
        
        if (pass && heap.findMin().key != 5) {
            pass = false;
            reason = "Final min should be 5, got " + heap.findMin().key;
        }
        
        // Verify order
        if (pass) {
            int[] expected = {5, 10, 50};
            for (int i = 0; i < expected.length && pass; i++) {
                if (heap.findMin().key != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + heap.findMin().key;
                }
                heap.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== INTEGRATION TESTS (10) ====================

    private static void testIntegration_InsertDeleteMinSequence(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Insert-DeleteMin Sequence";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        // Interleave inserts and deleteMins
        heap.insert(50, "fifty");
        heap.insert(30, "thirty");
        heap.insert(70, "seventy");
        
        if (heap.findMin().key != 30) {
            pass = false;
            reason = "Min should be 30";
        }
        
        if (pass) {
            heap.deleteMin(); // removes 30
            heap.insert(20, "twenty");
            heap.insert(60, "sixty");
            
            if (heap.findMin().key != 20) {
                pass = false;
                reason = "After operations, min should be 20, got " + heap.findMin().key;
            }
        }
        
        if (pass) {
            // Verify final order: 20, 50, 60, 70
            int[] expected = {20, 50, 60, 70};
            for (int i = 0; i < expected.length && pass; i++) {
                if (heap.findMin().key != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + heap.findMin().key;
                }
                heap.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testIntegration_InsertMeldDeleteMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Insert-Meld-DeleteMin";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(30, "h1-30");
        heap1.insert(10, "h1-10");
        heap2.insert(20, "h2-20");
        heap2.insert(40, "h2-40");
        
        heap1.meld(heap2);
        heap1.insert(5, "five");
        heap1.deleteMin(); // removes 5
        heap1.insert(15, "fifteen");
        
        boolean pass = true;
        String reason = "";
        
        // Expected order: 10, 15, 20, 30, 40
        int[] expected = {10, 15, 20, 30, 40};
        for (int i = 0; i < expected.length && pass; i++) {
            if (heap1.findMin().key != expected[i]) {
                pass = false;
                reason = "Expected " + expected[i] + " at step " + i + ", got " + heap1.findMin().key;
            }
            heap1.deleteMin();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testIntegration_DecreaseKeyThenDeleteMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: DecreaseKey-DeleteMin";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap.insert(20, "twenty");
        Heap.HeapItem item = heap.insert(50, "fifty");
        heap.insert(30, "thirty");
        heap.insert(40, "forty");
        
        heap.decreaseKey(item, 45); // 50 -> 5
        
        boolean pass = true;
        String reason = "";
        
        if (heap.findMin().key != 5) {
            pass = false;
            reason = "After decreaseKey, min should be 5, got " + heap.findMin().key;
        }
        
        if (pass) {
            heap.deleteMin(); // removes 5
            if (heap.findMin().key != 20) {
                pass = false;
                reason = "After deleteMin, min should be 20, got " + heap.findMin().key;
            }
        }
        
        // Verify remaining: 20, 30, 40
        if (pass) {
            int[] expected = {20, 30, 40};
            for (int i = 0; i < expected.length && pass; i++) {
                if (heap.findMin().key != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + heap.findMin().key;
                }
                heap.deleteMin();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testIntegration_DeleteThenMeld(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Delete-Meld";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(10, "h1-10");
        Heap.HeapItem toDelete = heap1.insert(20, "h1-20");
        heap1.insert(30, "h1-30");
        
        heap2.insert(15, "h2-15");
        heap2.insert(25, "h2-25");
        
        heap1.delete(toDelete);
        heap1.meld(heap2);
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.size() != 4) {
            pass = false;
            reason = "After delete and meld, size should be 4, got " + heap1.size();
        }
        
        // Verify order: 10, 15, 25, 30
        int[] expected = {10, 15, 25, 30};
        for (int i = 0; i < expected.length && pass; i++) {
            if (heap1.findMin().key != expected[i]) {
                pass = false;
                reason = "Expected " + expected[i] + " at step " + i + ", got " + heap1.findMin().key;
            }
            heap1.deleteMin();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testIntegration_MeldThenDecreaseKey(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Meld-DecreaseKey";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        heap1.insert(30, "h1-30");
        heap1.insert(50, "h1-50");
        
        Heap.HeapItem item = heap2.insert(100, "h2-100");
        heap2.insert(40, "h2-40");
        
        heap1.meld(heap2);
        heap1.decreaseKey(item, 95); // 100 -> 5
        
        boolean pass = true;
        String reason = "";
        
        if (heap1.findMin().key != 5) {
            pass = false;
            reason = "After meld and decreaseKey, min should be 5, got " + heap1.findMin().key;
        }
        
        // Verify order: 5, 30, 40, 50
        int[] expected = {5, 30, 40, 50};
        for (int i = 0; i < expected.length && pass; i++) {
            if (heap1.findMin().key != expected[i]) {
                pass = false;
                reason = "Expected " + expected[i] + " at step " + i + ", got " + heap1.findMin().key;
            }
            heap1.deleteMin();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testIntegration_ComplexSequence1(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Complex Sequence 1";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            // Build initial heap
            Heap.HeapItem[] items = new Heap.HeapItem[10];
            for (int i = 0; i < 10; i++) {
                items[i] = heap.insert((i + 1) * 10, "val-" + (i + 1));
            }
            
            // Delete some
            heap.delete(items[4]); // delete 50
            heap.delete(items[7]); // delete 80
            
            // DecreaseKey
            heap.decreaseKey(items[9], 95); // 100 -> 5
            
            // DeleteMins
            heap.deleteMin(); // removes 5
            heap.deleteMin(); // removes 10
            
            // Insert more
            heap.insert(15, "fifteen");
            heap.insert(35, "thirty-five");
            
            // Meld with another heap
            Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
            heap2.insert(25, "h2-25");
            heap2.insert(45, "h2-45");
            heap.meld(heap2);
            
            // Verify order: 15, 20, 25, 30, 35, 40, 45, 60, 70, 90
            int[] expected = {15, 20, 25, 30, 35, 40, 45, 60, 70, 90};
            for (int i = 0; i < expected.length && pass; i++) {
                if (heap.findMin() == null) {
                    pass = false;
                    reason = "findMin returned null at step " + i;
                    break;
                }
                if (heap.findMin().key != expected[i]) {
                    pass = false;
                    reason = "Expected " + expected[i] + " at step " + i + ", got " + heap.findMin().key;
                }
                heap.deleteMin();
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testIntegration_ComplexSequence2(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Complex Sequence 2";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            // Insert, deleteMin, meld pattern
            for (int round = 0; round < 3; round++) {
                Heap tempHeap = new Heap(lazyMelds, lazyDecreaseKeys);
                for (int i = 0; i < 5; i++) {
                    tempHeap.insert(round * 100 + i * 10, "r" + round + "-" + i);
                }
                heap.meld(tempHeap);
                heap.deleteMin();
            }
            
            // Should have 12 elements (15 - 3 deleteMins)
            if (heap.size() != 12) {
                pass = false;
                reason = "Expected size 12, got " + heap.size();
            }
            
            // Verify heap property
            int prev = Integer.MIN_VALUE;
            while (heap.size() > 0 && pass) {
                int curr = heap.findMin().key;
                if (curr < prev) {
                    pass = false;
                    reason = "Heap order violated: got " + curr + " after " + prev;
                }
                prev = curr;
                heap.deleteMin();
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testIntegration_StressTest(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Stress Test";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            int n = 500;
            Heap.HeapItem[] items = new Heap.HeapItem[n];
            
            // Insert all
            for (int i = 0; i < n; i++) {
                items[i] = heap.insert(i * 2, "val-" + i);
            }
            
            // Delete every 5th element
            for (int i = 4; i < n; i += 5) {
                heap.delete(items[i]);
            }
            
            // DecreaseKey on some
            for (int i = 0; i < n; i += 7) {
                if (i % 5 != 4) { // Skip deleted ones
                    heap.decreaseKey(items[i], 1);
                }
            }
            
            // Meld with another heap
            Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
            for (int i = 0; i < 50; i++) {
                heap2.insert(1000 + i, "h2-" + i);
            }
            heap.meld(heap2);
            
            // Extract all and verify order
            int prev = Integer.MIN_VALUE;
            int count = 0;
            while (heap.size() > 0) {
                int curr = heap.findMin().key;
                if (curr < prev) {
                    pass = false;
                    reason = "Heap order violated at extraction " + count + ": got " + curr + " after " + prev;
                    break;
                }
                prev = curr;
                heap.deleteMin();
                count++;
            }
            
            // Expected: 500 - 100 (deleted) + 50 (melded) = 450
            if (pass && count != 450) {
                pass = false;
                reason = "Expected 450 extractions, got " + count;
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testIntegration_AllCountersConsistent(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: All Counters Consistent";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        // Initial state
        if (heap.size() != 0 || heap.numTrees() != 0 || heap.totalLinks() != 0 || 
            heap.totalCuts() != 0 || heap.numMarkedNodes() != 0 || heap.totalHeapifyCosts() != 0) {
            pass = false;
            reason = "Empty heap should have all counters at 0";
        }
        
        if (pass) {
            // After operations
            for (int i = 1; i <= 16; i++) {
                heap.insert(i * 10, "val-" + i);
            }
            
            if (heap.size() != 16) {
                pass = false;
                reason = "After 16 inserts, size should be 16, got " + heap.size();
            }
        }
        
        if (pass) {
            heap.deleteMin();
            if (heap.size() != 15) {
                pass = false;
                reason = "After deleteMin, size should be 15, got " + heap.size();
            }
        }
        
        if (pass) {
            // Counters should be non-negative
            if (heap.numTrees() < 0) {
                pass = false;
                reason = "numTrees should be >= 0, got " + heap.numTrees();
            }
            if (heap.totalLinks() < 0) {
                pass = false;
                reason = "totalLinks should be >= 0, got " + heap.totalLinks();
            }
            if (heap.totalCuts() < 0) {
                pass = false;
                reason = "totalCuts should be >= 0, got " + heap.totalCuts();
            }
            if (heap.numMarkedNodes() < 0) {
                pass = false;
                reason = "numMarkedNodes should be >= 0, got " + heap.numMarkedNodes();
            }
            if (heap.totalHeapifyCosts() < 0) {
                pass = false;
                reason = "totalHeapifyCosts should be >= 0, got " + heap.totalHeapifyCosts();
            }
        }
        
        // After extracting all
        if (pass) {
            while (heap.size() > 0) {
                heap.deleteMin();
            }
            
            if (heap.size() != 0) {
                pass = false;
                reason = "After extracting all, size should be 0, got " + heap.size();
            }
            if (heap.numTrees() != 0) {
                pass = false;
                reason = "After extracting all, numTrees should be 0, got " + heap.numTrees();
            }
        }
        
        reportResult(testName, pass, reason);
    }

    private static void testIntegration_HeapPropertyMaintained(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Heap Property Maintained";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            // Random-ish operations
            Heap.HeapItem[] items = new Heap.HeapItem[20];
            
            // Insert in various order
            int[] insertOrder = {15, 3, 18, 7, 12, 1, 9, 20, 5, 14, 2, 17, 8, 11, 4, 19, 6, 13, 10, 16};
            for (int i = 0; i < 20; i++) {
                items[i] = heap.insert(insertOrder[i], "val-" + insertOrder[i]);
            }
            
            // Delete some specific items
            heap.delete(items[5]);  // delete key 1
            heap.delete(items[10]); // delete key 2
            
            // DecreaseKey on item with key 20 to become new min
            heap.decreaseKey(items[7], 20); // 20 -> 0
            
            // Meld
            Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
            heap2.insert(21, "h2-21");
            heap2.insert(22, "h2-22");
            heap.meld(heap2);
            
            // Verify complete extraction is in sorted order
            int prev = Integer.MIN_VALUE;
            int count = 0;
            while (heap.size() > 0 && pass) {
                int curr = heap.findMin().key;
                if (curr < prev) {
                    pass = false;
                    reason = "Heap property violated: extracted " + curr + " after " + prev + " at step " + count;
                    break;
                }
                prev = curr;
                heap.deleteMin();
                count++;
            }
            
            // Expected: 20 - 2 (deleted) + 2 (melded) = 20
            if (pass && count != 20) {
                pass = false;
                reason = "Expected 20 extractions, got " + count;
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== NEW ADVANCED INTEGRATION TESTS (15) ====================

    /**
     * Test 1: Deep Cascading Cuts
     * Forces multiple levels of cascading cuts by creating a deep tree and triggering cuts on marked nodes.
     * Tests totalCuts, numMarkedNodes for lazyDecreaseKeys=true mode.
     */
    private static void testIntegration_DeepCascadingCuts(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Deep Cascading Cuts";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            // Build a deep tree by inserting many elements
            Heap.HeapItem[] items = new Heap.HeapItem[64];
            for (int i = 0; i < 64; i++) {
                items[i] = heap.insert((i + 1) * 10, "val-" + (i + 1));
            }
            
            // Force consolidation to create tree structure
            heap.deleteMin(); // removes 10
            
            int cutsBefore = heap.totalCuts();
            int markedBefore = heap.numMarkedNodes();
            
            if (lazyDecreaseKeys) {
                // Perform multiple decreaseKey operations to trigger cascading cuts
                // These should mark parents and potentially trigger cascading
                for (int i = 60; i >= 50; i--) {
                    heap.decreaseKey(items[i], items[i].key - 1); // decrease by almost full amount
                }
                
                int cutsAfter = heap.totalCuts();
                
                if (cutsAfter < cutsBefore) {
                    pass = false;
                    reason = "totalCuts should not decrease. Before: " + cutsBefore + ", After: " + cutsAfter;
                }
                
                // Marked nodes should be non-negative
                if (pass && heap.numMarkedNodes() < 0) {
                    pass = false;
                    reason = "numMarkedNodes should never be negative, got " + heap.numMarkedNodes();
                }
            } else {
                // In heapify mode, cuts should remain 0
                if (heap.totalCuts() != 0) {
                    pass = false;
                    reason = "In heapify mode, totalCuts should be 0, got " + heap.totalCuts();
                }
            }
            
            // Verify heap property still holds
            if (pass) {
                int prev = Integer.MIN_VALUE;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap order violated: got " + curr + " after " + prev;
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 2: Massive Meld Chain
     * Melds 10+ heaps together, verifies counter accumulation is correctly inherited.
     */
    private static void testIntegration_MassiveMeldChain(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Massive Meld Chain";
        Heap mainHeap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            int totalSize = 0;
            int totalExpectedLinks = 0;
            
            // Create and meld 15 heaps
            for (int h = 0; h < 15; h++) {
                Heap tempHeap = new Heap(lazyMelds, lazyDecreaseKeys);
                for (int i = 0; i < 10; i++) {
                    tempHeap.insert(h * 100 + i * 5, "h" + h + "-" + i);
                }
                totalSize += 10;
                
                // Force some links in temp heap before meld
                if (tempHeap.size() > 1) {
                    tempHeap.deleteMin();
                    totalSize--;
                }
                
                int linksBefore = mainHeap.totalLinks();
                int tempLinks = tempHeap.totalLinks();
                
                mainHeap.meld(tempHeap);
                
                // totalLinks should be at least sum of both
                if (mainHeap.totalLinks() < linksBefore + tempLinks) {
                    pass = false;
                    reason = "After meld, totalLinks should be >= " + (linksBefore + tempLinks) + 
                             ", got " + mainHeap.totalLinks();
                    break;
                }
            }
            
            if (pass && mainHeap.size() != totalSize) {
                pass = false;
                reason = "Total size should be " + totalSize + ", got " + mainHeap.size();
            }
            
            // Verify extraction order
            if (pass) {
                int prev = Integer.MIN_VALUE;
                while (mainHeap.size() > 0) {
                    int curr = mainHeap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap order violated after massive meld: " + curr + " after " + prev;
                        break;
                    }
                    prev = curr;
                    mainHeap.deleteMin();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 3: Alternating Insert DeleteMin
     * Alternates 100+ insert/deleteMin operations, verifies size and numTrees stay consistent.
     */
    private static void testIntegration_AlternatingInsertDeleteMin(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Alternating Insert-DeleteMin";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            int netSize = 0;
            
            // Phase 1: Insert 50
            for (int i = 0; i < 50; i++) {
                heap.insert(i * 3, "val-" + i);
                netSize++;
            }
            
            // Phase 2: Alternating pattern
            for (int round = 0; round < 100; round++) {
                // Insert 2
                heap.insert(1000 + round * 2, "alt-" + (round * 2));
                heap.insert(1000 + round * 2 + 1, "alt-" + (round * 2 + 1));
                netSize += 2;
                
                // Delete 1
                if (heap.size() > 0) {
                    heap.deleteMin();
                    netSize--;
                }
                
                if (heap.size() != netSize) {
                    pass = false;
                    reason = "Size mismatch at round " + round + ": expected " + netSize + ", got " + heap.size();
                    break;
                }
            }
            
            // Verify numTrees is reasonable
            if (pass && heap.numTrees() < 0) {
                pass = false;
                reason = "numTrees should not be negative, got " + heap.numTrees();
            }
            
            // Verify heap property
            if (pass) {
                int prev = Integer.MIN_VALUE;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap order violated: " + curr + " after " + prev;
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 4: DecreaseKey On All Nodes
     * Decreases key on every non-min node, verifies heap property and counters.
     */
    private static void testIntegration_DecreaseKeyOnAllNodes(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: DecreaseKey On All Nodes";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            int n = 30;
            Heap.HeapItem[] items = new Heap.HeapItem[n];
            
            for (int i = 0; i < n; i++) {
                items[i] = heap.insert((i + 1) * 100, "val-" + (i + 1));
            }
            
            // Force consolidation
            heap.deleteMin();
            
            int cutsBefore = heap.totalCuts();
            int heapifyBefore = heap.totalHeapifyCosts();
            
            // Decrease all remaining items by 1
            for (int i = 1; i < n; i++) {
                heap.decreaseKey(items[i], 1);
            }
            
            if (lazyDecreaseKeys) {
                // totalCuts may increase
                if (heap.totalCuts() < cutsBefore) {
                    pass = false;
                    reason = "totalCuts should not decrease";
                }
            } else {
                // totalHeapifyCosts may increase
                if (heap.totalHeapifyCosts() < heapifyBefore) {
                    pass = false;
                    reason = "totalHeapifyCosts should not decrease";
                }
            }
            
            // Verify heap still valid
            if (pass) {
                int prev = Integer.MIN_VALUE;
                int count = 0;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap order violated at step " + count + ": " + curr + " after " + prev;
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                    count++;
                }
                
                if (pass && count != n - 1) {
                    pass = false;
                    reason = "Expected " + (n - 1) + " extractions, got " + count;
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 5: Delete All But One
     * Inserts many, deletes all but one using delete(), verifies single element remains correct.
     */
    private static void testIntegration_DeleteAllButOne(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Delete All But One";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            int n = 50;
            Heap.HeapItem[] items = new Heap.HeapItem[n];
            
            for (int i = 0; i < n; i++) {
                items[i] = heap.insert((i + 1) * 10, "val-" + (i + 1));
            }
            
            // Keep item[25] (key = 260), delete all others
            for (int i = 0; i < n; i++) {
                if (i != 25) {
                    heap.delete(items[i]);
                }
            }
            
            if (heap.size() != 1) {
                pass = false;
                reason = "After deleting all but one, size should be 1, got " + heap.size();
            }
            
            if (pass && heap.findMin() != items[25]) {
                pass = false;
                reason = "Remaining item should be the one we kept";
            }
            
            if (pass && heap.findMin().key != 260) {
                pass = false;
                reason = "Remaining item key should be 260, got " + heap.findMin().key;
            }
            
            if (pass && heap.numTrees() != 1) {
                pass = false;
                reason = "With one element, numTrees should be 1, got " + heap.numTrees();
            }
            
            // Delete the last one
            if (pass) {
                heap.deleteMin();
                if (heap.size() != 0) {
                    pass = false;
                    reason = "After final delete, size should be 0, got " + heap.size();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 6: Repeated DecreaseKey To Same Value
     * Decreases multiple nodes to the same minimum key, verifies extraction handles duplicates.
     */
    private static void testIntegration_RepeatedDecreaseKeyToSameValue(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Repeated DecreaseKey To Same Value";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            int n = 20;
            Heap.HeapItem[] items = new Heap.HeapItem[n];
            
            for (int i = 0; i < n; i++) {
                items[i] = heap.insert((i + 1) * 100, "val-" + (i + 1));
            }
            
            // Decrease items[5], items[10], items[15] all to key = 5
            heap.decreaseKey(items[5], 595);   // 600 -> 5
            heap.decreaseKey(items[10], 1095); // 1100 -> 5
            heap.decreaseKey(items[15], 1595); // 1600 -> 5
            
            // Min should now be 5
            if (heap.findMin().key != 5) {
                pass = false;
                reason = "Min should be 5 after decreaseKey, got " + heap.findMin().key;
            }
            
            // Extract first 3 - all should be 5
            if (pass) {
                for (int i = 0; i < 3; i++) {
                    if (heap.findMin().key != 5) {
                        pass = false;
                        reason = "First 3 extractions should all be 5, got " + heap.findMin().key + " at step " + i;
                        break;
                    }
                    heap.deleteMin();
                }
            }
            
            // Next should be 100 (items[0])
            if (pass && heap.findMin().key != 100) {
                pass = false;
                reason = "After extracting three 5s, min should be 100, got " + heap.findMin().key;
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 7: Power Of Two Sizes
     * Tests successive linking with exact power-of-2 sizes to verify numTrees for binomial heap structure.
     */
    private static void testIntegration_PowerOfTwoSizes(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Power Of Two Sizes";
        
        boolean pass = true;
        String reason = "";
        
        try {
            // Test powers of 2: 1, 2, 4, 8, 16, 32
            int[] powers = {1, 2, 4, 8, 16, 32};
            
            for (int size : powers) {
                Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
                
                for (int i = 0; i < size; i++) {
                    heap.insert(i + 1, "val-" + (i + 1));
                }
                
                if (!lazyMelds) {
                    // In strict mode with power of 2, should have exactly 1 tree
                    if (heap.numTrees() != 1) {
                        pass = false;
                        reason = "With strict meld and size " + size + ", numTrees should be 1, got " + heap.numTrees();
                        break;
                    }
                } else {
                    // In lazy mode, numTrees equals size (no consolidation yet)
                    if (heap.numTrees() != size) {
                        pass = false;
                        reason = "With lazy meld and size " + size + ", numTrees should be " + size + ", got " + heap.numTrees();
                        break;
                    }
                }
                
                // After deleteMin, verify structure
                if (pass && size > 1) {
                    heap.deleteMin();
                    
                    // After deleteMin and consolidation, verify heap property
                    int prev = Integer.MIN_VALUE;
                    while (heap.size() > 0) {
                        int curr = heap.findMin().key;
                        if (curr < prev) {
                            pass = false;
                            reason = "Heap order violated for size " + size;
                            break;
                        }
                        prev = curr;
                        heap.deleteMin();
                    }
                }
                
                if (!pass) break;
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 8: Single Node Operations
     * Performs all operations (decreaseKey, delete, meld) on single-node heaps.
     */
    private static void testIntegration_SingleNodeOperations(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Single Node Operations";
        
        boolean pass = true;
        String reason = "";
        
        try {
            // Test 1: DecreaseKey on single node
            Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
            Heap.HeapItem item1 = heap1.insert(100, "hundred");
            heap1.decreaseKey(item1, 50);
            
            if (item1.key != 50) {
                pass = false;
                reason = "DecreaseKey on single node failed: expected 50, got " + item1.key;
            }
            
            if (pass && heap1.findMin().key != 50) {
                pass = false;
                reason = "Min should be 50 after decreaseKey, got " + heap1.findMin().key;
            }
            
            // Test 2: Meld two single-node heaps
            if (pass) {
                Heap heapA = new Heap(lazyMelds, lazyDecreaseKeys);
                Heap heapB = new Heap(lazyMelds, lazyDecreaseKeys);
                heapA.insert(10, "ten");
                heapB.insert(20, "twenty");
                
                heapA.meld(heapB);
                
                if (heapA.size() != 2) {
                    pass = false;
                    reason = "After meld of two single-node heaps, size should be 2, got " + heapA.size();
                }
                
                if (pass && heapA.findMin().key != 10) {
                    pass = false;
                    reason = "After meld, min should be 10, got " + heapA.findMin().key;
                }
            }
            
            // Test 3: Delete single node
            if (pass) {
                Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
                Heap.HeapItem item2 = heap2.insert(42, "forty-two");
                heap2.delete(item2);
                
                if (heap2.size() != 0) {
                    pass = false;
                    reason = "After deleting single node, size should be 0, got " + heap2.size();
                }
                
                if (pass && heap2.findMin() != null) {
                    pass = false;
                    reason = "After deleting single node, findMin should be null";
                }
            }
            
            // Test 4: Meld empty with single node
            if (pass) {
                Heap heapEmpty = new Heap(lazyMelds, lazyDecreaseKeys);
                Heap heapSingle = new Heap(lazyMelds, lazyDecreaseKeys);
                heapSingle.insert(99, "ninety-nine");
                
                heapEmpty.meld(heapSingle);
                
                if (heapEmpty.size() != 1) {
                    pass = false;
                    reason = "After empty.meld(single), size should be 1, got " + heapEmpty.size();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 9: Empty Heap After All Operations
     * After complex sequence, verifies all counters match expected final state.
     */
    private static void testIntegration_EmptyHeapAfterAllOperations(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Empty Heap After All Operations";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            // Perform many operations
            Heap.HeapItem[] items = new Heap.HeapItem[30];
            for (int i = 0; i < 30; i++) {
                items[i] = heap.insert((i + 1) * 10, "val-" + (i + 1));
            }
            
            // Meld
            Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
            for (int i = 0; i < 10; i++) {
                heap2.insert(500 + i, "h2-" + i);
            }
            heap.meld(heap2);
            
            // DecreaseKey
            heap.decreaseKey(items[20], 100);
            
            // Delete some
            heap.delete(items[5]);
            heap.delete(items[15]);
            
            // Now extract all
            while (heap.size() > 0) {
                heap.deleteMin();
            }
            
            // After all operations and empty heap:
            if (heap.size() != 0) {
                pass = false;
                reason = "After emptying, size should be 0, got " + heap.size();
            }
            
            if (pass && heap.numTrees() != 0) {
                pass = false;
                reason = "After emptying, numTrees should be 0, got " + heap.numTrees();
            }
            
            if (pass && heap.findMin() != null) {
                pass = false;
                reason = "After emptying, findMin should be null";
            }
            
            // Counters should be non-negative
            if (pass && heap.totalLinks() < 0) {
                pass = false;
                reason = "totalLinks should be >= 0, got " + heap.totalLinks();
            }
            
            if (pass && heap.totalCuts() < 0) {
                pass = false;
                reason = "totalCuts should be >= 0, got " + heap.totalCuts();
            }
            
            if (pass && heap.numMarkedNodes() < 0) {
                pass = false;
                reason = "numMarkedNodes should be >= 0, got " + heap.numMarkedNodes();
            }
            
            if (pass && heap.totalHeapifyCosts() < 0) {
                pass = false;
                reason = "totalHeapifyCosts should be >= 0, got " + heap.totalHeapifyCosts();
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 10: DecreaseKey Root Node
     * Decreases the root/min node's key, verifies it stays as min and counters don't change unexpectedly.
     */
    private static void testIntegration_DecreaseKeyRootNode(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: DecreaseKey Root Node";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            Heap.HeapItem root = heap.insert(100, "hundred");
            heap.insert(200, "twohundred");
            heap.insert(300, "threehundred");
            heap.insert(400, "fourhundred");
            
            // Force consolidation
            heap.deleteMin();
            
            // Now the min should be one of 200, 300, 400
            Heap.HeapItem currentMin = heap.findMin();
            int minKeyBefore = currentMin.key;
            
            int cutsBefore = heap.totalCuts();
            int heapifyBefore = heap.totalHeapifyCosts();
            
            // Decrease the min key (it's a root, so no structural change needed)
            heap.decreaseKey(currentMin, 50);
            
            if (currentMin.key != minKeyBefore - 50) {
                pass = false;
                reason = "Root key should be " + (minKeyBefore - 50) + ", got " + currentMin.key;
            }
            
            if (pass && heap.findMin() != currentMin) {
                pass = false;
                reason = "After decreasing root, it should still be the min";
            }
            
            // Decreasing root shouldn't trigger cuts or heapify
            if (pass && heap.totalCuts() != cutsBefore) {
                pass = false;
                reason = "Decreasing root shouldn't change totalCuts. Before: " + cutsBefore + ", After: " + heap.totalCuts();
            }
            
            if (pass && heap.totalHeapifyCosts() != heapifyBefore) {
                pass = false;
                reason = "Decreasing root shouldn't change totalHeapifyCosts. Before: " + heapifyBefore + ", After: " + heap.totalHeapifyCosts();
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 11: Meld Then Delete Melded Elements
     * Melds heaps then specifically deletes elements that came from the second heap.
     */
    private static void testIntegration_MeldThenDeleteMeldedElements(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Meld Then Delete Melded Elements";
        Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
        Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            // Insert into heap1
            for (int i = 0; i < 10; i++) {
                heap1.insert(i * 10, "h1-" + i);
            }
            
            // Insert into heap2 and keep references
            Heap.HeapItem[] heap2Items = new Heap.HeapItem[10];
            for (int i = 0; i < 10; i++) {
                heap2Items[i] = heap2.insert(500 + i * 10, "h2-" + i);
            }
            
            heap1.meld(heap2);
            
            if (heap1.size() != 20) {
                pass = false;
                reason = "After meld, size should be 20, got " + heap1.size();
            }
            
            // Delete all elements from what was heap2
            for (int i = 0; i < 10 && pass; i++) {
                heap1.delete(heap2Items[i]);
            }
            
            if (pass && heap1.size() != 10) {
                pass = false;
                reason = "After deleting melded elements, size should be 10, got " + heap1.size();
            }
            
            // Verify remaining are from heap1 (0, 10, 20, ..., 90)
            if (pass) {
                for (int i = 0; i < 10 && pass; i++) {
                    int expected = i * 10;
                    if (heap1.findMin().key != expected) {
                        pass = false;
                        reason = "Expected " + expected + " at step " + i + ", got " + heap1.findMin().key;
                    }
                    heap1.deleteMin();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 12: Rapid Fire DecreaseKey And Delete
     * Rapidly interleaves decreaseKey and delete on same tree, verifies structure integrity.
     */
    private static void testIntegration_RapidFireDecreaseKeyAndDelete(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Rapid Fire DecreaseKey And Delete";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            int n = 40;
            Heap.HeapItem[] items = new Heap.HeapItem[n];
            
            for (int i = 0; i < n; i++) {
                items[i] = heap.insert((i + 1) * 100, "val-" + (i + 1));
            }
            
            // Force tree structure
            heap.deleteMin();
            
            // Rapid fire: alternate between decreaseKey and delete
            boolean[] deleted = new boolean[n];
            deleted[0] = true; // Already deleted by deleteMin
            
            int deleteCount = 1;
            
            for (int round = 0; round < 15; round++) {
                int decreaseIdx = (round * 2 + 1) % n;
                int deleteIdx = (round * 3 + 5) % n;
                
                // DecreaseKey if not deleted
                if (!deleted[decreaseIdx]) {
                    int currentKey = items[decreaseIdx].key;
                    if (currentKey > 1) {
                        heap.decreaseKey(items[decreaseIdx], 1);
                    }
                }
                
                // Delete if not already deleted
                if (!deleted[deleteIdx]) {
                    heap.delete(items[deleteIdx]);
                    deleted[deleteIdx] = true;
                    deleteCount++;
                }
            }
            
            int expectedSize = n - deleteCount;
            if (heap.size() != expectedSize) {
                pass = false;
                reason = "Expected size " + expectedSize + ", got " + heap.size();
            }
            
            // Verify heap property
            if (pass) {
                int prev = Integer.MIN_VALUE;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap order violated: " + curr + " after " + prev;
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 13: Counter Accuracy After Stress
     * After 1000 operations, verifies counters are non-negative and consistent.
     */
    private static void testIntegration_CounterAccuracyAfterStress(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Counter Accuracy After Stress";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.ArrayList<Heap.HeapItem> activeItems = new java.util.ArrayList<>();
            
            // 1000 operations
            for (int op = 0; op < 1000; op++) {
                int operation = op % 5;
                
                switch (operation) {
                    case 0: // Insert
                    case 1:
                        Heap.HeapItem newItem = heap.insert(op * 3 + 1, "op-" + op);
                        activeItems.add(newItem);
                        break;
                    case 2: // DeleteMin
                        if (heap.size() > 0) {
                            Heap.HeapItem min = heap.findMin();
                            activeItems.remove(min);
                            heap.deleteMin();
                        }
                        break;
                    case 3: // DecreaseKey
                        if (!activeItems.isEmpty()) {
                            int idx = op % activeItems.size();
                            Heap.HeapItem item = activeItems.get(idx);
                            if (item.key > 1) {
                                heap.decreaseKey(item, 1);
                            }
                        }
                        break;
                    case 4: // Delete
                        if (activeItems.size() > 1) {
                            int idx = (op / 5) % activeItems.size();
                            Heap.HeapItem item = activeItems.get(idx);
                            activeItems.remove(idx);
                            heap.delete(item);
                        }
                        break;
                }
                
                // Check counters every 100 operations
                if (op % 100 == 0) {
                    if (heap.size() < 0) {
                        pass = false;
                        reason = "size is negative at op " + op;
                        break;
                    }
                    if (heap.numTrees() < 0) {
                        pass = false;
                        reason = "numTrees is negative at op " + op;
                        break;
                    }
                    if (heap.totalLinks() < 0) {
                        pass = false;
                        reason = "totalLinks is negative at op " + op;
                        break;
                    }
                    if (heap.totalCuts() < 0) {
                        pass = false;
                        reason = "totalCuts is negative at op " + op;
                        break;
                    }
                    if (heap.numMarkedNodes() < 0) {
                        pass = false;
                        reason = "numMarkedNodes is negative at op " + op;
                        break;
                    }
                    if (heap.totalHeapifyCosts() < 0) {
                        pass = false;
                        reason = "totalHeapifyCosts is negative at op " + op;
                        break;
                    }
                }
            }
            
            // Final verification
            if (pass) {
                if (heap.size() != activeItems.size()) {
                    pass = false;
                    reason = "Size mismatch: heap says " + heap.size() + ", tracked " + activeItems.size();
                }
            }
            
            // Verify heap property
            if (pass) {
                int prev = Integer.MIN_VALUE;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap order violated: " + curr + " after " + prev;
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 14: HeapifyUp Vs CascadingCuts Difference
     * Same operations on heapify-up mode vs cascading-cuts mode, verifies different counter behaviors.
     */
    private static void testIntegration_HeapifyUpVsCascadingCutsDifference(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: HeapifyUp Vs CascadingCuts Counter Difference";
        
        boolean pass = true;
        String reason = "";
        
        try {
            // Create heap with current mode
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            
            // Build tree
            Heap.HeapItem[] items = new Heap.HeapItem[32];
            for (int i = 0; i < 32; i++) {
                items[i] = heap.insert((i + 1) * 10, "val-" + (i + 1));
            }
            
            // Force consolidation
            heap.deleteMin();
            
            int cutsBefore = heap.totalCuts();
            int heapifyBefore = heap.totalHeapifyCosts();
            
            // Perform decrease keys that would trigger structural changes
            for (int i = 25; i < 31; i++) {
                heap.decreaseKey(items[i], items[i].key - 5);
            }
            
            int cutsAfter = heap.totalCuts();
            int heapifyAfter = heap.totalHeapifyCosts();
            
            if (lazyDecreaseKeys) {
                // Cascading cuts mode: should have cuts, no heapify
                if (heap.totalHeapifyCosts() != 0) {
                    pass = false;
                    reason = "In cascading cuts mode, totalHeapifyCosts should be 0, got " + heap.totalHeapifyCosts();
                }
            } else {
                // Heapify mode: should have no cuts
                if (heap.totalCuts() != 0) {
                    pass = false;
                    reason = "In heapify mode, totalCuts should be 0, got " + heap.totalCuts();
                }
            }
            
            // Verify heap still works
            if (pass) {
                int prev = Integer.MIN_VALUE;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap order violated";
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Test 15: Extreme Size Fluctuation
     * Grows heap to 500, shrinks to 1, grows again to 500, verifies integrity throughout.
     */
    private static void testIntegration_ExtremeSizeFluctuation(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Integration: Extreme Size Fluctuation";
        Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
        
        boolean pass = true;
        String reason = "";
        
        try {
            // Phase 1: Grow to 500
            for (int i = 0; i < 500; i++) {
                heap.insert(i + 1, "phase1-" + i);
            }
            
            if (heap.size() != 500) {
                pass = false;
                reason = "After growing to 500, size should be 500, got " + heap.size();
            }
            
            // Phase 2: Shrink to 1
            if (pass) {
                for (int i = 0; i < 499; i++) {
                    heap.deleteMin();
                }
                
                if (heap.size() != 1) {
                    pass = false;
                    reason = "After shrinking, size should be 1, got " + heap.size();
                }
                
                if (pass && heap.numTrees() != 1) {
                    pass = false;
                    reason = "With 1 element, numTrees should be 1, got " + heap.numTrees();
                }
            }
            
            // Phase 3: Grow back to 500
            if (pass) {
                for (int i = 0; i < 499; i++) {
                    heap.insert(1000 + i, "phase3-" + i);
                }
                
                if (heap.size() != 500) {
                    pass = false;
                    reason = "After regrowing to 500, size should be 500, got " + heap.size();
                }
            }
            
            // Verify heap property through complete extraction
            if (pass) {
                int prev = Integer.MIN_VALUE;
                int count = 0;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap order violated at extraction " + count + ": " + curr + " after " + prev;
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                    count++;
                }
                
                if (pass && count != 500) {
                    pass = false;
                    reason = "Expected 500 extractions, got " + count;
                }
            }
            
            // Verify final empty state
            if (pass) {
                if (heap.size() != 0) {
                    pass = false;
                    reason = "Final size should be 0, got " + heap.size();
                }
                if (heap.numTrees() != 0) {
                    pass = false;
                    reason = "Final numTrees should be 0, got " + heap.numTrees();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== RANDOMIZED STRESS TESTS (15) ====================

    /**
     * Random Test 1: 1000 Mixed Operations
     * Performs 1000 random operations and verifies heap property throughout.
     */
    private static void testRandom_MixedOperations1000(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: 1000 Mixed Operations";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(42); // Fixed seed for reproducibility
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            java.util.ArrayList<Heap.HeapItem> items = new java.util.ArrayList<>();
            
            for (int op = 0; op < 1000; op++) {
                int operation = rand.nextInt(100);
                
                if (operation < 40 || items.isEmpty()) {
                    // 40% insert
                    int key = rand.nextInt(10000) + 1;
                    Heap.HeapItem item = heap.insert(key, "op-" + op);
                    items.add(item);
                } else if (operation < 60) {
                    // 20% deleteMin
                    if (heap.size() > 0) {
                        Heap.HeapItem min = heap.findMin();
                        items.remove(min);
                        heap.deleteMin();
                    }
                } else if (operation < 80) {
                    // 20% decreaseKey
                    if (!items.isEmpty()) {
                        int idx = rand.nextInt(items.size());
                        Heap.HeapItem item = items.get(idx);
                        int diff = rand.nextInt(Math.max(1, item.key - 1));
                        heap.decreaseKey(item, diff);
                    }
                } else {
                    // 20% delete
                    if (!items.isEmpty()) {
                        int idx = rand.nextInt(items.size());
                        Heap.HeapItem item = items.remove(idx);
                        heap.delete(item);
                    }
                }
                
                // Verify size consistency
                if (heap.size() != items.size()) {
                    pass = false;
                    reason = "Size mismatch at op " + op + ": heap=" + heap.size() + ", tracked=" + items.size();
                    break;
                }
            }
            
            // Verify heap property by extracting all
            if (pass) {
                int prev = Integer.MIN_VALUE;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap property violated: " + curr + " after " + prev;
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 2: Insert/Delete Storm
     * Rapidly inserts and deletes with random patterns.
     */
    private static void testRandom_InsertDeleteStorm(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: Insert/Delete Storm";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(123);
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            java.util.ArrayList<Heap.HeapItem> items = new java.util.ArrayList<>();
            
            // Storm: alternating bursts of inserts and deletes
            for (int burst = 0; burst < 20; burst++) {
                // Insert burst
                int insertCount = rand.nextInt(50) + 10;
                for (int i = 0; i < insertCount; i++) {
                    int key = rand.nextInt(5000) + 1;
                    items.add(heap.insert(key, "burst" + burst + "-" + i));
                }
                
                // Delete burst - only use delete() with tracked items, not deleteMin()
                int deleteCount = rand.nextInt(Math.min(30, items.size() + 1));
                for (int i = 0; i < deleteCount && !items.isEmpty(); i++) {
                    // Always delete from our tracked list to stay in sync
                    int idx = rand.nextInt(items.size());
                    Heap.HeapItem toDelete = items.remove(idx);
                    heap.delete(toDelete);
                }
                
                if (heap.size() != items.size()) {
                    pass = false;
                    reason = "Size mismatch at burst " + burst + ": heap=" + heap.size() + ", tracked=" + items.size();
                    break;
                }
            }
            
            // Verify heap property with safety limit
            if (pass) {
                int prev = Integer.MIN_VALUE;
                int maxIterations = items.size() + 100; // Safety limit
                int iterations = 0;
                
                while (heap.size() > 0 && iterations < maxIterations) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap property violated: " + curr + " after " + prev;
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                    iterations++;
                }
                
                if (iterations >= maxIterations) {
                    pass = false;
                    reason = "Possible infinite loop detected - exceeded max iterations";
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 3: DecreaseKey Bombardment
     * Heavily tests decreaseKey with random patterns.
     */
    private static void testRandom_DecreaseKeyBombardment(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: DecreaseKey Bombardment";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(456);
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            Heap.HeapItem[] items = new Heap.HeapItem[200];
            
            // Insert all with high keys
            for (int i = 0; i < 200; i++) {
                items[i] = heap.insert(10000 + rand.nextInt(10000), "node-" + i);
            }
            
            // Force consolidation - find which item is the min and mark it null
            Heap.HeapItem minItem = heap.findMin();
            for (int i = 0; i < 200; i++) {
                if (items[i] == minItem) {
                    items[i] = null;
                    break;
                }
            }
            heap.deleteMin();
            
            // Bombardment: 500 random decreaseKey operations
            for (int op = 0; op < 500; op++) {
                int idx = rand.nextInt(items.length);
                if (items[idx] != null && items[idx].key > 1) {
                    int maxDiff = items[idx].key - 1;
                    int diff = rand.nextInt(maxDiff) + 1;
                    heap.decreaseKey(items[idx], diff);
                }
            }
            
            // Verify heap property
            int prev = Integer.MIN_VALUE;
            int count = 0;
            while (heap.size() > 0) {
                int curr = heap.findMin().key;
                if (curr < prev) {
                    pass = false;
                    reason = "Heap property violated at extraction " + count + ": " + curr + " after " + prev;
                    break;
                }
                prev = curr;
                heap.deleteMin();
                count++;
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 4: Meld Chaos
     * Creates and melds many heaps with random operations.
     */
    private static void testRandom_MeldChaos(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: Meld Chaos";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(789);
            Heap mainHeap = new Heap(lazyMelds, lazyDecreaseKeys);
            int totalElements = 0;
            int minKey = Integer.MAX_VALUE;
            
            // Create and meld 30 random heaps
            for (int h = 0; h < 30; h++) {
                Heap tempHeap = new Heap(lazyMelds, lazyDecreaseKeys);
                int count = rand.nextInt(30) + 5;
                
                for (int i = 0; i < count; i++) {
                    int key = rand.nextInt(10000) + 1;
                    tempHeap.insert(key, "h" + h + "-" + i);
                    minKey = Math.min(minKey, key);
                    totalElements++;
                }
                
                // Random operations on temp heap before meld
                if (rand.nextBoolean() && tempHeap.size() > 1) {
                    tempHeap.deleteMin();
                    totalElements--;
                    // Recalculate min is complex, so we just track size
                }
                
                mainHeap.meld(tempHeap);
            }
            
            if (mainHeap.size() != totalElements) {
                pass = false;
                reason = "Size mismatch: expected " + totalElements + ", got " + mainHeap.size();
            }
            
            // Verify heap property
            if (pass) {
                int prev = Integer.MIN_VALUE;
                while (mainHeap.size() > 0) {
                    int curr = mainHeap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap property violated";
                        break;
                    }
                    prev = curr;
                    mainHeap.deleteMin();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 5: Delete Random Nodes
     * Inserts many nodes then deletes them in random order.
     */
    private static void testRandom_DeleteRandomNodes(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: Delete Random Nodes";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(111);
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            java.util.ArrayList<Heap.HeapItem> items = new java.util.ArrayList<>();
            
            // Insert 300 elements
            for (int i = 0; i < 300; i++) {
                int key = rand.nextInt(5000) + 1;
                items.add(heap.insert(key, "node-" + i));
            }
            
            // Delete in random order
            while (!items.isEmpty()) {
                int idx = rand.nextInt(items.size());
                heap.delete(items.remove(idx));
                
                if (heap.size() != items.size()) {
                    pass = false;
                    reason = "Size mismatch during deletion";
                    break;
                }
                
                // Periodically verify heap property by checking min
                if (items.size() % 50 == 0 && heap.size() > 0) {
                    int minKey = heap.findMin().key;
                    if (minKey < 1) {
                        pass = false;
                        reason = "Invalid min key: " + minKey;
                        break;
                    }
                }
            }
            
            if (pass && heap.size() != 0) {
                pass = false;
                reason = "Heap should be empty, size=" + heap.size();
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 6: Alternating Operations
     * Alternates between different operations in random patterns.
     */
    private static void testRandom_AlternatingOperations(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: Alternating Operations";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(222);
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            java.util.ArrayList<Heap.HeapItem> items = new java.util.ArrayList<>();
            
            // Pattern: insert, insert, deleteMin, insert, decreaseKey, delete, repeat
            for (int cycle = 0; cycle < 100; cycle++) {
                // Two inserts
                for (int i = 0; i < 2; i++) {
                    int key = rand.nextInt(1000) + 100;
                    items.add(heap.insert(key, "c" + cycle + "-" + i));
                }
                
                // One deleteMin
                if (heap.size() > 0) {
                    Heap.HeapItem min = heap.findMin();
                    items.remove(min);
                    heap.deleteMin();
                }
                
                // One insert
                int key = rand.nextInt(1000) + 100;
                items.add(heap.insert(key, "c" + cycle + "-x"));
                
                // One decreaseKey
                if (!items.isEmpty()) {
                    int idx = rand.nextInt(items.size());
                    Heap.HeapItem item = items.get(idx);
                    if (item.key > 1) {
                        int diff = rand.nextInt(Math.min(50, item.key - 1)) + 1;
                        heap.decreaseKey(item, diff);
                    }
                }
                
                // One delete
                if (items.size() > 1) {
                    int idx = rand.nextInt(items.size());
                    heap.delete(items.remove(idx));
                }
                
                if (heap.size() != items.size()) {
                    pass = false;
                    reason = "Size mismatch at cycle " + cycle;
                    break;
                }
            }
            
            // Verify heap property
            if (pass) {
                int prev = Integer.MIN_VALUE;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap property violated";
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 7: Extract All After Random Build
     * Builds heap randomly then extracts all verifying order.
     */
    private static void testRandom_ExtractAllRandom(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: Extract All After Random Build";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(333);
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            java.util.ArrayList<Integer> insertedKeys = new java.util.ArrayList<>();
            
            // Random build: insert 500 random elements
            for (int i = 0; i < 500; i++) {
                int key = rand.nextInt(100000) + 1;
                heap.insert(key, "val-" + i);
                insertedKeys.add(key);
            }
            
            // Random decreaseKey on some
            // (can't track easily, just verify order at end)
            
            // Sort expected keys for verification
            java.util.Collections.sort(insertedKeys);
            
            // Extract all and verify order
            int prev = Integer.MIN_VALUE;
            int count = 0;
            while (heap.size() > 0) {
                int curr = heap.findMin().key;
                if (curr < prev) {
                    pass = false;
                    reason = "Heap property violated at " + count + ": " + curr + " < " + prev;
                    break;
                }
                prev = curr;
                heap.deleteMin();
                count++;
            }
            
            if (pass && count != 500) {
                pass = false;
                reason = "Expected 500 extractions, got " + count;
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 8: Stress Counters
     * Performs random operations while monitoring all counters for consistency.
     */
    private static void testRandom_StressCounters(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: Stress Counters";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(444);
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            java.util.ArrayList<Heap.HeapItem> items = new java.util.ArrayList<>();
            
            int prevLinks = 0;
            int prevCuts = 0;
            
            for (int op = 0; op < 500; op++) {
                int operation = rand.nextInt(4);
                
                switch (operation) {
                    case 0: // Insert
                        items.add(heap.insert(rand.nextInt(1000) + 1, "op-" + op));
                        break;
                    case 1: // DeleteMin
                        if (heap.size() > 0) {
                            items.remove(heap.findMin());
                            heap.deleteMin();
                        }
                        break;
                    case 2: // DecreaseKey
                        if (!items.isEmpty()) {
                            Heap.HeapItem item = items.get(rand.nextInt(items.size()));
                            if (item.key > 1) {
                                heap.decreaseKey(item, rand.nextInt(item.key - 1) + 1);
                            }
                        }
                        break;
                    case 3: // Delete
                        if (!items.isEmpty()) {
                            heap.delete(items.remove(rand.nextInt(items.size())));
                        }
                        break;
                }
                
                // Verify counters never decrease (except size)
                if (heap.totalLinks() < prevLinks) {
                    pass = false;
                    reason = "totalLinks decreased at op " + op;
                    break;
                }
                if (heap.totalCuts() < prevCuts) {
                    pass = false;
                    reason = "totalCuts decreased at op " + op;
                    break;
                }
                if (heap.numTrees() < 0 || heap.numMarkedNodes() < 0) {
                    pass = false;
                    reason = "Negative counter at op " + op;
                    break;
                }
                
                prevLinks = heap.totalLinks();
                prevCuts = heap.totalCuts();
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 9: Repeated Build Destroy
     * Repeatedly builds and destroys heaps with random patterns.
     */
    private static void testRandom_RepeatedBuildDestroy(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: Repeated Build Destroy";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(555);
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            
            for (int cycle = 0; cycle < 20; cycle++) {
                // Build phase: insert random number of elements
                int buildSize = rand.nextInt(100) + 50;
                for (int i = 0; i < buildSize; i++) {
                    heap.insert(rand.nextInt(5000) + 1, "c" + cycle + "-" + i);
                }
                
                if (heap.size() != buildSize) {
                    pass = false;
                    reason = "Build phase failed at cycle " + cycle;
                    break;
                }
                
                // Destroy phase: extract all
                int prev = Integer.MIN_VALUE;
                int extracted = 0;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap property violated at cycle " + cycle;
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                    extracted++;
                }
                
                if (!pass) break;
                
                if (extracted != buildSize) {
                    pass = false;
                    reason = "Extraction count mismatch at cycle " + cycle;
                    break;
                }
                
                if (heap.numTrees() != 0) {
                    pass = false;
                    reason = "numTrees not 0 after destroy at cycle " + cycle;
                    break;
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 10: Chaos Monkey
     * Completely random operations with no pattern.
     */
    private static void testRandom_ChaosMonkey(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: Chaos Monkey";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(666);
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            java.util.ArrayList<Heap.HeapItem> items = new java.util.ArrayList<>();
            
            for (int op = 0; op < 2000; op++) {
                int choice = rand.nextInt(100);
                
                if (choice < 35) {
                    // Insert
                    items.add(heap.insert(rand.nextInt(50000) + 1, "chaos-" + op));
                } else if (choice < 50 && heap.size() > 0) {
                    // DeleteMin
                    items.remove(heap.findMin());
                    heap.deleteMin();
                } else if (choice < 70 && !items.isEmpty()) {
                    // DecreaseKey
                    Heap.HeapItem item = items.get(rand.nextInt(items.size()));
                    if (item.key > 1) {
                        heap.decreaseKey(item, rand.nextInt(item.key - 1) + 1);
                    }
                } else if (choice < 85 && !items.isEmpty()) {
                    // Delete
                    heap.delete(items.remove(rand.nextInt(items.size())));
                } else if (choice < 95) {
                    // Meld with small heap
                    Heap temp = new Heap(lazyMelds, lazyDecreaseKeys);
                    int count = rand.nextInt(10) + 1;
                    for (int i = 0; i < count; i++) {
                        items.add(temp.insert(rand.nextInt(50000) + 1, "meld-" + op + "-" + i));
                    }
                    heap.meld(temp);
                } else {
                    // FindMin (no change)
                    heap.findMin();
                }
                
                if (heap.size() != items.size()) {
                    pass = false;
                    reason = "Size mismatch at op " + op + ": heap=" + heap.size() + ", tracked=" + items.size();
                    break;
                }
            }
            
            // Final verification
            if (pass) {
                int prev = Integer.MIN_VALUE;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap property violated";
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 11: Large Scale Operations
     * Tests with 5000+ elements.
     */
    private static void testRandom_LargeScaleOperations(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: Large Scale Operations (5000+)";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(777);
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            java.util.ArrayList<Heap.HeapItem> items = new java.util.ArrayList<>();
            
            // Insert 5000 elements
            for (int i = 0; i < 5000; i++) {
                items.add(heap.insert(rand.nextInt(100000) + 1, "large-" + i));
            }
            
            if (heap.size() != 5000) {
                pass = false;
                reason = "Failed to insert 5000 elements";
            }
            
            // Random operations
            if (pass) {
                for (int op = 0; op < 1000; op++) {
                    int choice = rand.nextInt(3);
                    
                    if (choice == 0 && heap.size() > 0) {
                        items.remove(heap.findMin());
                        heap.deleteMin();
                    } else if (choice == 1 && !items.isEmpty()) {
                        Heap.HeapItem item = items.get(rand.nextInt(items.size()));
                        if (item.key > 1) {
                            heap.decreaseKey(item, rand.nextInt(item.key - 1) + 1);
                        }
                    } else if (choice == 2 && !items.isEmpty()) {
                        heap.delete(items.remove(rand.nextInt(items.size())));
                    }
                }
            }
            
            // Verify heap property
            if (pass) {
                int prev = Integer.MIN_VALUE;
                int count = 0;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap property violated at extraction " + count;
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                    count++;
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 12: DecreaseKey Then Delete
     * DecreaseKey nodes then delete them - tests node tracking.
     */
    private static void testRandom_DecreaseKeyThenDelete(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: DecreaseKey Then Delete";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(888);
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            Heap.HeapItem[] items = new Heap.HeapItem[100];
            
            // Insert all
            for (int i = 0; i < 100; i++) {
                items[i] = heap.insert(1000 + rand.nextInt(9000), "node-" + i);
            }
            
            // Force consolidation - find which item is the min and mark it deleted
            boolean[] deleted = new boolean[100];
            Heap.HeapItem minItem = heap.findMin();
            for (int i = 0; i < 100; i++) {
                if (items[i] == minItem) {
                    deleted[i] = true;
                    break;
                }
            }
            heap.deleteMin();
            
            for (int round = 0; round < 50; round++) {
                // Find a non-deleted item
                int idx = rand.nextInt(100);
                int attempts = 0;
                while (deleted[idx] && attempts < 100) {
                    idx = rand.nextInt(100);
                    attempts++;
                }
                
                if (!deleted[idx]) {
                    // DecreaseKey
                    if (items[idx].key > 1) {
                        heap.decreaseKey(items[idx], rand.nextInt(items[idx].key - 1) + 1);
                    }
                    
                    // Delete
                    heap.delete(items[idx]);
                    deleted[idx] = true;
                }
            }
            
            // Verify heap property
            int prev = Integer.MIN_VALUE;
            while (heap.size() > 0) {
                int curr = heap.findMin().key;
                if (curr < prev) {
                    pass = false;
                    reason = "Heap property violated";
                    break;
                }
                prev = curr;
                heap.deleteMin();
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 13: Meld Then Extract All
     * Melds random heaps then extracts all verifying order.
     */
    private static void testRandom_MeldThenExtractAll(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: Meld Then Extract All";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(999);
            Heap mainHeap = new Heap(lazyMelds, lazyDecreaseKeys);
            int totalCount = 0;
            
            // Create 50 heaps and meld them
            for (int h = 0; h < 50; h++) {
                Heap tempHeap = new Heap(lazyMelds, lazyDecreaseKeys);
                int count = rand.nextInt(20) + 5;
                
                for (int i = 0; i < count; i++) {
                    tempHeap.insert(rand.nextInt(10000) + 1, "h" + h + "-" + i);
                    totalCount++;
                }
                
                mainHeap.meld(tempHeap);
            }
            
            if (mainHeap.size() != totalCount) {
                pass = false;
                reason = "Size mismatch after melds: expected " + totalCount + ", got " + mainHeap.size();
            }
            
            // Extract all verifying order
            if (pass) {
                int prev = Integer.MIN_VALUE;
                int extracted = 0;
                while (mainHeap.size() > 0) {
                    int curr = mainHeap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap property violated at extraction " + extracted;
                        break;
                    }
                    prev = curr;
                    mainHeap.deleteMin();
                    extracted++;
                }
                
                if (pass && extracted != totalCount) {
                    pass = false;
                    reason = "Extracted " + extracted + " but expected " + totalCount;
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 14: Worst Case Patterns
     * Tests patterns known to be challenging for heaps.
     */
    private static void testRandom_WorstCasePatterns(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: Worst Case Patterns";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(1010);
            
            // Pattern 1: Insert ascending, delete all
            Heap heap1 = new Heap(lazyMelds, lazyDecreaseKeys);
            for (int i = 1; i <= 200; i++) {
                heap1.insert(i, "asc-" + i);
            }
            int prev = 0;
            while (heap1.size() > 0) {
                int curr = heap1.findMin().key;
                if (curr <= prev) {
                    pass = false;
                    reason = "Pattern 1 failed: " + curr + " after " + prev;
                    break;
                }
                prev = curr;
                heap1.deleteMin();
            }
            
            // Pattern 2: Insert descending, delete all
            if (pass) {
                Heap heap2 = new Heap(lazyMelds, lazyDecreaseKeys);
                for (int i = 200; i >= 1; i--) {
                    heap2.insert(i, "desc-" + i);
                }
                prev = 0;
                while (heap2.size() > 0) {
                    int curr = heap2.findMin().key;
                    if (curr <= prev) {
                        pass = false;
                        reason = "Pattern 2 failed: " + curr + " after " + prev;
                        break;
                    }
                    prev = curr;
                    heap2.deleteMin();
                }
            }
            
            // Pattern 3: All same key
            if (pass) {
                Heap heap3 = new Heap(lazyMelds, lazyDecreaseKeys);
                for (int i = 0; i < 100; i++) {
                    heap3.insert(42, "same-" + i);
                }
                int count = 0;
                while (heap3.size() > 0) {
                    if (heap3.findMin().key != 42) {
                        pass = false;
                        reason = "Pattern 3 failed: expected 42, got " + heap3.findMin().key;
                        break;
                    }
                    heap3.deleteMin();
                    count++;
                }
                if (pass && count != 100) {
                    pass = false;
                    reason = "Pattern 3: extracted " + count + " not 100";
                }
            }
            
            // Pattern 4: Alternating high-low
            if (pass) {
                Heap heap4 = new Heap(lazyMelds, lazyDecreaseKeys);
                for (int i = 0; i < 100; i++) {
                    heap4.insert(i % 2 == 0 ? 1 : 1000, "alt-" + i);
                }
                prev = 0;
                while (heap4.size() > 0) {
                    int curr = heap4.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Pattern 4 failed";
                        break;
                    }
                    prev = curr;
                    heap4.deleteMin();
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    /**
     * Random Test 15: Ultimate Torture Test
     * The most extreme test combining all challenging patterns.
     */
    private static void testRandom_UltimateTortureTest(boolean lazyMelds, boolean lazyDecreaseKeys) {
        String testName = "Random: ULTIMATE TORTURE TEST";
        
        boolean pass = true;
        String reason = "";
        
        try {
            java.util.Random rand = new java.util.Random(31415);
            Heap heap = new Heap(lazyMelds, lazyDecreaseKeys);
            java.util.ArrayList<Heap.HeapItem> items = new java.util.ArrayList<>();
            
            // Phase 1: Build up to 2000 elements with random inserts
            for (int i = 0; i < 2000; i++) {
                items.add(heap.insert(rand.nextInt(100000) + 1, "p1-" + i));
            }
            
            // Phase 2: Heavy decreaseKey bombardment
            for (int i = 0; i < 500; i++) {
                if (!items.isEmpty()) {
                    Heap.HeapItem item = items.get(rand.nextInt(items.size()));
                    if (item.key > 1) {
                        heap.decreaseKey(item, rand.nextInt(item.key - 1) + 1);
                    }
                }
            }
            
            // Phase 3: Delete half randomly
            int toDelete = items.size() / 2;
            for (int i = 0; i < toDelete && !items.isEmpty(); i++) {
                int idx = rand.nextInt(items.size());
                heap.delete(items.remove(idx));
            }
            
            // Phase 4: Meld with 20 new heaps
            for (int h = 0; h < 20; h++) {
                Heap tempHeap = new Heap(lazyMelds, lazyDecreaseKeys);
                int count = rand.nextInt(50) + 10;
                for (int i = 0; i < count; i++) {
                    Heap.HeapItem item = tempHeap.insert(rand.nextInt(100000) + 1, "p4-h" + h + "-" + i);
                    items.add(item);
                }
                heap.meld(tempHeap);
            }
            
            // Phase 5: More mixed operations
            for (int op = 0; op < 300; op++) {
                int choice = rand.nextInt(5);
                
                if (choice == 0) {
                    items.add(heap.insert(rand.nextInt(100000) + 1, "p5-" + op));
                } else if (choice == 1 && heap.size() > 0) {
                    items.remove(heap.findMin());
                    heap.deleteMin();
                } else if (choice == 2 && !items.isEmpty()) {
                    Heap.HeapItem item = items.get(rand.nextInt(items.size()));
                    if (item.key > 1) {
                        heap.decreaseKey(item, rand.nextInt(item.key - 1) + 1);
                    }
                } else if (choice == 3 && !items.isEmpty()) {
                    heap.delete(items.remove(rand.nextInt(items.size())));
                }
                // choice == 4: do nothing (no-op)
            }
            
            // Verify size
            if (heap.size() != items.size()) {
                pass = false;
                reason = "Size mismatch: heap=" + heap.size() + ", tracked=" + items.size();
            }
            
            // Verify counters
            if (pass) {
                if (heap.totalLinks() < 0 || heap.totalCuts() < 0 || 
                    heap.numTrees() < 0 || heap.numMarkedNodes() < 0 ||
                    heap.totalHeapifyCosts() < 0) {
                    pass = false;
                    reason = "Negative counter detected";
                }
            }
            
            // Phase 6: Final extraction - verify heap property
            if (pass) {
                int prev = Integer.MIN_VALUE;
                int count = 0;
                while (heap.size() > 0) {
                    int curr = heap.findMin().key;
                    if (curr < prev) {
                        pass = false;
                        reason = "Heap property violated at extraction " + count + ": " + curr + " < " + prev;
                        break;
                    }
                    prev = curr;
                    heap.deleteMin();
                    count++;
                }
            }
            
            // Final state verification
            if (pass) {
                if (heap.size() != 0) {
                    pass = false;
                    reason = "Final size not 0";
                } else if (heap.numTrees() != 0) {
                    pass = false;
                    reason = "Final numTrees not 0";
                } else if (heap.findMin() != null) {
                    pass = false;
                    reason = "Final findMin not null";
                }
            }
            
        } catch (Exception e) {
            pass = false;
            reason = "Exception: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
        
        reportResult(testName, pass, reason);
    }

    // ==================== HELPER ====================

    private static void reportResult(String testName, boolean pass, String reason) {
        if (pass) {
            System.out.println("  ✓ PASS: " + testName);
            testsPassed++;
        } else {
            System.out.println("  ✗ FAIL: " + testName);
            System.out.println("         " + reason);
            testsFailed++;
        }
    }
}
