package BinarySearchTrees.Hard.ConstructBSTWithTwoNodesSwapped;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/correct-bst-with-two-nodes-swapped?category=faqs&source=strivers-a2z-dsa-sheet

// Time Complexity: O(NLogn)
// Space Complexity: O(H) recursion stack + O(N) to store inorder
class Solution_Brute {
    int index = 0;

    void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        collectInorder(root, list);

        Collections.sort(list);

        restoreInorder(root, list);
    }

    private void collectInorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        collectInorder(root.left, list);

        list.add(root.data);

        collectInorder(root.right, list);
    }

    private void restoreInorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        restoreInorder(root.left, list);

        root.data = list.get(index++);

        restoreInorder(root.right, list);
    }
}

// Time Complexity: O(N) inorder traversal
// Space Complexity: O(H) recursion stack
/**
 * Definition for a binary tree node. public class TreeNode { int data; TreeNode
 * left; TreeNode
 * right; TreeNode(int val) { data = val; left = null, right = null } }
 */
class Solution {
    TreeNode prev = null;
    TreeNode[] nodes = new TreeNode[3]; // /{first,middle,last}

    void recoverTree(TreeNode root) {
        inorder(root);

        TreeNode first = nodes[0];
        TreeNode middle = nodes[1];
        TreeNode last = nodes[2];

        if (first != null && last != null) {
            swap(first, last);
        } else if (first != null && middle != null) {
            swap(first, middle);
        }
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && prev.data > root.data) {
            if (nodes[0] == null) {
                nodes[0] = prev; // first
                nodes[1] = root; // middle
            } else {
                nodes[2] = root; // last
            }
        }

        prev = root;

        inorder(root.right);
    }
}

public class ConstructBSTWithTwoNodesSwapped {
    public static void main(String[] args) {

    }
}
