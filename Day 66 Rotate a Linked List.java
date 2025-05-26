// Given the head of a singly linked list, your task is to left rotate the linked list k times.




class Solution {
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // Step 1: Find length of the list
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Handle cases where k >= length
        k = k % length;
        if (k == 0)
            return head;

        // Step 3: Traverse to the kth node
        Node kthNode = head;
        for (int i = 1; i < k; i++) {
            kthNode = kthNode.next;
        }

        // Step 4: Update head and break the link
        Node newHead = kthNode.next;
        kthNode.next = null;

        // Step 5: Attach the old tail to the original head
        current.next = head;

        return newHead;
    }
}