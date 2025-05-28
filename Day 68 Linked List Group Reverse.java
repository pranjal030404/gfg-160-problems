// Given the head a linked list, the task is to reverse every k node in the linked list. If the number of nodes is not a multiple of k then the left-out nodes in the end, should be considered as a group and must be reversed

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;

        int count = 0;
        // First pass to count total nodes
        while (curr != null) {
            curr = curr.next;
            count++;
        }

        curr = head; // reset current to head

        while (count >= k) {
            Node first = curr;
            Node prevGroupEnd = prev;

            // Reverse k nodes
            Node prevNode = null;
            Node nextNode = null;
            for (int i = 0; i < k; i++) {
                nextNode = curr.next;
                curr.next = prevNode;
                prevNode = curr;
                curr = nextNode;
            }

            // Connect the reversed group to the list
            prevGroupEnd.next = prevNode;
            first.next = curr;

            // Update pointers for next iteration
            prev = first;
            count -= k;
        }

        // If remaining nodes need to be reversed (when count < k)
        if (count > 0) {
            Node prevNode = null;
            Node nextNode = null;
            Node first = curr;

            while (curr != null) {
                nextNode = curr.next;
                curr.next = prevNode;
                prevNode = curr;
                curr = nextNode;
            }

            prev.next = prevNode;
            first.next = null;
        }

        return dummy.next;
    }
}