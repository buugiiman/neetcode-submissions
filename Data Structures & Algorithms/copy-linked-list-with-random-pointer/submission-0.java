/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();
        Node walker = head;

        while(walker != null) {
            Node temp = walker;
            Node n = new Node(walker.val);

            map.put(temp, n);

            walker = walker.next;
        }

        walker = head;

        while (walker != null) {
            Node copy = map.get(walker);
            copy.next = map.get(walker.next);
            copy.random = map.get(walker.random);

            walker = walker.next;
        }

        return map.get(head);
    }
}
