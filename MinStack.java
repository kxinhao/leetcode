/**
 * LeetCode 155 Min Stack (Medium)
 * Implementation using modified Singly Linked List with min value and nested custom Node class
 */
// 3rd impl runtime beat 100% (3ms)

class MinStack {
    class StackNode {
        int val, min;
        StackNode next;
        StackNode(int val, int min, StackNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private StackNode head;
   
    public void push(int val) {
        if(head == null) head = new StackNode(val, val, null);
        // ** key point for new min val check
        else head = new StackNode(val, Math.min(val, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
