package BinaryTrees;
public class TreeNode {
    public int val;
    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
        this.data = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
