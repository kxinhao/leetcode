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
    
    //recursive method
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head; //checks if last node and returns
        ListNode prev = null;
        ListNode curr = reverseList(head.next); //travels down to tail node through recursion; head is 2nd last node here
        head.next.next = head; //points last node to 2nd last by assigning last node's next'
        head.next = prev; //break link from head to head.next as the reverse link has been established
        return curr;
    }

    //iterative method
    /*
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = next;
        }
        return curr;
    }
    */
}
