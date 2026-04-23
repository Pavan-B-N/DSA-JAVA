package BinaryTrees.Medium.PrePostInOrderInOneTraversal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/pre%2C-post%2C-inorder-in-one-traversal?category=theory-and-traversals&source=strivers-a2z-dsa-sheet

class NodeState {
    TreeNode node;
    int state;

    NodeState(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(H) stack storing Pair(node, state)
class Solution {
    public List<List<Integer>> treeTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null)
            return Arrays.asList(in, pre, post);

        Stack<NodeState> st = new Stack<>();

        st.push(new NodeState(root, 1));

        while (!st.isEmpty()) {
            NodeState top = st.pop();
            TreeNode node = top.node;
            int state = top.state;

            if (state == 1) {
                pre.add(node.data);
                st.push(new NodeState(node, 2));

                if (node.left != null) {
                    st.push(new NodeState(node.left, 1));
                }
            } else if (state == 2) {
                in.add(node.data);
                st.push(new NodeState(node, 3));

                if (node.right != null) {
                    st.push(new NodeState(node.right, 1));
                }
            } else {
                post.add(node.data);
            }
        }

        return Arrays.asList(in, pre, post);
    }
}

public class PrePostInOrderInOneTraversal {
    public static void main(String[] args) {

    }
}
