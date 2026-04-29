package BinaryTrees.Hard.SerializeDeserializeBT;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import BinaryTrees.TreeNode;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// https://takeuforward.org/practice/dsa/serialize-and-de-serialize-bt?category=construction-problems&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem

// Time Complexity: O(N)
// Space Complexity: O(N) for serialized string and queue
class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!sb.isEmpty())
                sb.append(" ");

            if (node == null) {
                sb.append("N");
            } else {
                sb.append(node.val);
                // sb.append(Integer.toString(node.val));

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;

        String[] tokens = data.split(" ");

        Deque<TreeNode> queue = new ArrayDeque<>();

        TreeNode root = new TreeNode(Integer.valueOf(tokens[0]));
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty() && index < tokens.length) {
            TreeNode node = queue.poll();

            // left
            if (index < tokens.length && !tokens[index].equals("N")) {
                node.left = new TreeNode(Integer.valueOf(tokens[index]));
                queue.offer(node.left);
            }

            index++;

            // right
            if (index < tokens.length && !tokens[index].equals("N")) {
                node.right = new TreeNode(Integer.valueOf(tokens[index]));
                queue.offer(node.right);
            }

            index++;
        }

        return root;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for serialized string and queue
public class SerializeDeserializeBT {
    public static void main(String[] args) {

    }
}
