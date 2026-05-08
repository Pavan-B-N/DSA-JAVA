package Graphs.Easy.ConnectedComponents;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/connected-components?category=theory-and-traversals&source=strivers-a2z-dsa-sheet

// Time Complexity: O(V + E)
// Space Complexity: O(V) for visited array
class Solution {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int components = 0;
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, adj, visited);
            }
        }

        return components;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (Integer v : adj.get(node)) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
}


public class ConnectedComponents {
    public static void main(String[] args) {

    }
}
