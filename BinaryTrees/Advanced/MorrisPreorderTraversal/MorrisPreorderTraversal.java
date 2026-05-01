package BinaryTrees.Advanced.MorrisPreorderTraversal;
import java.util.ArrayList;
import java.util.List;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/morris-preorder-traversal-?category=traversal-in-constant-space&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1) threaded binary tree traversal
class Solution {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                preorder.add(cur.data);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    preorder.add(cur.data);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }

        return preorder;
    }
}

public class MorrisPreorderTraversal {
    public static void main(String[] args) {

    }
}
