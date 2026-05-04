package BinarySearchTrees.Easy.ValidateBST;
import BinaryTrees.TreeNode;

// https://leetcode.com/problems/validate-binary-search-tree/
// https://takeuforward.org/practice/dsa/check-if-a-tree-is-a-bst-or-not?category=medium&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;

        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }

        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}

public class ValidateBST {
    public static void main(String[] args) {

    }
}
