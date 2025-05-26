// Given the head of a linked list, the task is to reverse this list and return the reversed head.




class Solution {
    Node reverseList(Node head) {
        // code here
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
}