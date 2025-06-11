//Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.




class Solution {
    int max = 0;

    int diameter(Node root) {
        height(root);
        return max;
    }

    int height(Node node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update the diameter at this node
        max = Math.max(max, leftHeight + rightHeight);

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}