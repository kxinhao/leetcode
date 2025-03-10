/**
 * LeetCode 295 Find Median from Data Stream (Hard)
 * use 2 heaps(pq in java), min/max to store larger/smaller halves of data
 * if thread-safe requirement, use PriorityBlockingQueue instead of PriorityQueue for heap impl
 * addNum() TC: O(LogN) SC: O(N)
 * findMedian() TC: O(1) SC: O(N)
 *
 * ## Special Note: Interviewer may demand use of BST / Self-balancing BST (AVL/Red-Black),
 *                  added soln using Red-Black Tree Java Impl(TreeMap) and Doubly Linked-List
 *                  TreeMap operations TC: O(LogN)
 * ### Special Note2: Thread-safety can be attained via Synchronization by init TreeMap using
 *                    SortedMap m = Collections.synchronizedSortedMap(new TreeMap());
 * ### Soln using TreeMap has addNum() TC: O(LogN) and findMedian() TC: O(1), SC: O(N)
 *
 * Followups:
 * 1. If all integer numbers from the stream are between 0 and 100, how would you optimize it?

      We can maintain an integer array of length 100 to store the count of each number along
      with a total count. Then, we can iterate over the array to find the middle value to get
      our median. Time and space complexity would be O(100) = O(1).

   2. If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?

      In this case, we need an integer array of length 100 and a hashmap for these numbers that
      are not in [0,100].
 */

// 6th impl
// 2x Heap soln (Best runtime 85 ms, additional addNum() conditions to shave 50ms off runtime)
class MedianFinder {

    private PriorityQueue<Integer> min; // stores larger half with min val as head (eg. 4,5,6)
    private PriorityQueue<Integer> max; // stores smaller half with max val as head (eg. 3,2,1)

    public MedianFinder() {
        min = new PriorityQueue<>(); // default behavior of PriorityQueue is minHeap
        max = new PriorityQueue<>(Collections.reverseOrder()); // reversed is maxHeap
    }
    
    public void addNum(int num) {
        // add to maxHeap(smaller half) if maxHeap is empty or num is smaller than largest element
        if(max.isEmpty()||num<max.peek()) max.add(num);
        // if maxHeap is not empty or num larger than maxHeap top elem, add to minHeap (larger half)
        else min.add(num);
        // balancing logic (keep heaps within +-1 of each other) (only called when heaps unbalanced)
        // if maxHeap larger than minHeap by more than 1, move from maxHeap to minHeap
        if(max.size()-min.size()>1) min.add(max.poll());
        // if minHeap larger, move from minheap to maxHeap
        else if(min.size()-max.size()>1) max.add(min.poll());
    }
    
    public double findMedian() {
        // for even sized input, take from min and max heap divided by 2
        // division by double to prevent int overflow
        if(min.size() == max.size()) return (max.peek()/2.0+min.peek()/2.0);
        // return from minHeap if it is larger
        else if(min.size()>max.size()) return min.peek();
        // else return from maxHeap
        else return max.peek();
    }
}

// ## TreeMap and DLL Soln (Best runtime 128 ms)
class MedianFinder {
    class node{
        int val;node prev;node next;
        node(int v){val=v;prev=null;next=null;}
    }
    //will store median(if size is even it will store the first median)
    node median;
    int size;
    //it will store dll in sorted form
    node head;
    //it will store last occurence of each unqiue integer in dll
    TreeMap<Integer,node> h;
    public MedianFinder() {
        median=null;
        size=0;
        head=null;
        h=new TreeMap();
    }
    
    public void addNum(int num) {
        size++;
        node curr=new node(num);
        //we find the last node starting from left whose value is less than num
        if(h.lowerKey(num)!=null){
            node key=h.get(h.lowerKey(num));
            curr.next=key.next;
            if(key.next!=null)key.next.prev=curr;
            curr.prev=key;
            key.next=curr;
        }else{
            if(head==null)head=curr;
            else{
                head.prev=curr;
                curr.next=head;
                head=curr;
            }
        }
        //we will move median left or right depending upon num
        if(h.get(num)==null)h.put(num,curr);
        if(size==1||size==2)median=head;
        else if(size==3)median=head.next;
        else if(size%2==0){
            if(median.val>=num)median=median.prev;
        }else{
            if(num>median.val)median=median.next;
        }
    }
    
    public double findMedian() {
        if(size%2!=0)return (double)median.val;
        else return (median.val+median.next.val)/((double)2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
