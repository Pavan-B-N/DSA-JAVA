package BinaryTrees.Easy.LevelOrderTraversal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import BinaryTrees.TreeNode;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
// https://takeuforward.org/practice/dsa/level-order-traversal?category=theory-and-traversals&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(N) for queue in worst case
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();

                list.add(node.val);

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }

            res.add(list);
        }

        return res;
    }
}

public class LevelOrderTraversal {
    public static void main(String[] args) {

    }
}
