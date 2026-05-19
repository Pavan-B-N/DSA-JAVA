package Graphs.Hard.BellmanFordAlgorithm;
// https://takeuforward.org/practice/dsa/bellman-ford-algorithm?category=shortest-path-algorithms&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(V * E)
// Space Complexity: O(V) for distance array
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        dist[S] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);

                if (dist[u] != (int) 1e9 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);

            if (dist[u] != (int) 1e9 && dist[u] + wt < dist[v]) {
                return new int[] { -1 };
            }
        }

        return dist;
    }
}

public class BellmanFordAlgorithm {
    public static void main(String[] args) {

    }
}
