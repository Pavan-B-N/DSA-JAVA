package BinarySearchTrees.Easy.SearchInBST;
import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/search-in-bst?category=theory-and-basics&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/search-in-a-binary-search-tree/

// Time Complexity: O(H) where H = log N avg, N worst
// Space Complexity: O(1) iterative
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (val < root.data) {
            return searchBST(root.left, val);
        } else if (val > root.data) {
            return searchBST(root.right, val);
        }

        return root;
    }
}

public class SearchInBST {
    public static void main(String[] args) {

    }
}
