// Given a binary tree, find its height.

// The height of a tree is defined as the number of edges on the longest path from the root to a leaf node. A leaf node is a node that does not have any children.


class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        if (node == null)
            return -1;  // return -1 to count edges instead of nodes

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
