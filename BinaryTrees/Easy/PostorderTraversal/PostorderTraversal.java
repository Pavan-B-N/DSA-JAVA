package BinaryTrees.Easy.PostorderTraversal;
import java.util.ArrayList;
import java.util.List;

import BinaryTrees.TreeNode;

// https://leetcode.com/problems/binary-tree-postorder-traversal/description/
// https://takeuforward.org/practice/dsa/postorder-traversal?category=theory-and-traversals&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack / explicit stack
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}

public class PostorderTraversal {
    public static void main(String[] args) {

    }
}
