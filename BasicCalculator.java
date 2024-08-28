/**
 * LeetCode 224 Basic Calculator (Hard)
 * Soln using conversion to RPN and evaluate the RPN (46ms)
 * Soln with recursion TC: O(N), SC: O(N) (1ms)
 * eg. (1+(4+5+2)-3)+(6+8)
 */

// recursion soln
class Solution {
    int ind;
    public int calculate(String s) {
        ind = 0;
        return calc(s);
    }
    private int calc(String s) {
        int num = 0, ans = 0, sign = 1;
        while(ind<s.length()) {
            char c = s.charAt(ind++);
            if(c>='0' && c<='9') num = num*10 + (c-'0');
            else if(c=='(') {
                num = calc(s);
            } else if (c==')') {
                return ans += num*sign;
            } else if(c=='+' || c=='-') {
                ans += num*sign;
                num = 0;
                sign = (c=='-') ? -1 : 1;
            }
        }
        ans += num*sign;
        return ans;
    }
}

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
