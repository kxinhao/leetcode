/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // dual pointer travelling at 2x speed to loop and meet if cycle is present
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) {
            return false;
        }
        
        ListNode curr = head;
        ListNode skip = head.next;

        while(skip!=null && skip.next!=null) {
            if(curr == skip){
                return true;
            }
            curr = curr.next;
            skip = skip.next.next;
        }
        return false;

    }
} 
