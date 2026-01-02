/**
 * Heap
 *
 * An implementation of Fibonacci heap over positive integers 
 * with the possibility of not performing lazy melds and 
 * the possibility of not performing lazy decrease keys.
 *
 */
public class Heap
{
    public final boolean lazyMelds;
    public final boolean lazyDecreaseKeys;
    public HeapNode min;
    public HeapNode startRoot;
    public int size;
    public int numTrees;
    public int numMarkedNodes;
    public int totalLinks;
    public int totalCuts;
    public int totalHeapifyCosts;
    
    /**
     *
     * Constructor to initialize an empty heap.
     *
     */
    public Heap(boolean lazyMelds, boolean lazyDecreaseKeys)
    {
        this.lazyMelds = lazyMelds;
        this.lazyDecreaseKeys = lazyDecreaseKeys;
        this.min = null;
        this.size = 0;
        this.numTrees = 0;
        this.numMarkedNodes = 0;
        this.totalLinks = 0;
        this.totalCuts = 0;
        this.totalHeapifyCosts = 0;
    }

    /**
     * 
     * pre: key > 0
     *
     * Insert (key,info) into the heap and return the newly generated HeapNode.
     * for lazy meld complexity O(1)
     * for non-lazy meld complexity O(log n)
     */
    public HeapNode insert(int key, String info) 
    { 
        // create a new heap with the same lazy melds and lazy decrease keys and insert the new node into it   
        HeapNode newNode = new HeapNode(key, info);
        Heap newHeap = new Heap(this.lazyMelds, this.lazyDecreaseKeys);
        newHeap.min = newNode;
        newHeap.size = 1;
        newHeap.numTrees = 1;
        meld(newHeap);
        return newNode;
    }

    private void successiveLink()
    {
        HeapNode[] degreeArray = new HeapNode[(int)Math.ceil(Math.log(this.size)/Math.log(2))];
        degreeArray[this.min.rank] = this.min;
        HeapNode current = this.min.next;
        while(current != this.min)
        {
            if (degreeArray[current.rank] == null)
            {
                degreeArray[current.rank] = current;
            }
            else
            {
                HeapNode linkTree = this.link(current, degreeArray[current.rank]);
                degreeArray[linkTree.rank] = linkTree;
                degreeArray[current.rank] = null;
            }
            current = current.next;
        }
    }
    /**
     * 
     * Link two trees of the same rank x and y.
     * where the root will be the smaller of the two nodes.
     *
     */
    private HeapNode link(HeapNode x, HeapNode y)
    {
        HeapNode smaller;
        HeapNode larger;
        if (x.key < y.key)
        {
            smaller = x;
            larger = y;
        }
        else
        {
            smaller = y;
            larger = x;
        }
        larger.parent = smaller;
        larger.next = smaller.child;
        larger.prev = smaller.child.prev;
        smaller.child.prev.next = larger;
        smaller.child.prev = larger;
        smaller.child = larger;
        smaller.rank++;
        return smaller;
    }

    /**
     * 
     * Delete the minimal item.
     *
     */
    public void deleteMin()
    {

        return; // should be replaced by student code
    }

    /**
     * 
     * pre: 0<=diff<=x.key
     * 
     * Decrease the key of x by diff and fix the heap.
     * 
     */
    public void decreaseKey(HeapNode x, int diff) 
    {    
        return; // should be replaced by student code
    }

    /**
     * 
     * Delete the x from the heap.
     *
     */
    public void delete(HeapNode x) 
    {    
        return; // should be replaced by student code
    }


    /**
     * 
     * Meld the heap with heap2
     * pre: heap2.lazyMelds = this.lazyMelds AND heap2.lazyDecreaseKeys = this.lazyDecreaseKeys
     *
     */
    public void meld(Heap heap2)   
    {
        //update the total stats
        this.totalCuts += heap2.totalCuts;
        this.totalLinks += heap2.totalLinks;
        this.totalHeapifyCosts += heap2.totalHeapifyCosts;
        this.numMarkedNodes += heap2.numMarkedNodes;
        this.numTrees += heap2.numTrees;
        this.size += heap2.size;
        //handle the case where one of the heaps is empty
        if (heap2.min == null)
        {
            return;
        }
        if (this.min == null)
        {
            this.min = heap2.min;
            return;
        }
        //concatenate the root lists
        HeapNode originalEnd = this.min.prev;
        heap2.min.prev.next = this.min;
        this.min.prev = heap2.min.prev;
        originalEnd.next = heap2.min;
        heap2.min.prev = originalEnd;
        //update the min node
        if (this.min == null || heap2.min.key < this.min.key)
        {
            this.min = heap2.min;
        }
        //if lazy melds is not enabled, perform successive link
        if (!this.lazyMelds)
        {
            successiveLink();
        }  
    }
    
    
    /**
     * 
     * Return the number of elements in the heap
     *   
     */
    public int size()
    {
        return 46; // should be replaced by student code
    }


    /**
     * 
     * Return the number of trees in the heap.
     * 
     */
    public int numTrees()
    {
        return 46; // should be replaced by student code
    }
    
    
    /**
     * 
     * Return the number of marked nodes in the heap.
     * 
     */
    public int numMarkedNodes()
    {
        return 46; // should be replaced by student code
    }
    
    
    /**
     * 
     * Return the total number of links.
     * 
     */
    public int totalLinks()
    {
        return 46; // should be replaced by student code
    }
    
    
    /**
     * 
     * Return the total number of cuts.
     * 
     */
    public int totalCuts()
    {
        return 46; // should be replaced by student code
    }
    

    /**
     * 
     * Return the total heapify costs.
     * 
     */
    public int totalHeapifyCosts()
    {
        return 46; // should be replaced by student code
    }
    
    
    /**
     * Class implementing a node in a ExtendedFibonacci Heap.
     *  
     */
    public static class HeapNode
    {
        public int key;
        public String info;
        public HeapNode child;
        public HeapNode next;
        public HeapNode prev;
        public HeapNode parent;
        public int rank;
        public boolean marked; //whether the node's child has been cut 
        public boolean deleted; //whether the node's been deleted
        
        public HeapNode(int key, String info)
        {
            this.key = key;
            this.info = info;
            this.child = null;
            this.next = this;
            this.prev = this;
            this.parent = null;
            this.rank = 0;
            this.marked = false;
            this.deleted = false;
        }
    }   
}