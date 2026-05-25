package Graphs.Hard.ShortestPathInUnitWeightedGraph;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

// https://takeuforward.org/practice/dsa/shortest-path-in-undirected-graph-with-unit-weights?category=hard-problems&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(V + 2E) - BFS
// Space Complexity: O(V) for distance array and queue
class Solution {
    public int[] shortestPath(int[][] edges, int N, int M) {
        // N = vertices
        // M edges
        // edge = [u,v]

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(0);

        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);

        dist[0] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (dist[node] == 1e9) {
                continue;
            }

            for (int neighbor : adj.get(node)) {
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}

public class ShortestPathInUnitWeightedGraph {
    public static void main(String[] args) {

    }
}
