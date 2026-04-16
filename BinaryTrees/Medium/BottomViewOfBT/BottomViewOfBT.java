package BinaryTrees.Medium.BottomViewOfBT;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import BinaryTrees.TreeNode;

// https://takeuforward.org/practice/dsa/bottom-view-of-bt?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N log N) using TreeMap or O(N) using BFS with min/max col
// Space Complexity: O(N) for queue and map
class Solution {
    public List<Integer> bottomView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> verticalMap = new TreeMap<>(); // col -> ele

        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, root));

        while (!q.isEmpty()) {

            Pair pr = q.poll();
            int col = pr.col;
            TreeNode node = pr.node;

            verticalMap.put(col, node.data);

            if (node.left != null) {
                q.offer(new Pair(col - 1, node.left));
            }

            if (node.right != null) {
                q.offer(new Pair(col + 1, node.right));
            }
        }

        List<Integer> res = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : verticalMap.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}

class Pair {
    int col;
    TreeNode node;

    public Pair(int col, TreeNode node) {
        this.col = col;
        this.node = node;
    }
}

public class BottomViewOfBT {
    public static void main(String[] args) {

    }
}
