// Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. A path can start and end at any node within the tree but must always move downward (from parent to child).



class Solution {
    public int sumK(Node root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // To count paths that start from the root
        return solve(root, 0, k, map);
    }

    private int solve(Node node, int currSum, int k, Map<Integer, Integer> map) {
        if (node == null) return 0;

        currSum += node.data;
        int res = map.getOrDefault(currSum - k, 0);

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        res += solve(node.left, currSum, k, map);
        res += solve(node.right, currSum, k, map);

        map.put(currSum, map.get(currSum) - 1); // Backtrack
        return res;
    }
}
