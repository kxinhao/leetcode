class DynamicArray {

    private int capacity, length;
    private int[] arr;

    public dynamicarray(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.length = 0;
    }

    public int get(int i) {
        return this.arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if(this.length >= this.capacity) {
            this.resize();
        }
        this.arr[this.length] = n;
        this.length++;
    }

    public int popback() {
        int v = this.arr[this.length-1];
        this.length--;
        int[] newarr = new int[this.capacity];
        for(int i = 0; i < this.length; i++) {
            newarr[i] = this.arr[i];
        }
        this.arr = newarr;
        return v;
    }

    private void resize() {
        this.capacity *= 2;
        int[] newarr = new int[this.capacity];
        for(int i = 0; i < arr.length; i++) {
            newarr[i] = this.arr[i];
        }
        this.arr = newarr;
    }

    public int getsize() {
        return this.length;
    }

    public int getcapacity() {
        return this.capacity;
    }
}

