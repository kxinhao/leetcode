/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //swap heads to progress through if first pass misses intersection
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode currA = headA, currB = headB;
        while(currA!=currB) {
            currA = currA == null? headB : currA.next;
            currB = currB == null? headA : currB.next;
        }

        return currA;
    }
}
