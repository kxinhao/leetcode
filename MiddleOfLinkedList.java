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
    public ListNode middleNode(ListNode head) {
        int mid = 0, length = 1;
        ListNode curr = head, midNode = head;
        while (curr!=null) {
            curr = curr.next;
            length++;
        }
        mid = (int) Math.ceil(length/2.0);
        // mid node referenced from prev node, hence loop stops before mid ind
        for(int i = 1; i<mid; i++) {
            midNode = midNode.next;
        }
        return midNode;
    }
}
