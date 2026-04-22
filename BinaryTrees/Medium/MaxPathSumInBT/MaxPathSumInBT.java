package BinaryTrees.Medium.MaxPathSumInBT;
import BinaryTrees.TreeNode;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
// https://takeuforward.org/practice/dsa/maximum-path-sum-?category=medium-problems&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        int maxPathValue = Math.max(left + root.val + right, root.val + Math.max(left, right));
        maxSum = Math.max(maxSum, maxPathValue);

        return root.val + Math.max(left, right);
    }
}

public class MaxPathSumInBT {
    public static void main(String[] args) {

    }
}
