// Given a BST and an integer k, the task is to find the kth smallest element in the BST. If there is no kth smallest element present then return -1.




class Solution {
    int count = 0;
    int result = -1;

    public int kthSmallest(Node root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(Node root, int k) {
        if (root == null) return;

        inorder(root.left, k);

        count++;
        if (count == k) {
            result = root.data;
            return;
        }

        inorder(root.right, k);
    }
}
