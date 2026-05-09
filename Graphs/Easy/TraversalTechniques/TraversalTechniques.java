package Graphs.Easy.TraversalTechniques;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://takeuforward.org/practice/dsa/traversal-techniques?category=theory-and-traversals&source=strivers-a2z-dsa-sheet

// Time Complexity: O(V + E)
// Space Complexity: O(V) for queue and visited array
class Solution {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        List<Integer> res = new ArrayList<>();

        dfsRecursive(0, adj, visited, res);

        return res;

    }

    private void dfsRecursive(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> res) {
        res.add(node);
        visited[node] = true;

        for (int v : adj.get(node)) {
            if (!visited[v]) {
                dfsRecursive(v, adj, visited, res);
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // apply bfs
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[V];

        queue.offer(0);
        visited[0] = true;

        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();

            res.add(u);

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }

        return res;
    }
}

public class TraversalTechniques {
    public static void main(String[] args) {

    }
}
