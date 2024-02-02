// 2nd impl
class MyHashMap {

    // SLL to rep bucket 
    private class Node {
        int key, value;
        // use next node in constructor to add on to SLL
        Node next;
        public Node(int key, int value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        } 
    }

    // setting size to prime no to minimize collision when hashing
    private static final int size = 10007;
    private Node[] bucketArr;

    public MyHashMap() {
        this.bucketArr = new Node[this.size];
    }

    
    public void put(int key, int value) {
        // node with key at bucket of bucketArr[ind] is removed,  
        // essentially update of value at key location if exists
        this.remove(key);
        int ind = this.hash(key);
        // new node will be prepended to start of bucket
        Node node = new Node(key, value, this.bucketArr[ind]);
        this.bucketArr[ind] = node;
    }
    
    public int get(int key) {
        int ind = this.hash(key);
        Node node = this.bucketArr[ind];
        while(node!=null) {
            if(node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }
    
    // shared with hashset
    public void remove(int key) {
        int ind = this.hash(key);
        Node node = this.bucketArr[ind];
        if (node == null) {
          return;
        }
        // if first node in bucket, set to next node
        // which is null or next node ref
        if (node.key == key) {
          this.bucketArr[ind] = node.next;
        }
        // else, proceed through bucket and find next node with key
        // and set next node ref to next of next node
        else for (; node.next != null; node = node.next) {
          if (node.next.key == key) {
            node.next = node.next.next;
            return;
          }
        }
    }

    private int hash(int key) {
      return key % this.size;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
