package BinarySearchTrees.Medium.TwoSumInBST;
import java.util.ArrayDeque;
import java.util.Deque;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/two-sum-in-bst?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

// Time Complexity: O(N)
// Space Complexity: O(H) using two BST iterators
class Solution {
    Deque<TreeNode> leftStack = new ArrayDeque<>();
    Deque<TreeNode> rightStack = new ArrayDeque<>();

    private void addLeftNodes(TreeNode root) {
        if (root == null)
            return;

        TreeNode curr = root;

        while (curr != null) {
            leftStack.push(curr);
            curr = curr.left;
        }
    }

    private void addRightNodes(TreeNode root) {
        if (root == null)
            return;

        TreeNode curr = root;

        while (curr != null) {
            rightStack.push(curr);
            curr = curr.right;
        }
    }

    private TreeNode next() {
        TreeNode node = leftStack.pop();

        addLeftNodes(node.right);

        return node;
    }

    private TreeNode prev() {
        TreeNode node = rightStack.pop();

        addRightNodes(node.left);

        return node;
    }

    public boolean twoSumBST(TreeNode root, int k) {
        if (root == null)
            return false;

        addLeftNodes(root);
        addRightNodes(root);

        TreeNode left = next();
        TreeNode right = prev();

        while (left != right && left.data <= right.data) {
            int sum = left.data + right.data;

            if (sum == k) {
                return true;
            } else if (sum > k) {
                right = prev();
            } else {
                left = next();
            }
        }

        return false;
    }
}

public class TwoSumInBST {
    public static void main(String[] args) {

    }
}
