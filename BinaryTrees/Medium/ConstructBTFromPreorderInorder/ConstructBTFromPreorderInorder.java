package BinaryTrees.Medium.ConstructBTFromPreorderInorder;
import java.util.HashMap;
import java.util.Map;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/construct-a-bt-from-preorder-and-inorder?category=construction-problems&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Time Complexity: O(N)
// Space Complexity: O(N) for hash map of inorder indices and recursion stack
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.put(inorder[i], i);
        }

        return buildTree(0, n - 1, 0, n - 1, preorder, inorder, hashMap);
    }

    private TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder,
            Map<Integer, Integer> hashMap) {
        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        int inOrderRootIndex = hashMap.get(rootVal);
        int leftSize = inOrderRootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(preStart + 1, preStart + leftSize, inStart, inOrderRootIndex - 1, preorder, inorder,
                hashMap);
        root.right = buildTree(preStart + leftSize + 1, preEnd, inOrderRootIndex + 1, inEnd, preorder, inorder,
                hashMap);

        return root;

    }
}

public class ConstructBTFromPreorderInorder {
    public static void main(String[] args) {

    }
}
