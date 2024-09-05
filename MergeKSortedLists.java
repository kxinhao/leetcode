/**
 * Leetcode 23 Merge K Sorted Lists (Hard)
 * soln based on PriorityQueue characteristic of defining comparator for sorting on add
 * TC: O(NlogK) N = num of nodes, K = size of list
 * SC: O(K) K = size of list
 */
// 2nd impl

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
        // return node.next
        ListNode dummy = new ListNode(0);
        // working node
        ListNode tail = dummy;
        // add head nodes of each linked lists to queue
        for(ListNode node:lists) if(node!=null) queue.offer(node);
        // attach PQ sorted nodes to working node
        // add all subsequent valid nodes of the linked lists to queue
        // each head node acts as a space reservation for thier subsequent nodes, so whenever
        // one of their nodes are polled, it is replaced with the subsequent node and sorted again
        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next!=null) queue.offer(tail.next);
        }
        return dummy.next;
    }
}
