package BinaryTrees.Medium.MaximumWidthOfBT;
import java.util.ArrayDeque;
import java.util.Deque;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/maximum-width-of-bt?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/maximum-width-of-binary-tree/

// Time Complexity: O(N)
// Space Complexity: O(W) for queue where W is maximum tree width
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int first = queue.peekFirst().index;
            int last = queue.peekLast().index;
            int width = last - first + 1;

            maxWidth = Math.max(maxWidth, width);

            for (int i = 0; i < levelSize; i++) {
                Pair pr = queue.poll();
                TreeNode node = pr.node;
                int index = pr.index;

                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * index + 2));
                }
            }
        }

        return maxWidth;
    }
}

class Pair {
    TreeNode node;
    int index;

    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class MaximumWidthOfBT {
    public static void main(String[] args) {

    }
}
