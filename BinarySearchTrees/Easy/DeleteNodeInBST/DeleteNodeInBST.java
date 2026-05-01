package BinarySearchTrees.Easy.DeleteNodeInBST;
import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/delete-a-node-in-bst?category=medium&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/delete-node-in-a-bst/

// Time Complexity: O(H) where H = log N avg, N worst
// Space Complexity: O(H) recursion stack or O(1) iterative
class Solution {
    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null)
            return null;

        if (val < root.data) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.data) {
            root.right = deleteNode(root.right, val);
        } else {
            // equals

            // no children
            if (root.left == null && root.right == null) {
                return null;
            }

            // 1 child
            if (root.left == null || root.right == null) {
                return root.left != null ? root.left : root.right;
            }

            // 2 children
            root.data = inorderSuccessor(root);

            root.right = deleteNode(root.right, root.data);
        }

        return root;
    }

    // smallest from right subtree
    private int inorderSuccessor(TreeNode root) {
        if (root == null)
            return -1;
        int ans = root.data;

        TreeNode curr = root.right;

        while (curr != null) {
            ans = curr.data;
            curr = curr.left;
        }

        return ans;

    }
}

public class DeleteNodeInBST {
    public static void main(String[] args) {

    }
}
