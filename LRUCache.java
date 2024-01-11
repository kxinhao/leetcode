// ** IMPL COUNT: 5
// 2 ways to impl, Node class with both key and value,
// or reverseLookup to retrieve key
class LRUCache {

    class Node {
        int value, key;
        Node next;
        Node prev;

        public Node(int inputKey, int inputValue) {
            this.key = inputKey;
            this.value = inputValue;
        }
    }

    private int length;
    private int capacity;
    private Node head;
    private Node tail;

    private Map<Integer, Node> lookup;
    //private Map<Node, Integer> reverseLookup;

    public LRUCache(int capacity) {
        this.length = 0;
        this.capacity = capacity;
        this.head = this.tail = null;
        this.lookup = new HashMap<Integer, Node>();
        //this.reverseLookup = new HashMap<Node, Integer>();
    }

    // retrieve node from hashmap,
    // if no node found, return -1
    // if node found, move node to back of map
    public int get(int key) {
       Node node = this.lookup.get(key);
       if(null == node) {
           return -1;
       }
       this.detach(node);
       this.prepend(node);
       return node.value;
    }

    // get node from hashmap,
    // if no node found, create new node, add length, prepend node
    // then check if length exceeds size and trim
    // else
    // move found node to end and replace value
    public void put(int key, int value) {
       Node node = this.lookup.get(key);
       if(null == node) {
           node = new Node(key,value);
           this.length++;
           this.prepend(node);
           this.trimCache();

           this.lookup.put(key, node);
           //this.reverseLookup.put(node, key);
       } else {
           this.detach(node);
           this.prepend(node);
           node.value = value;
       }
    }

    // remove linkages of node at end of DLL
    private void detach(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        if(this.head == node) {
            this.head = this.head.next;
        }
        if(this.tail == node) {
            this.tail = this.tail.prev;
        }

        node.next = null;
        node.prev = null;
    }

    // add node to front of doubly linked list
    private void prepend(Node node) {
        if(null == this.head) {
            this.head = this.tail = node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    // check if length more than cap, if so remove least
    // used node from end of DLL
    private void trimCache() {
        if(this.length <= this.capacity) {
            return;
        }
        Node t = this.tail;
        this.detach(t);
        //int key = this.reverseLookup.get(t);
        this.lookup.remove(t.key);
        //this.reverseLookup.remove(t);
        this.length--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
