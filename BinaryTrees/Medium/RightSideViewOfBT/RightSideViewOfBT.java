package BinaryTrees.Medium.RightSideViewOfBT;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import BinaryTrees.TreeNode;

// https://leetcode.com/problems/binary-tree-right-side-view/description/
// https://takeuforward.org/practice/dsa/right-left-view-of-bt?category=faqs&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(H) recursion stack
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            res.add(q.peekLast().val);

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }

            }
        }

        return res;
    }
}

public class RightSideViewOfBT {
    public static void main(String[] args) {

    }
}
