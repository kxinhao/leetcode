// 4th impl
class MyHashSet {

    // simplified SLL, since no need for <k,v> just kin hashSet, to rep bucket
    class Node {
        private int key;
        // using next node for constructor method
        private Node next;

        public Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    // chaining method, use prime size to min collisions
    private static final int size = 10007;
    private Node[] bucketArr;

    public MyHashSet() {
        this.bucketArr = new Node[this.size];
    }

    public void add(int key) {
        int ind = this.hash(key);
        Node node = this.bucketArr[ind];
        // only add after check contains as set only has unique
        if (!this.contains(key)) {
            node = new Node(key, this.bucketArr[ind]);
            this.bucketArr[ind] = node;
        }
    }

    // shared with hashmap
    public void remove(int key) {
        int ind = this.hash(key);
        Node node = this.bucketArr[ind];
        if (node == null) {
            return;
        }
        if (node.key == key) {
            // arr ref
            this.bucketArr[ind] = node.next;
        } else
            for (; node.next != null; node = node.next) {
                if (node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
            }
    }

    public boolean contains(int key) {
        int ind = this.hash(key);
        Node node = this.bucketArr[ind];
        while (node != null) {
            if (node.key == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private int hash(int key) {
        return key % size;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
