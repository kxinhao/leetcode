/**
 * LeetCode 224 Basic Calculator (Hard)
 * Soln using conversion to RPN and evaluate the RPN (46ms) (makes use of RPN eval concept, not optimal)
 * Soln with recursion TC: O(N), SC: O(N) (1ms) 
 * Soln via Iteration TC: O(N), SC: O(N) (9ms)(most intuitive and easy to understand,
 * 2 key points:
 *      1. '+' or '-' gives the sign for next number and these with ')' calc the result of prev op
 *      2. use stack to store result and signage before each '(' and apply them to result after ')'
 * stack replaces recursion)
 */

// iteration soln
// 6th impl
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0, num = 0, sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = 10 * num + (c - '0'); // decimal shift via *10 for digit len > 1
            }else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * num;  
                num = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
            }
        }
    // accounts for last num formed at the end if not in parentheses
    if(num != 0) result += sign * num;
    return result;
    }
}
// end iteration soln

// recursion soln (similar principle to iterative, just recursive and more optimal)
class Solution {
    int ind;
    public int calculate(String s) {
        ind = 0;
        return calc(s);
    }
    private int calc(String s) {
        int num = 0, ans = 0, sign = 1;
        while(ind<s.length()) {
            // char at ind then increment ind(post assignment increment)
            char c = s.charAt(ind++);
            // if char is a digit, form num from digit
            // shifts prev digit left and adds new digit on right
            if(c>='0' && c<='9') num = num*10 + (c-'0');
            // when open parentheses, recurse calc for inside equation
            else if(c=='(') {
                num = calc(s);
            }
            // on closing parentheses, exit from recursion and add calc results to ans
            // and convert to +ve or -ve value
            else if (c==')') {
                return ans += num*sign;
            }
            // if + or - operators found, sum to ans the num found thus far with the signage
            // previously set
            // reset num to 0 for new digit calc
            // if - operator, assign -1 to sign for next num formed to be subtracted
            else if(c=='+' || c=='-') {
                ans += num*sign;
                num = 0;
                sign = (c=='-') ? -1 : 1;
            }
        }
        // for final num found, assign signage and sum with rest of ans
        ans += num*sign;
        return ans;
    }
}
// end recursion soln

// RPN soln
class Solution {
    public int calculate(String s) {
        Stack<Integer> digits = new Stack<>();
        Queue<String> queue = buildRPN(s);
        return evaluateRPN(queue);
    }

    private Queue<String> buildRPN(String s) {
        Queue<String> queue = new ArrayDeque();
        Stack<Character> ops = new Stack<>();
        boolean checkUnary = true;
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isWhitespace(c)) continue;
            if(checkUnary) {
                checkUnary = false;
                if(c=='+'||c=='-') queue.add("0");
            }
            if(Character.isDigit(c)) {
                int num = c - '0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num*10 + (s.charAt(i+1) - '0');
                    i++;
                }
                queue.add(String.valueOf(num));
            } else if(c=='(') {
                checkUnary = true;
                ops.push(c);
            } else if(c==')') {
                while(ops.peek()!='(' && !ops.isEmpty()) {
                    queue.add(String.valueOf(ops.pop()));
                }
                ops.pop();
            } else {
                while(!ops.isEmpty() && ops.peek()!='(') {
                    queue.add(String.valueOf(ops.pop()));
                }
                ops.push(c);
            }
        }
        while(!ops.isEmpty()) queue.add(String.valueOf(ops.pop()));
        return queue;
    }

    private int evaluateRPN(Queue<String> queue) {
        Deque<Integer> numStack = new ArrayDeque();
        int a = 0, b = 0;
        while(!queue.isEmpty()) {
            String token = queue.poll();
            if(token.equals("+")) {
                b = numStack.pop();
                a = numStack.pop();
                numStack.push(a+b);
            } else if(token.equals("-")) {
                b = numStack.pop();
                a = numStack.pop();
                numStack.push(a-b);
            } else {
                numStack.push(Integer.valueOf(token));
            }
        }
        return numStack.pop();
    }
}
// end RPN soln
