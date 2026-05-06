package BinarySearchTrees.Medium.LCAInBST;
// https://takeuforward.org/practice/dsa/lca-in-bst?category=medium&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

import BinaryTrees.TreeNode;

// Time Complexity: O(n)
class Solution {
    public TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}

// Time Compleixty: O(logn)
// Time Complexity: O(H)
// Space Complexity: O(1) iterative
class Solution_Optimal {
    public TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root;
        }

        // check for left side
        if (p < root.data && q < root.data) {
            return lca(root.left, p, q);
        } else if (p > root.data && q > root.data) {
            // check for right side
            return lca(root.right, p, q);
        }

        return root;
    }
}

public class LCAInBST {
    public static void main(String[] args) {

    }
}
