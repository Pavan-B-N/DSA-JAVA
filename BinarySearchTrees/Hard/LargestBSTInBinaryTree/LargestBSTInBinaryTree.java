package BinarySearchTrees.Hard.LargestBSTInBinaryTree;
import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/largest-bst-in-binary-tree?category=faqs&source=strivers-a2z-dsa-sheet

class NodeVal {
    int upper_bound, lower_bound, maxLen;

    NodeVal(int ub, int lb, int len) {
        upper_bound = ub;
        lower_bound = lb;
        maxLen = len;
    }
}

// Time Complexity: O(N) postorder traversal
// Space Complexity: O(H) recursion stack
class Solution {
    public int largestBST(TreeNode root) {
        return helper(root).maxLen;
    }

    private NodeVal helper(TreeNode root) {
        if (root == null) {
            return new NodeVal(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        NodeVal left = helper(root.left);
        NodeVal right = helper(root.right);

        if (left.upper_bound < root.data && root.data < right.lower_bound) {
            return new NodeVal(
                    Math.max(right.upper_bound, root.data),
                    Math.min(left.lower_bound, root.data),
                    1 + left.maxLen + right.maxLen);
        }

        return new NodeVal(
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                Math.max(left.maxLen, right.maxLen));
    }
}

public class LargestBSTInBinaryTree {
    public static void main(String[] args) {

    }
}
