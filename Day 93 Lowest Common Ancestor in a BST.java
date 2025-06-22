// Given a Binary Search Tree (with all values unique) and two nodes n1 and n2 (n1 != n2). You may assume that both nodes exist in the tree. Find the Lowest Common Ancestor (LCA) of the given two nodes in the BST.

// LCA between two nodes n1 and n2 is defined as the lowest node that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).








class Solution {
    Node LCA(Node root, Node n1, Node n2) {
        if (root == null) return null;

        if (n1.data < root.data && n2.data < root.data)
            return LCA(root.left, n1, n2);
        if (n1.data > root.data && n2.data > root.data)
            return LCA(root.right, n1, n2);

        return root;
    }
}
