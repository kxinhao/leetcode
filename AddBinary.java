/**
 * LeetCode 67 Add Binary (Easy)
 */

class Solution {
    public String addBinary(String a, String b) {
        // a = 1010, b = 1011, expected ans = 10101
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        // iterating from back to front ind
        // string representation of summation is built right to left
        while(i>=0||j>=0) {
            // accounting for carry from last ind addition
            int sum = carry;
            // binary conversion to int sum by ascii char value subtraction
            if(j>=0) sum += b.charAt(j--) - '0'; // sum = 1,1,1,1
            if(i>=0) sum += a.charAt(i--) - '0'; // sum = 1,2,1,2
            // if sum==2 or 0 append 0, 2 will result in carry=1
            sb.append(sum%2); // sb = '1','10','101','1010'
            carry = sum/2; // carry = 0,1,0,1
        }
        // accounting for remaining carry value
        if(carry!=0) sb.append(carry); // 10101
        // reverse sb to get left to right representation of binary
        return sb.reverse().toString();
    }
}
