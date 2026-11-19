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

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode walker = dummy;

        while(list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                walker.next = list2;
                list2 = list2.next;
            } else {
                walker.next = list1;
                list1 = list1.next;
            }

            walker = walker.next;
        }

        if (list1 != null) {
            walker.next = list1;
        }

        else if(list2 != null) {
            walker.next = list2;
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        for (int i = 1; i < lists.length; i++) {
            lists[i] = merge(lists[i-1], lists[i]);
        }

        return lists[lists.length-1];
    }
}
