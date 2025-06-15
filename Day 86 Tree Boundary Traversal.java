// Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

// Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.

// Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.

// Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order. You must prefer the right child over the left child when traversing. Do not include the root in this section if it was already included in the left boundary.

// Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary.

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        if (!isLeaf(root))
            result.add(root.data);

        addLeftBoundary(root.left, result);
        addLeaves(root, result);
        addRightBoundary(root.right, result);

        return result;
    }

    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    private void addLeftBoundary(Node node, ArrayList<Integer> res) {
        while (node != null) {
            if (!isLeaf(node))
                res.add(node.data);
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    private void addRightBoundary(Node node, ArrayList<Integer> res) {
        Stack<Integer> temp = new Stack<>();
        while (node != null) {
            if (!isLeaf(node))
                temp.push(node.data);
            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }
        while (!temp.isEmpty()) {
            res.add(temp.pop());
        }
    }

    private void addLeaves(Node node, ArrayList<Integer> res) {
        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }
        if (node.left != null)
            addLeaves(node.left, res);
        if (node.right != null)
            addLeaves(node.right, res);
    }
}