package BinaryTrees.Easy.IsSameTree;
import BinaryTrees.TreeNode;

// https://leetcode.com/problems/same-tree/description/
// https://takeuforward.org/practice/dsa/check-if-two-trees-are-identical-or-not?category=medium-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(min(N1, N2))
// Space Complexity: O(min(H1, H2)) recursion stack
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

public class IsSameTree {
    public static void main(String[] args) {

    }
}
