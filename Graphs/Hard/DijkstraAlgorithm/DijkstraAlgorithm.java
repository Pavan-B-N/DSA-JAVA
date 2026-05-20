package Graphs.Hard.DijkstraAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://takeuforward.org/practice/dsa/dijkstra's-algorithm?category=shortest-path-algorithms&source=strivers-a2z-dsa-sheet

// Time Complexity: O(E log V) using PriorityQueue
// Space Complexity: O(V) for distance array and min-heap
class Solution {
    public int[] dijkstra(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // build adjacency list
        // [u] -> [ {v,wt} ]

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (var edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        int[] distance = new int[V];
        Arrays.fill(distance, (int) 1e9);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
        // {distance, node}

        pq.offer(new Pair(0, S));
        distance[S] = 0;

        while (!pq.isEmpty()) {
            Pair pr = pq.poll();

            int dist = pr.first;
            int node = pr.second;

            for (Pair it : adj.get(node)) {
                int neighbor = it.first;
                int weight = it.second;

                if (dist + weight < distance[neighbor]) {
                    distance[neighbor] = dist + weight;

                    pq.offer(new Pair(distance[neighbor], neighbor));
                }
            }
        }

        return distance;
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class DijkstraAlgorithm {
    public static void main(String[] args) {

    }
}
