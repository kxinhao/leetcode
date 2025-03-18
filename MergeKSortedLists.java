/**
 * Leetcode 23 Merge K Sorted Lists (Hard)
 * soln based on PriorityQueue(heap) characteristic of defining comparator for sorting on add
 * TC: O(NlogK) N = num of nodes, K = size of lists
 * SC: O(K) K = size of lists
 * alternative: divide and conquer with same TC and SC
 */
// 3rd impl

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
        // each head node acts as a space reservation for their subsequent nodes, so whenever
        // one of their nodes are polled, it is replaced with the next node and sorted again
        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next!=null) queue.offer(tail.next);
        }
        return dummy.next;
    }
}

// divide and conquer (same tc and sc, mostly asked as followup)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // corner case
        if(lists == null || lists.length == 0) return null;
        
        ListNode head = merge(lists, 0, lists.length - 1);
        return head;
    }

    // return new head after merging list[left : right]
    public ListNode merge(ListNode[] lists, int left, int right){
        // base case
        if(left == right) return lists[left];
        
        int mid = left + (right - left)/2;
        ListNode l1 = merge(lists, left, mid); // merge [left : mid]
        ListNode l2 = merge(lists, mid + 1, right); // merge [mid + 1 : right]
        
        return mergeTwoLists(l1, l2);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null || cur2 != null){
            if(cur1 == null){
                cur.next = cur2;
                break;
            }else if(cur2 == null){
                cur.next = cur1;
                break;
            }else{
                if(cur1.val <= cur2.val){
                    cur.next = cur1;
                    cur1 = cur1.next;
                }else{
                    cur.next = cur2;
                    cur2 = cur2.next;
                }
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
