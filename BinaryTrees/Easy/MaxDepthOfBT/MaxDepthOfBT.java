package BinaryTrees.Easy.MaxDepthOfBT;
import BinaryTrees.TreeNode;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
// https://takeuforward.org/practice/dsa/maximum-depth-in-bt?category=medium-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);

    }
}

public class MaxDepthOfBT {
    public static void main(String[] args) {

    }
}
