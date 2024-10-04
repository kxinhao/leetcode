/*
 * LeetCode 206 Reverse Linked List (Easy)
 * Iterative TC: O(N), SC: O(1)
 * Recursive TC: O(N), SC O(N)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    //recursive method (may cause call stack buffer overflow when large input is given)
    /*
    public ListNode reverseList(ListNode node) {
        if(node=null || node.next==null) return node; //checks if last node and returns
        ListNode curr = reverseList(node.next); //travels down to tail node through recursion; node is 2nd last node here
        node.next.next = node; //points last node to 2nd last by assigning last node's next'
        node.next = null; //break link from node to node.next as the reverse link has been established
        return curr;
    }
    */

    //iterative method
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = next;
        }
        return prev;
    }
    
}
