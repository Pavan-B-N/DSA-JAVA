package Graphs.Hard.ShortestPathInDAG;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

// https://takeuforward.org/practice/dsa/shortest-path-in-dag?category=hard-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(V + E) - Topological Sort + Relaxation
// Space Complexity: O(V) for distance array and topo stack
class Solution {
    public int[] shortestPath(int N, int M, int[][] edges) {
        // N = Vertices, M = edges
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
        }

        Deque<Integer> stack = new ArrayDeque<>();

        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // declare the dist
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // start relaxation
        while (!stack.isEmpty()) {
            int node = stack.peek();
            stack.pop();

            if (dist[node] == Integer.MAX_VALUE) {
                continue;
            }

            for (Pair pr : adj.get(node)) {
                int neighbor = pr.node;
                int wt = pr.weight;

                if (dist[node] + wt < dist[neighbor]) {
                    dist[neighbor] = dist[node] + wt;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    private void dfs(int node, List<List<Pair>> adj, boolean[] visited, Deque<Integer> stack) {
        visited[node] = true;

        for (Pair pr : adj.get(node)) {
            int neighbor = pr.node;

            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }

        stack.push(node);
    }
}

class Pair {
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class ShortestPathInDAG {
    public static void main(String[] args) {

    }
}
