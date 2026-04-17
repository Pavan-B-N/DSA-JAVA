package BinaryTrees.Medium.BoundryTraversal;
// https://takeuforward.org/practice/dsa/boundary-traversal?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0

import java.util.ArrayList;
import java.util.List;
import BinaryTrees.TreeNode;

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack and boundary list
class Solution {
    public List<Integer> boundary(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        res.add(root.data);

        if (isLeaf(root)) {
            return res;
        }

        addLeftBoundry(root.left, res);
        addLeaves(root, res);
        addRightBoundry(root.right, res);

        return res;
    }

    private void addLeftBoundry(TreeNode root, List<Integer> res) {
        TreeNode curr = root;

        while (curr != null) {
            if (!isLeaf(curr))
                res.add(curr.data);
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addRightBoundry(TreeNode root, List<Integer> res) {
        List<Integer> temp = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {
            if (!isLeaf(curr))
                temp.add(curr.data);
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    private void addLeaves(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}

public class BoundryTraversal {
    public static void main(String[] args) {

    }
}
