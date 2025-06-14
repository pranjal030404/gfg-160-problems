// Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.

// Note: The output is written in postorder traversal



class Solution {
    static int preIndex = 0;

    public static Node buildTree(int inorder[], int preorder[]) {
        preIndex = 0;
        return buildTreeHelper(inorder, preorder, 0, inorder.length - 1);
    }

    private static Node buildTreeHelper(int[] inorder, int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        Node root = new Node(preorder[preIndex++]);

        if (inStart == inEnd) return root;

        int inIndex = search(inorder, inStart, inEnd, root.data);

        root.left = buildTreeHelper(inorder, preorder, inStart, inIndex - 1);
        root.right = buildTreeHelper(inorder, preorder, inIndex + 1, inEnd);

        return root;
    }

    private static int search(int[] arr, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }
}
