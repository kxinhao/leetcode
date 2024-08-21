/**
 * LeetCode 295 Find Median from Data Stream (Hard)
 * use 2 heap, min/max to store larger/smaller halves of data
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
 */

// 2x Heap soln (Best runtime 85 ms, additional addNum() conditions to shave 50ms off runtime)
class MedianFinder {

    private PriorityQueue<Integer> min; // minHeap, stores larger half, size n/2+1 if odd input
    private PriorityQueue<Integer> max; // maxHeap, stores smaller half, size n/2

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        // add to maxHeap(smaller half) if maxHeap is empty or num is smaller than largest element
        if(max.isEmpty()||num<max.peek()) max.add(num);
        // if maxHeap is not empty or num larger than maxHeap top elem, add to minHeap (larger half)
        else {
            min.add(num);
        }
        // balancing logic (keep heaps within +-1 of each other) (only called when heaps unbalanced)
        // if maxHeap larger than minHeap by more than 1, move from maxHeap to minHeap
        if(max.size()-min.size()>1) min.add(max.poll());
        // if minHeap larger, move from minheap to maxHeap
        else if(min.size()-max.size()>1) {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        // for even sized input, take from min and max heap divided by 2
        // division by double to prevent int overflow
        if(min.size() == max.size()) return (max.peek()/2.0+min.peek()/2.0);
        // return from minHeap if it is larger
        else if(min.size()>max.size()) return min.peek();
        // else return from maxHeap
        return max.peek();
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
