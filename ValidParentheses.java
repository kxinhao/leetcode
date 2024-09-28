/*
 * LeetCode 20 Valid Parentheses (Easy)
 * Stack Soln, using stack data struct class and push in compl parentheses
 * check stack empty for empty string/non complement char
 */

//  3rd impl
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(c=='(') {
                stack.push(')');
            } else if (c=='{') {
                stack.push('}'); 
            } else if (c=='[') {
                stack.push(']');
            } else if (stack.empty() || stack.pop()!=c) {
                return false;
            }
        }   
        return stack.empty();
    }
}
