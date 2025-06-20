
// Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
// Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original Binary search tree(BST).




class Solution {
    Node first, middle, last, prev;

    void correctBST(Node root) {
        first = middle = last = prev = null;
        
        inorder(root);

        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && root.data < prev.data) {
            if (first == null) {
                // First violation
                first = prev;
                middle = root;
            } else {
                // Second violation
                last = root;
            }
        }

        prev = root;

        inorder(root.right);
    }
}