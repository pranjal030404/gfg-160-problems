// Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

// For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

// Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.







class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        num1 = removeLeadingZeros(num1);
        num2 = removeLeadingZeros(num2);
        if (num1 == null && num2 == null) {
            return new Node(0);
        }
        Node rev1 = reverseList(num1);
        Node rev2 = reverseList(num2);
        Node result = null;
        Node current = null;
        int carry = 0;
        while (rev1 != null || rev2 != null || carry != 0) {
            int sum = carry;
            if (rev1 != null) {
                sum += rev1.data;
                rev1 = rev1.next;
            }
            if (rev2 != null) {
                sum += rev2.data;
                rev2 = rev2.next;
            }
            carry = sum / 10;
            Node newNode = new Node(sum % 10);
            if (result == null) {
                result = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }
        result = reverseList(result);
        return removeLeadingZeros(result);
    }
    static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    static Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0 && head.next != null) {
            head = head.next;
        }
        return head;
    }
}