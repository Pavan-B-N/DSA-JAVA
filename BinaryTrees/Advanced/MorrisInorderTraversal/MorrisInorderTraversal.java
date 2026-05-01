package BinaryTrees.Advanced.MorrisInorderTraversal;
import java.util.ArrayList;
import java.util.List;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/morris-inorder-traversal-?category=traversal-in-constant-space&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1) threaded binary tree traversal
class Solution {
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.data);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inorder.add(cur.data);
                    cur = cur.right;
                }
            }
        }

        return inorder;
    }
}

public class MorrisInorderTraversal {
    public static void main(String[] args) {

    }
}
