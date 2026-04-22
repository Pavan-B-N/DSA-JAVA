package BinaryTrees.Medium.IsBalancedBinaryTree;
import BinaryTrees.TreeNode;

// https://leetcode.com/problems/balanced-binary-tree/
// https://takeuforward.org/practice/dsa/check-for-balanced-binary-tree?category=medium-problems&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem&solution=optimal

// O(n^2)
// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }
}

// O(n)
// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack
class Solution_Optimal {
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

public class IsBalancedBinaryTree {
    public static void main(String[] args) {

    }
}
