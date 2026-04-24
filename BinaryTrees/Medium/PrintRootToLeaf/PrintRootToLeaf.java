package BinaryTrees.Medium.PrintRootToLeaf;
import java.util.ArrayList;
import java.util.List;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/print-root-to-leaf-path-in-bt?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack and path list
class Solution {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        findRootToLeaf(root, path, res);

        return res;
    }

    private void findRootToLeaf(TreeNode root, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        if (isLeaf(root)) {
            res.add(new ArrayList<>(path));
        }

        findRootToLeaf(root.left, path, res);
        findRootToLeaf(root.right, path, res);

        path.remove(path.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}

public class PrintRootToLeaf {
    public static void main(String[] args) {

    }
}
