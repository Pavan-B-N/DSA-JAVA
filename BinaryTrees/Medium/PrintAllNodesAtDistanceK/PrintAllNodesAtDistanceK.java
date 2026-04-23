package BinaryTrees.Medium.PrintAllNodesAtDistanceK;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/print-all-nodes-at-a-distance-of-k-in-bt?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

// Time Complexity: O(N)
// Space Complexity: O(N) for parent mapping and visited set
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null)
            return new ArrayList<>();

        Map<TreeNode, TreeNode> parentNodesMap = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();

        trackParents(root, parentNodesMap);

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);
        visited.add(target);

        while (!queue.isEmpty() && k > 0) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // left
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }

                // right
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }

                // parent or top
                if (parentNodesMap.containsKey(node) && !visited.contains(parentNodesMap.get(node))) {
                    visited.add(parentNodesMap.get(node));
                    queue.offer(parentNodesMap.get(node));
                }
            }

            k--;
        }

        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            res.add(queue.poll().val);
        }

        return res;
    }

    private void trackParents(TreeNode root, Map<TreeNode, TreeNode> parentNodesMap) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
                parentNodesMap.put(node.left, node);
            }
            if (node.right != null) {
                queue.offer(node.right);
                parentNodesMap.put(node.right, node);
            }
        }
    }
}

public class PrintAllNodesAtDistanceK {
    public static void main(String[] args) {

    }
}
