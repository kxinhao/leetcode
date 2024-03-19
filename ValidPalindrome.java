// brute force implementation with stringbuilder and language methods
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
