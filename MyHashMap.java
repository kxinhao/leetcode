class MyHashMap {
    // bucket rep
    private class Node {
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        } 
    }

    int size;
    Node[] bucketArr;

    public MyHashMap() {
        this.size = 1000001;
        this.bucketArr = new Node[this.size];
    }

    private int hash(int key) {
        return key % this.size;
    }
    
    public void put(int key, int value) {
        int ind = this.hash(key);
        Node node = bucketArr[ind];
        while(node!=null) {
            // if exists update
            if(node.key == key) {
                node.value = value;
                return;
            }
            // iterate
            node = node.next;
        }
        // doesnt exist, insert new node
        if(node==null) {
            Node newNode = new Node(key, value);
            newNode.next = bucketArr[ind];
            bucketArr[ind] = newNode;
        }
    }
    
    public int get(int key) {
        int ind = this.hash(key);
        Node node = bucketArr[ind];
        while(node!=null) {
            if(node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int ind = this.hash(key);
        Node node = bucketArr[ind];
        // single node in linked list
        if(node==null||node.next==null) {
            node =null;
            bucketArr[ind] = null;
            return;
        }
        // more than 1 node in linked list, decouple node from LL
        while(node!=null) {
            if(node.key == key) {
                node.next = node.next.next;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
