// 2nd impl, using only push/pop/size/isEmpty of stack type data structures
class MyQueue {

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public MyQueue() {
               
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    // pop and peek shares method of moving last pushed item to output stack
    public int pop() {
        peek();
        return output.pop();
    }
    
    public int peek() {
        if(output.empty())
            while(!input.empty())
                output.push(input.pop());
        return output.peek();
    }
    
    public boolean empty() {
        return input.empty() && output.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
