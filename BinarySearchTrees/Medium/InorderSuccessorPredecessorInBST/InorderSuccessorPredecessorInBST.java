package BinarySearchTrees.Medium.InorderSuccessorPredecessorInBST;
import java.util.ArrayList;
import java.util.List;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/inorder-successor-and-predecessor-in-bst?category=medium&source=strivers-a2z-dsa-sheet

// Time Complexity: O(H)
// Space Complexity: O(1)
class Solution {
    List<Integer> succPredBST(TreeNode root, int key) {
        List<Integer> list = new ArrayList<>();

        list.add(-1);
        list.add(-1);

        dfs(root, key, list);

        return list;

    }

    private void dfs(TreeNode root, int key, List<Integer> list) {
        if (root == null)
            return;

        if (key < root.data) {
            list.set(1, root.data);
            dfs(root.left, key, list);
        } else if (key > root.data) {
            list.set(0, root.data);
            dfs(root.right, key, list);
        } else {
            // find predecessor = maxElement from left subtree
            TreeNode curr = root.left;

            while (curr != null) {
                list.set(0, curr.data);
                curr = curr.right;
            }

            // find successfor = minElement from right subtree
            curr = root.right;

            while (curr != null) {
                list.set(1, curr.data);
                curr = curr.left;
            }
        }

    }
}

public class InorderSuccessorPredecessorInBST {
    public static void main(String[] args) {

    }
}
