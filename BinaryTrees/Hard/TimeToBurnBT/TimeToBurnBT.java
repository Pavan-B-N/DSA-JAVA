package BinaryTrees.Hard.TimeToBurnBT;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/minimum-time-taken-to-burn-the-bt-from-a-given-node?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/

// Time Complexity: O(N)
// Space Complexity: O(N) for parent mapping, queue and visited set
class Solution {
    public int timeToBurnTree(TreeNode root, int target) {
        TreeNode targetNode = search(root, target);

        Map<TreeNode, TreeNode> parentNodesMap = new HashMap<>();
        trackParents(root, parentNodesMap);

        Set<TreeNode> visited = new HashSet<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean burn = false;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // left
                if (node.left != null && !visited.contains(node.left)) {
                    burn = true;
                    visited.add(node.left);
                    queue.offer(node.left);
                }

                // right
                if (node.right != null && !visited.contains(node.right)) {
                    burn = true;
                    visited.add(node.right);
                    queue.offer(node.right);
                }

                // parent or top
                if (parentNodesMap.containsKey(node) && !visited.contains(parentNodesMap.get(node))) {
                    burn = true;
                    visited.add(parentNodesMap.get(node));
                    queue.offer(parentNodesMap.get(node));
                }
            }

            if (burn) {
                time++;
            }
        }

        return time;
    }

    private TreeNode search(TreeNode root, int target) {
        if (root == null)
            return null;

        if (root.data == target) {
            return root;
        }

        TreeNode left = search(root.left, target);
        TreeNode right = search(root.right, target);

        return left != null ? left : right;
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

public class TimeToBurnBT {
    public static void main(String[] args) {

    }
}
