package Graphs.Hard.CheapestFlightsWithKStops;
// https://takeuforward.org/practice/dsa/cheapest-flight-within-k-stops?category=shortest-path-algorithms&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(K * E) using BFS / modified Bellman-Ford
// Space Complexity: O(V) for prices array
class Solution {
    public int CheapestFlight(int n, int[][] flights,
            int src, int dst, int K) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : flights) {
            adj.get(e[0]).add(new int[] { e[1], e[2] });
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        // {stops, distance, node}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0, src });

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int stops = curr[0];
            int d = curr[1];
            int node = curr[2];

            if (stops > K) {
                continue;
            }

            for (int[] edge : adj.get(node)) {
                int v = edge[0];
                int wt = edge[1];

                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    q.offer(new int[] { stops + 1, dist[v], v });
                }
            }
        }

        return dist[dst] == (int) 1e9 ? -1 : dist[dst];
    }
}

public class CheapestFlightsWithKStops {
    public static void main(String[] args) {

    }
}
