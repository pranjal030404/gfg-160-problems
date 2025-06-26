// Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.





import java.util.*;

class Solution {
    Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.data - b.data;
            }
        });

        for (Node node : arr) {
            if (node != null) {
                pq.add(node);
            }
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            tail.next = current;
            tail = tail.next;

            if (current.next != null) {
                pq.add(current.next);
            }
        }

        return dummy.next;
    }
}
