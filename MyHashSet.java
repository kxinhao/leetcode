// 3rd impl (chaining) 
class MyHashSet {
    private int size;
    private List<List<Integer>> bucketList;

    public MyHashSet() {
        size = 1000;
        bucketList = new ArrayList<>(size);
        for(int i = 0; i < size; i++) {
            bucketList.add(new LinkedList<>());
        } 
    }
    
    public void add(int key) {
        int index = hash(key);
        List<Integer> bucket = bucketList.get(index);
        if(!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        List<Integer> bucket = bucketList.get(index);
        bucket.remove(Integer.valueOf(key));    
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        List<Integer> bucket = bucketList.get(index);
        return bucket.contains(key);
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
