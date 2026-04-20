package BinaryTrees.Medium.CheckForBalancedBinaryTree;
import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/check-for-balanced-binary-tree?category=medium-problems&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/balanced-binary-tree/

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack
class Solution {
    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);

        return balanced;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1) {
            balanced = false;
        }

        return 1 + Math.max(left, right);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack
class Solution_Recommended {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        int lh = height(root.left);
        if (lh == -1)
            return -1;

        int rh = height(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return 1 + Math.max(lh, rh);
    }

}

public class CheckForBalancedBinaryTree {
    public static void main(String[] args) {

    }
}
