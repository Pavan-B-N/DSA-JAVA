package BinaryTrees.Medium.DiameterOfBT;
import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/diameter-of-binary-tree?category=medium-problems&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem&solution=optimal
// https://leetcode.com/problems/diameter-of-binary-tree/

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int[] arr = new int[1];
        height(root, arr);
        return arr[0];
    }

    private int height(TreeNode root, int[] arr) {
        if (root == null)
            return 0;

        int lh = height(root.left, arr);
        int rh = height(root.right, arr);

        arr[0] = Math.max(arr[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }
}

public class DiameterOfBT {
    public static void main(String[] args) {

    }
}
