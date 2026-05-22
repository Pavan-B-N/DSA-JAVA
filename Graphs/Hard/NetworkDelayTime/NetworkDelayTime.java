package Graphs.Hard.NetworkDelayTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://takeuforward.org/practice/dsa/network-delay-time?category=shortest-path-algorithms&source=strivers-a2z-dsa-sheet

// Time Complexity: O(E log V) using Dijkstra
// Space Complexity: O(V) for distance array and priority queue

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
        }

        // {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);

        dist[k] = 0;
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int d = curr[0];
            int u = curr[1];

            if (d > dist[u]) {
                continue;
            }

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int wt = edge[1];

                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9) {
                return -1;
            }

            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}

public class NetworkDelayTime {
    public static void main(String[] args) {

    }
}
