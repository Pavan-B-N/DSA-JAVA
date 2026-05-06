package BinarySearchTrees.Medium.KthSamllestElementInBST;
import java.util.ArrayDeque;
import java.util.Deque;

import BinaryTrees.TreeNode;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

// Time Complexity: O(H + K)
// Space Complexity: O(H) recursion stack
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        Deque<TreeNode> stack = new ArrayDeque<>();

        addLeftNodes(root, stack);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            k--;

            if (k == 0) {
                return node.val;
            }

            addLeftNodes(node.right, stack);
        }

        return -1;
    }

    private void addLeftNodes(TreeNode root, Deque<TreeNode> stack) {
        TreeNode curr = root;

        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

}

public class KthSamllestElementInBST {
    public static void main(String[] args) {

    }
}
