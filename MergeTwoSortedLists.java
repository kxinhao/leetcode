/**
 * LeetCode 21 Merge Two Sorted Lists (Easy)
 */
// 7th impl, using actual splicing of lists
// rmb to return next of ans node, 1st node is empty due to initialization
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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // input mutational, iterative method
    if(list1 == null || list2 == null) return list1 == null ? list2 : list1;
    if(list1.value>list2.value) {
      ListNode tmp = list1;
      list1 = list2;
      list2 = tmp;
    }
    ListNode head = list1;
    while(list1.next!=null && list2!=null) {
      if(list1.next.value<list2.value) {
        list1 = list1.next;
      } else {
        ListNode tmp = list2.next;
        list2.next = list1.next;
        list1.next = list2;
        list2 = tmp;
      }
    }
    list1.next = list1.next == null ? list2 : list1.next;
    return head;
  }
        /* Recursion method
        // terminal conditions
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        // recursion calls
        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
        */
      // Iterative method
        /*
        if(list1 == null || list2 == null) return list1 == null ? list2 : list1;
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        while(list1!=null && list2!=null) {
            if(list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = (list1 == null ? list2 : list1);
        return ans.next;
        */
}
