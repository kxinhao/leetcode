/*
 * LeetCode 876 Middle of Linked List (Easy)
 * TC: O(N), SC: O(1)
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

// naive soln O(1.5N)
class Solution {
    public ListNode middleNode(ListNode head) {
        int mid = 0, length = 1;
        ListNode curr = head, midNode = head;
        while (curr!=null) {
            curr = curr.next;
            length++;
        }
        mid = (int) Math.ceil(length/2.0);
        // mid node referenced from prev node, hence loop must stop before mid ind
        for(int i = 1; i<mid; i++) {
            midNode = midNode.next;
        }
        return midNode;
    }
}

// 2nd impl
// single pass 2 pointer soln O(.5N)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
