package BinaryTrees.Easy.IsSymmetric;
import BinaryTrees.TreeNode;

// https://leetcode.com/problems/symmetric-tree/description/
// https://takeuforward.org/practice/dsa/check-for-symmetrical-bts?category=medium-problems&source=strivers-a2z-dsa-sheet


// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode p,TreeNode q) {
        if(p==null || q==null) return p==q;

        return p.val == q.val && isSymmetric(p.left,q.right) && isSymmetric(p.right,q.left);
    }
}

public class IsSymmetric {
    public static void main(String[] args) {
        
    }
}
