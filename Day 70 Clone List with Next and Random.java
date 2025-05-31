// You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node of the singly linked list, and a random pointer that points to the random node of the linked list.

// Construct a copy of this linked list. The copy should consist of the same number of new nodes, where each new node has the value corresponding to its original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list, such that it also represent the same list state. None of the pointers in the new list should point to nodes in the original list.

// Return the head of the copied linked list.

// NOTE : Original linked list should remain unchanged.

class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null)
            return null;

        Node current = head;
        while (current != null) {
            Node copied = new Node(current.data);
            copied.next = current.next;
            current.next = copied;
            current = copied.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        current = head;
        Node newHead = head.next;
        Node copyCurrent = newHead;

        while (current != null) {
            current.next = current.next.next;
            current = current.next;

            if (copyCurrent.next != null) {
                copyCurrent.next = copyCurrent.next.next;
                copyCurrent = copyCurrent.next;
            }
        }

        return newHead;
    }
}