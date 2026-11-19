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
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for(ListNode walker : lists) {
            if (walker != null) {
                pq.offer(walker);
            }
        }

        ListNode res = new ListNode(-1);
        ListNode head = res;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            head.next = smallest;
            head = head.next;

            smallest = smallest.next;

            if (smallest != null) {
                pq.offer(smallest);
            }
        }

        return res.next;
    }
}
