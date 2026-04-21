package BinaryTrees.Medium.CountTotalNodesInCompleteBT;
import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/count-total-nodes-in-a-complete-bt?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/count-complete-tree-nodes/

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return 1 + left + right;
    }
}

// Time Complexity: O(logn)
class Solution_Optimal {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if (lh == rh)
            return (1 << lh) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    int leftHeight(TreeNode root) {
        int h = 0;

        while (root != null) {
            h++;
            root = root.left;
        }

        return h;
    }

    int rightHeight(TreeNode root) {
        int h = 0;

        while (root != null) {
            h++;
            root = root.right;
        }

        return h;
    }
}

public class CountTotalNodesInCompleteBT {
    public static void main(String[] args) {

    }
}
