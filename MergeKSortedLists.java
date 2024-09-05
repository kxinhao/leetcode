/**
 * Leetcode 23 Merge K Sorted Lists (Hard)
 * soln based on PriorityQueue characteristic of defining comparator for sorting on add
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null; 
        // use custom comparator in PriorityQueue to sort each ListNode on add
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (a,b)->Integer.compare(a.val, b.val));
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(ListNode node:lists) if(node!=null) queue.offer(node);
        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next!=null) queue.offer(tail.next);
        }
        return dummy.next;
    }
}
