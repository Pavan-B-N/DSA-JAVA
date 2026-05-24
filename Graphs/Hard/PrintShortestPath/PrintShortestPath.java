package Graphs.Hard.PrintShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// https://takeuforward.org/practice/dsa/print-shortest-path-?category=shortest-path-algorithms&source=strivers-a2z-dsa-sheet&tab=problem

// Time Complexity: O(E log V) using Dijkstra
// Space Complexity: O(V) for distance and parent arrays
class Solution {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        Arrays.fill(dist, (int) 1e9);

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // {dist,nod}
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));

        pq.offer(new Pair(0, 1));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Pair pr = pq.poll();
            int distance = pr.first;
            int node = pr.second;

            for (Pair it : adj.get(node)) {
                int neighbor = it.first;
                int weight = it.second;

                if (distance + weight < dist[neighbor]) {
                    dist[neighbor] = distance + weight;

                    pq.offer(new Pair(dist[neighbor], neighbor));
                    parent[neighbor] = node;
                }
            }
        }

        if (dist[n] == (int) 1e9) {
            return new ArrayList<>(List.of(-1));
        }

        List<Integer> path = new ArrayList<>();

        int currNode = n;

        while (parent[currNode] != currNode) {
            path.add(currNode);
            currNode = parent[currNode];
        }

        path.add(currNode); // or 1

        path.add(dist[n]); // add the shortest path first

        // [shortestDistance, ...path]
        Collections.reverse(path);

        return path;
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

public class PrintShortestPath {
    public static void main(String[] args) {

    }
}
