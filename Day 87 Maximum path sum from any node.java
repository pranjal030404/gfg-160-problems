// Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.






class Solution {
    int maxSum;

    public int findMaxSum(Node node) {
        maxSum = Integer.MIN_VALUE;
        maxPathDown(node);
        return maxSum;
    }

    private int maxPathDown(Node node) {
        if (node == null) return 0;

        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));

        maxSum = Math.max(maxSum, left + right + node.data);

        return Math.max(left, right) + node.data;
    }
}
