package BinarySearchTrees.Easy.FindMinAndMaxInBST;
import java.util.ArrayList;
import java.util.List;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/minimum-and-maximum-in-bst?category=theory-and-basics&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(n)
class Solution_Inorder {
    public int[] findMinMax(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findInorder(root, list);

        int[] res = new int[2];

        res[0] = list.get(0);
        res[1] = list.get(list.size() - 1);

        return res;
    }

    private void findInorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        findInorder(root.left, list);

        list.add(root.val);

        findInorder(root.right, list);
    }
}

// Time Complexity: O(logn)
class Solution_optimal {
    public int[] findMinMax(TreeNode root) {
        int minValue = findMinValue(root);
        int maxValue = findMaxValue(root);

        return new int[] { minValue, maxValue };
    }

    private int findMinValue(TreeNode root) {
        int minValue = -1;

        TreeNode curr = root;
        while (curr != null) {
            minValue = curr.val;
            curr = curr.left;
        }

        return minValue;
    }

    private int findMaxValue(TreeNode root) {
        int maxValue = -1;

        TreeNode curr = root;
        while (curr != null) {
            maxValue = curr.val;
            curr = curr.right;
        }

        return maxValue;
    }
}

public class FindMinAndMaxInBST {
    public static void main(String[] args) {

    }
}
