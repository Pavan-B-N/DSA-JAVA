package BinaryTrees.Medium.VerticalOrderTraversal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import BinaryTrees.TreeNode;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// https://takeuforward.org/practice/dsa/vertical-order-traversal?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N log N) using TreeMap or O(N) using column indexing
// Space Complexity: O(N) for coordinate mapping
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> verticalMap = new TreeMap<>();// col -> list[elements]

        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, root));

        while (!q.isEmpty()) {
            int levelSize = q.size();

            Map<Integer, List<Integer>> levelMap = new HashMap<>();

            for (int i = 0; i < levelSize; i++) {
                Pair pr = q.poll();
                int col = pr.col;
                TreeNode node = pr.node;

                levelMap.computeIfAbsent(col, k -> new ArrayList<>())
                        .add(node.val);

                if (node.left != null) {
                    q.offer(new Pair(col - 1, node.left));
                }

                if (node.right != null) {
                    q.offer(new Pair(col + 1, node.right));
                }
            }

            for (Map.Entry<Integer, List<Integer>> entry : levelMap.entrySet()) {
                int col = entry.getKey();
                List<Integer> list = entry.getValue();

                Collections.sort(list);

                verticalMap.computeIfAbsent(col, k -> new ArrayList<>())
                        .addAll(list);

            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : verticalMap.entrySet()) {
            List<Integer> list = entry.getValue();

            res.add(list);
        }

        return res;

    }
}

class Pair {
    public int col;
    public TreeNode node;

    public Pair(int col, TreeNode node) {
        this.col = col;
        this.node = node;
    }
}

public class VerticalOrderTraversal {
    public static void main(String[] args) {

    }
}
