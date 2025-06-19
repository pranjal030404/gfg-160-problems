//Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target
 

class Solution {
    HashSet<Integer> set = new HashSet<>();

    boolean findTarget(Node root, int target) {
        return dfs(root, target);
    }

    boolean dfs(Node node, int target) {
        if (node == null) return false;

        if (set.contains(target - node.data)) return true;

        set.add(node.data);

        return dfs(node.left, target) || dfs(node.right, target);
    }
}
