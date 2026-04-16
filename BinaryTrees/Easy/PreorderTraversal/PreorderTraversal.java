package BinaryTrees.Easy.PreorderTraversal;
import java.util.ArrayList;
import java.util.List;

import BinaryTrees.TreeNode;

// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
// https://takeuforward.org/practice/dsa/preorder-traversal?category=theory-and-traversals&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack / explicit stack
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
}

public class PreorderTraversal {
    public static void main(String[] args) {

    }
}
