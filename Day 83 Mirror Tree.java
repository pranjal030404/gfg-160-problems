// Given a binary tree, convert the binary tree to its Mirror tree.

// Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged




class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if (node == null) return;

        // Swap the left and right children
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recur for left and right subtrees
        mirror(node.left);
        mirror(node.right);
    }
}