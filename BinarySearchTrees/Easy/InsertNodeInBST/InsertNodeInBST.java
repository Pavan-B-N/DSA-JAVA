package BinarySearchTrees.Easy.InsertNodeInBST;
import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/insert-a-given-node-in-bst?category=medium&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/insert-into-a-binary-search-tree/

// Time Complexity: O(H) where H = log N avg, N worst
// Space Complexity: O(1) iterative
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.data) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}

public class InsertNodeInBST {
    public static void main(String[] args) {

    }
}
