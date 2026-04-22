package BinaryTrees.Medium.LCAInBT;
import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/lca-in-bt?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}

public class LCAInBT {
    public static void main(String[] args) {

    }
}
