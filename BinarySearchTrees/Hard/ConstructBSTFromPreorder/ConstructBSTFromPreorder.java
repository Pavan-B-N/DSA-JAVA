package BinarySearchTrees.Hard.ConstructBSTFromPreorder;
import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/construct-a-bst-from-a-preorder-traversal?category=medium&source=strivers-a2z-dsa-sheet&tab=problem

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack with upper bound check
class Solution {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] preorder, int upperBound) {
        if (index == preorder.length || preorder[index] > upperBound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);

        root.left = bstFromPreorder(preorder, root.data);
        root.right = bstFromPreorder(preorder, upperBound);

        return root;
    }
}

public class ConstructBSTFromPreorder {
    public static void main(String[] args) {

    }
}
