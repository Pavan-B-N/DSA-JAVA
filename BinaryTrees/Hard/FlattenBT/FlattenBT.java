package BinaryTrees.Hard.FlattenBT;
import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/flatten-binary-tree-to-linked-list?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

// Time Complexity: O(N)
// Space Complexity: O(1) using Morris traversal or O(H) recursion stack
class Solution {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }

}

public class FlattenBT {
    public static void main(String[] args) {

    }
}
