package BinarySearchTrees.Medium.FloorAndCeilInBST;
import java.util.ArrayList;
import java.util.List;

import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/floor-and-ceil-in-a-bst?category=theory-and-basics&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem&solution=ceiling

// Time Complexity: O(H) where H = log N avg, N worst
// Space Complexity: O(1)
class Solution {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        List<Integer> res = new ArrayList<>(); // {floor,ceil}

        res.add(-1);
        res.add(-1);

        findFloorCeilOfBST(root, key, res);

        return res;
    }

    private void findFloorCeilOfBST(TreeNode root, int key, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (key < root.data) {
            // ceil
            res.set(1, root.data);
            findFloorCeilOfBST(root.left, key, res);
        } else if (key > root.data) {
            // floor
            res.set(0, root.data);
            findFloorCeilOfBST(root.right, key, res);
        } else {
            res.set(0, root.data);
            res.set(1, root.data);
        }
    }
}

public class FloorAndCeilInBST {
    public static void main(String[] args) {

    }
}
