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
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the second half.
        //split into two independent lists.

        ListNode head2 = slow.next;
        slow.next = null;

        ListNode prev = null;

        while(head2 != null) {
            ListNode next = head2.next;
            head2.next = prev;

            prev = head2;
            head2 = next;
        }

        // merge the first and second half.
        //first half starts at head
        //second half starts at prev

        ListNode firstHalf = head;

        while (firstHalf != null && prev != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = prev.next;

            firstHalf.next = prev;
            firstHalf.next.next = temp1;

            firstHalf = temp1;
            prev = temp2;
        }

    }
}
