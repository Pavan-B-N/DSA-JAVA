package BinaryTrees.Medium.ZigZagTraversal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import BinaryTrees.TreeNode;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
// https://takeuforward.org/practice/dsa/zig-zag-or-spiral-traversal?category=faqs&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(N) for queue
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int level = 1;

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

            if (level % 2 == 0) {
                Collections.reverse(list);
            }

            res.add(list);

            level++;

        }

        return res;
    }
}

public class ZigZagTraversal {
    public static void main(String[] args) {

    }
}
