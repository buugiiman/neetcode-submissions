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

        //reverse the list

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // remove the n-th node
        ListNode reverseHead = prev;
        
        if (n == 1) {
            reverseHead = reverseHead.next;

        } else {
            ListNode walker = reverseHead;
            for (int i = 1; i < n-1; i++) {
                walker = walker.next;
            }

            walker.next = walker.next.next;
        }

        ListNode lastHead = reverseHead;
        ListNode lastPrev = null;

        while (lastHead != null) {
            ListNode lastNext = lastHead.next;
            lastHead.next = lastPrev;

            lastPrev = lastHead;
            lastHead = lastNext;
        }

        return lastPrev;

    }
}
