package BinaryTrees.Medium.ConstructBTFromPostorderInorder;
import java.util.HashMap;
import java.util.Map;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/construct-a-bt-from-postorder-and-inorder?category=construction-problems&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

// Time Complexity: O(N)
// Space Complexity: O(N) for hash map of inorder indices and recursion stack
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.put(inorder[i], i);
        }

        return buildTree(0, n - 1, 0, n - 1, postorder, inorder, hashMap);
    }

    private TreeNode buildTree(int postStart, int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder,
            Map<Integer, Integer> hashMap) {
        if (postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        int inOrderRootIndex = hashMap.get(rootVal);
        int leftSize = inOrderRootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(postStart, postStart + leftSize - 1, inStart, inOrderRootIndex - 1, postorder, inorder,
                hashMap);

        root.right = buildTree(postStart + leftSize, postEnd - 1, inOrderRootIndex + 1, inEnd, postorder, inorder,
                hashMap);

        return root;

    }
}

public class ConstructBTFromPostorderInorder {
    public static void main(String[] args) {

    }
}
