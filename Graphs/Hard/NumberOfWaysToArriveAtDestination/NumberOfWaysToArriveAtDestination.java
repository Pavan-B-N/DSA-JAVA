package Graphs.Hard.NumberOfWaysToArriveAtDestination;
// https://takeuforward.org/practice/dsa/number-of-ways-to-arrive-at-destination?category=shortest-path-algorithms&source=strivers-a2z-dsa-sheet

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// Time Complexity: O(E log V) using Dijkstra
// Space Complexity: O(V) for distance and ways arrays
class Solution {
    public int countPaths(int n, List<List<Integer>> roads) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> e : roads) {
            int u = e.get(0);
            int v = e.get(1);
            int wt = e.get(2);

            adj.get(u).add(new int[] { v, wt });
            adj.get(v).add(new int[] { u, wt });
        }

        int MOD = 1_000_000_007;

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        // {distance, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0]));

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new long[] { 0, 0 });

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();

            long d = curr[0];
            int u = (int) curr[1];

            if (d > dist[u]) {
                continue;
            }

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int wt = edge[1];

                long newDist = d + wt;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];

                    pq.offer(new long[] { newDist, v });
                } else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {

    }
}
