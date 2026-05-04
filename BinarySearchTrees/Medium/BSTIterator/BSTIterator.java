package BinarySearchTrees.Medium.BSTIterator;
import java.util.ArrayDeque;
import java.util.Deque;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/bst-iterator?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/binary-search-tree-iterator/

// Time Complexity: Amortized O(1) per next/hasNext
// Space Complexity: O(H) for explicit stack
class BSTIterator_Solution {
    Deque<TreeNode> stack = new ArrayDeque<>();

    private void addLeftNodes(TreeNode root) {
        if (root == null)
            return;

        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    public BSTIterator_Solution(TreeNode root) {
        addLeftNodes(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();

        addLeftNodes(node.right);

        return node.data;
    }
}

// Time Complexity: Amortized O(1) per next/hasNext
// Space Complexity: O(H) for explicit stack
public class BSTIterator {
    public static void main(String[] args) {

    }
}
