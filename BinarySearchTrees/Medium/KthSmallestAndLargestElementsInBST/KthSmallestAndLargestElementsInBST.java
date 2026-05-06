package BinarySearchTrees.Medium.KthSmallestAndLargestElementsInBST;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/kth-smallest-and-largest-element-in-bst?category=medium&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    public List<Integer> kLargesSmall(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        return new ArrayList<>(List.of(list.get(k - 1), list.get(list.size() - k)));
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}

// Time Complexity: O(H + K)
// Space Complexity: O(H) recursion stack
class Solution_Optimal_Recursion {
    int k1;
    int k2;

    public List<Integer> kLargesSmall(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        k1 = k;
        k2 = k;

        res.add(kthSmallest(root));
        res.add(kthLargest(root));

        return res;
    }

    private int kthSmallest(TreeNode root) {
        if (root == null)
            return -1;

        int left = kthSmallest(root.left);

        if (left != -1)
            return left;

        k1--;

        if (k1 == 0) {
            return root.data;
        }

        return kthSmallest(root.right);
    }

    private int kthLargest(TreeNode root) {
        if (root == null)
            return -1;

        int right = kthLargest(root.right);

        if (right != -1)
            return right;

        k2--;

        if (k2 == 0) {
            return root.data;
        }

        return kthLargest(root.left);
    }
}

// Recommended Approach
// Time Complexity: O(H + K)
// Space Complexity: O(H) recursion stack
class Solution_Optimal_Iterative {

    public List<Integer> kLargesSmall(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();

        if (root == null || k <= 0)
            return res;

        res.add(kthSmallest(root, k));
        res.add(kthLargest(root, k));

        return res;
    }

    private void addLeftNodes(TreeNode root, Deque<TreeNode> stack) {
        TreeNode curr = root;

        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    private void addRightNodes(TreeNode root, Deque<TreeNode> stack) {
        TreeNode curr = root;

        while (curr != null) {
            stack.push(curr);
            curr = curr.right;
        }
    }

    private int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        addLeftNodes(root, stack);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            k--;
            if (k == 0)
                return node.data;

            addLeftNodes(node.right, stack);
        }

        return -1;
    }

    private int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        addRightNodes(root, stack);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            k--;
            if (k == 0)
                return node.data;

            addRightNodes(node.left, stack);
        }

        return -1;
    }
}

public class KthSmallestAndLargestElementsInBST {
    public static void main(String[] args) {

    }
}
