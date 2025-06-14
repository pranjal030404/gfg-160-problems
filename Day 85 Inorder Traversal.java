
// Given a Binary Tree, your task is to return its In-Order Traversal.

// An inorder traversal first visits the left child (including its entire subtree), then visits the node, and finally visits the right child (including its entire subtree).

// Follow Up: Try solving this with O(1) auxiliary space.

class Solution {
    // Helper function for recursion
     void inorderHelper(Node root, ArrayList<Integer> res) {
        if (root == null)
            return;

        // Traverse left subtree
        inorderHelper(root.left, res);

        // Visit node
        res.add(root.data);

        // Traverse right subtree
        inorderHelper(root.right, res);
    }

    // Main function to return inorder traversal
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorderHelper(root, res);
        return res;
    }
}
