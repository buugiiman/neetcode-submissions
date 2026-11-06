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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }


        ListNode dummy = new ListNode(-1);
        dummy.next = prev;

        ListNode walker = dummy;
        int count = 1;

        while (walker.next != null && count != n) {
            walker = walker.next;
            count++;
        }

        walker.next = walker.next.next;

        ListNode reversePrev = null;
        ListNode reverseCurr = dummy.next;

        while (reverseCurr != null) {
            ListNode reverseNext = reverseCurr.next;
            reverseCurr.next = reversePrev;

            reversePrev = reverseCurr;
            reverseCurr = reverseNext;
        }

        return reversePrev;
    }
}
