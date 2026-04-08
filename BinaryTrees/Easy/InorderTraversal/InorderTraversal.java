package BinaryTrees.Easy.InorderTraversal;
import java.util.ArrayList;
import java.util.List;
import BinaryTrees.TreeNode;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
// https://takeuforward.org/practice/dsa/inorder-traversal?category=theory-and-traversals&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack / explicit stack
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        inorder(root, res);

        return res;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);

        list.add(root.val);

        inorder(root.right, list);
    }
}

public class InorderTraversal {
    public static void main(String[] args) {
        
    }
}
