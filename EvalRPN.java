/**
 * LeetCode 150 Evaluate Reverse Polish Notation (Medium)
 * TC: O(N), SC: O(N)
 *
 */

// 3rd impl
class Solution {
    public int evalRPN(String[] tokens) {
        // valid operands +, -, *, /
        List<String> operands = new ArrayList<String>();
        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");
        // stack operations for order of operations, push digits pop operands
        Stack<Integer> rpnStack = new Stack<Integer>();
        for(int i = 0; i<tokens.length; i++) {
            if(operands.contains(tokens[i])) {
                int a = rpnStack.pop();
                int b = rpnStack.pop();
                switch(tokens[i]) {
                    case "+":
                        rpnStack.push(b + a);
                        break;
                    case "-":
                        rpnStack.push(b - a);
                        break;
                    case "*":
                        rpnStack.push(b * a);
                        break;
                    case "/":
                        rpnStack.push(b / a);
                        break;
                    default:
                        System.out.println("something wrong");
                }
            }
            else rpnStack.push(Integer.parseInt(tokens[i]));
        }
        return rpnStack.pop();
    }
}
