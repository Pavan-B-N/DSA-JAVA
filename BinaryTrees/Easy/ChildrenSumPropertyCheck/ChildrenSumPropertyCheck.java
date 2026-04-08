package BinaryTrees.Easy.ChildrenSumPropertyCheck;
import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/children-sum-property-in-binary-tree?category=medium-problems&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack
class Solution {
    boolean checkChildrenSum(TreeNode root) {
        if (root == null || isLeaf(root))
            return true;

        int sum = 0;
        if (root.left != null)
            sum += root.left.val;
        if (root.right != null)
            sum += root.right.val;

        return root.val == sum && checkChildrenSum(root.left) && checkChildrenSum(root.right);
    }

    boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
}

public class ChildrenSumPropertyCheck {
    public static void main(String[] args) {

    }
}
