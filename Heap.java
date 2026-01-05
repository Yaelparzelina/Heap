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
    public HeapItem min;
    public int size;
    public int numTrees;
    public int numMarkedNodes;
    public int totalLinks;
    public int totalCuts;
    public int totalHeapifyCosts;
    
    /**
     *
     * Constructor to initialize an empty heap.
     * complexity O(1)
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
     * pre: not in root list. 
     *  concatenate the node to the root list.
     * complexity O(1)
     *
     */
   public void concatenateToRootList(HeapItem newNode)
   {
    if (newNode == null) return;
    if (this.min == null)
    {
        this.min = newNode;
        return;
    }
    HeapNode first = this.min.node;
    HeapNode last = this.min.node.prev;
    HeapNode newStart = newNode.node;
    HeapNode newEnd = newNode.node.prev;
    last.next = newStart;
    newStart.prev = last;
    newEnd.next = first;
    first.prev = newEnd;
   }
    /**
     * 
     * 
     * link trees with the same rank to reconstruct the heap.
     * for lazy decrease keys complexity O(n)
     * for non-lazy decrease keys complexity O(log n)
     * 
     */
    private void successiveLink()
    {
        //create an array to store the trees by rank
        int ArraySize = (size==0) ? 1 : (int) (1.5* Math.ceil(Math.log(this.size)/Math.log(2))+2);
        HeapNode[] bucket =  new HeapNode[ArraySize];
        HeapNode x = this.min.node;
        if (x == null) return;
        //break the circular linked list into a linear linked list
        x.prev.next=null;
        //link the trees by rank
        while (x != null)
        {
            HeapNode y = x;
            x=x.next;
            while (bucket[y.rank] != null)
            {
                HeapNode other = bucket[y.rank];
                bucket[y.rank] = null;
                y = link(y, other);
            }
            bucket[y.rank] = y;
        }
        //reconstruct the circular linked list
        this.min = null;
        this.numTrees = 0;
        HeapNode first = null;
        HeapNode last = null;
        for (int i = 0; i < bucket.length; i++)
        {   
            if (bucket[i] != null)
            {
                HeapNode node = bucket[i];
                this.numTrees++;
                if (first == null)
                {
                    first = node;
                    last = node;
                    node.next = node;
                    node.prev = node;
                    this.min = node.item;
                }
                else
                {
                    //add the node to the end of the circular linked list
                    last.next = node;
                     node.prev = last;
                    node.next = first;
                    first.prev = node;
                    last = node;
                    //update the min node
                    if (node.item.key < this.min.key)
                    {
                        this.min = node.item;
                    }
                }
            }
        }
    }

    /**
     * 
     * Link two trees of the same rank x and y.
     * where the root will be the smaller of the two nodes.
     * complexity O(1)
     */
    private HeapNode link(HeapNode x, HeapNode y)
    {
        HeapNode smaller;
        HeapNode larger;
        if (x.item.key < y.item.key)
        {
            smaller = x;
            larger = y;
        }
        else
        {
            smaller = y;
            larger = x;
        }
        //link the larger node to the smaller node
        if (smaller.child == null)
        {
            smaller.child = larger;
            larger.next = larger;
            larger.prev = larger;
        }
        else
        {
            larger.next = smaller.child;
            larger.prev = smaller.child.prev;
            smaller.child.prev.next = larger;
            smaller.child.prev = larger;
            smaller.child = larger;
        }
        larger.parent = smaller;
        smaller.rank++;
        this.totalLinks++;
        return smaller;
    } 
    
     /**
     * 
     * pre: key > 0
     *
     * Insert (key,info) into the heap and return the newly generated HeapNode.
     * for lazy meld complexity O(1)
     * for non-lazy meld and lazy decrease keys complexity O(n)
     * for non-lazy meld and non-lazy decrease keys complexity O(log n)
     */
     public HeapItem insert(int key, String info) 
     { 
         // create a new heap with the same lazy melds and lazy decrease keys and insert the new node into it   
         HeapNode newNode = new HeapNode(key, info);
         Heap newHeap = new Heap(this.lazyMelds, this.lazyDecreaseKeys);
         newHeap.min = newNode.item;
         newHeap.size = 1;
         newHeap.numTrees = 1;
         meld(newHeap);
         return newNode.item;
     }
     
    
     /**
      * 
      * return the min node
      * complexity O(1)
      *
      */

     public HeapItem findMin()
     {
         return this.min;
     }

    /**
     * 
     * Delete the minimal item.
     * for lazy decrease keys complexity O(n)
     * for non-lazy decrease keys complexity O(log n)
     *
     */
    public void deleteMin()
    {
        //handle the case where the heap is empty
        if (this.min == null)
        {
            return;
        }

        //update the size
        this.size--;
        
        //handle the case where the heap has only one node
        if (this.min.node.next == this.min.node && this.min.node.child == null)
        {
            this.min = null;
            this.numTrees = 0;
            this.numMarkedNodes = 0;
            return;
        }

        //handle the case where the min node has children
        else if (this.min.node.child != null)
        {
           HeapNode child = this.min.node.child;
           HeapNode current = child;
           //set the new roots to have no parent and not be marked
           do
           {
                current.parent = null;
                if (current.marked)
                {
                    current.marked = false;
                    this.numMarkedNodes--;
                }
                current = current.next;
           } while (current != child);
           concatenateToRootList(child.item);
          
        }

        //remove the min node from the root list
        HeapNode preMin = this.min.node.prev;
        preMin.next = this.min.node.next;
        this.min.node.next.prev = preMin;
        this.min = preMin.item;  //set a temporary min node to the previous min node to have a reference to the root list
        successiveLink(); //successive link is updated the min node and the number of trees
    }
    
    /**
     * 
     * cascading cuts to fix the heap by cutting the node and its parent if the node is marked.
     * complexity O(n)
     *
     */
    public void cascadingCuts(HeapNode node)
    {
        if (node.parent == null) return;
        this.totalCuts++;
        HeapNode parent = node.parent;
       //handle the case where the node has a parent and the parent has a rank greater than 1
        if (node.parent.rank>1)
        {
            HeapNode preNode = node.prev;
            HeapNode postNode = node.next;
            preNode.next = postNode;
            postNode.prev = preNode;
            if (parent.child == node)
            {
                parent.child = postNode;
            }
        } 
        //handle the case where the node has a parent and the parent has a rank equal to 1
        else
        {
            parent.child = null;
        }

        //update the rank of the parent and the node
        parent.rank--;
        if (node.marked)
        {
            node.marked = false;
            this.numMarkedNodes--;
        }
        node.parent = null;
        this.numTrees++;
        node.prev = node;
        node.next = node;
        concatenateToRootList(node.item); //concatenate the node to the root list
        
        if (parent.marked) cascadingCuts(parent);
        else if (parent.parent != null) {
            parent.marked = true;
            this.numMarkedNodes++;
        }
    }
    
    /**
     * 
     * Heapify up the node to fix the heap.
     * complexity O(log n)
     *
     */
    public void heapifyUp(HeapNode node)
    {
        while (node.parent != null && node.item.key < node.parent.item.key)
        {
            this.totalHeapifyCosts++;
            HeapNode parent = node.parent;
            //swap the items
            HeapItem tempItem = parent.item;
            parent.item = node.item;
            node.item = tempItem;
            // update the nodes within the items
            parent.item.node = parent;
            node.item.node = node;
            node = parent;
            
        }
    }
    
    /**
     * 
     * pre: 0<=diff<=x.key
     * complexity O(n) for lazy decrease keys
     * complexity O(log n) for non-lazy decrease keys
     * Decrease the key of x by diff and fix the heap.
     * 
     *
     */
    public void decreaseKey(HeapItem x, int diff) 
    {    
        if (x == null || diff < 0 || x.node == null) return;
        x.key -= diff;
        if (x.node.parent != null && x.key < x.node.parent.item.key)
        {
            if (this.lazyDecreaseKeys) cascadingCuts(x.node);
            else heapifyUp(x.node);
        }
        if (this.min.key > x.key) this.min = x;
    
    }

    /**
     * 
     * Delete the x from the heap.
     * complexity O(n) for lazy decrease keys
     * complexity O(log n) for non-lazy decrease keys
     *
     */
    public void delete(HeapItem x) 
    {    
        this.decreaseKey(x,x.key+1);
        this.deleteMin();
    }


    /**
     * 
     * Meld the heap with heap2
     * pre: heap2.lazyMelds = this.lazyMelds AND heap2.lazyDecreaseKeys = this.lazyDecreaseKeys
     * complexity O(1) for lazy melds
     * complexity O(n) for non-lazy melds and lazy decrease keys
     * complexity O(log n) for non-lazy melds and non-lazy decrease keys
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
        concatenateToRootList(heap2.min);
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
     * complexity O(1)
     *   
     */
    public int size()
    {
        return this.size;
    }


    /**
     * 
     * Return the number of trees in the heap.
     * complexity O(1)
     *
     */
    public int numTrees()
    {
        return this.numTrees;
    }
    
    
    /**
     * 
     * Return the number of marked nodes in the heap.
     * complexity O(1)
     *
     */
    public int numMarkedNodes()
    {
        return this.numMarkedNodes;
    }
    
    
    /**
     * 
     * Return the total number of links.
     * complexity O(1)
     */
    public int totalLinks()
    {
        return this.totalLinks;
    }
    
    
    /**
     * 
     * Return the total number of cuts.
     * complexity O(1)
     *
     */
    public int totalCuts()
    {
        return this.totalCuts;
    }
    

    /**
     * 
     * Return the total heapify costs.
     * complexity O(1)
     *
     */
    public int totalHeapifyCosts()
    {
        return this.totalHeapifyCosts;
    }
    
    
    /**
     * Class implementing a node in a ExtendedFibonacci Heap.
     *  
     */
    public static class HeapNode
    {
        public HeapItem item;
        public HeapNode child;
        public HeapNode next;
        public HeapNode prev;
        public HeapNode parent;
        public int rank;
        public boolean marked; //whether the node's child has been cut 
        
        public HeapNode(int key, String info)
        {
            this.item = new HeapItem(this,key, info); //create a new heap item with the node and the key and info
            this.child = null;
            this.next = this;
            this.prev = this;
            this.parent = null;
            this.rank = 0;
            this.marked = false;
        }
    }
    /**
     * Class implementing an item in a Heap.
     *  
     */
    public static class HeapItem{
        public HeapNode node;
        public int key;
        public String info;
        public HeapItem(HeapNode node,int key, String info)
        {
            this.node = node;
            this.key = key;
            this.info = info;
        }
    }   
}