package Recursion_and_Backtracking.Hard.MColoringGraph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://takeuforward.org/practice/dsa/m-coloring-problem?category=faqs-hard&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem

// Time Complexity: O(M^V)
// Space Complexity: O(V) for color assignment and recursion stack
class Solution {
    boolean graphColoring(int[][] edges, int m, int n) {
        // N = Vertices, M = Colors Usage Limit
        List<List<Integer>> adj = new ArrayList<>(); // node -> {neighbors}

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // build adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[n];

        Arrays.fill(color, -1);

        return canColor(0, adj, color, m);
    }

    private boolean canColor(int node, List<List<Integer>> adj, int[] color, int M) {
        if (node == adj.size()) {
            return true;
        }

        for (int c = 0; c < M; c++) {
            if (isSafe(node, adj, color, c)) {
                color[node] = c;

                if (canColor(node + 1, adj, color, M)) {
                    return true;
                }

                color[node] = -1;
            }
        }

        return false;
    }

    private boolean isSafe(int node, List<List<Integer>> adj, int[] color, int c) {
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == c) {
                return false;
            }
        }

        return true;
    }
}

public class MColoringGraph {
    public static void main(String[] args) {

    }
}
