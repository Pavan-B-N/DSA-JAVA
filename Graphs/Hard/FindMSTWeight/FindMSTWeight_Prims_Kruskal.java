package Graphs.Hard.FindMSTWeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Time Complexity: O(E log E) - Kruskal's Algorithm with Disjoint Set
// Space Complexity: O(V) for Disjoint Set parent and rank
class Solution_Prims {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0]));

        boolean[] visited = new boolean[V];

        pq.offer(new int[] { 0, 0 });

        int sum = 0;

        while (!pq.isEmpty()) {
            int[] p = pq.poll();

            int wt = p[0];
            int node = p[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            sum += wt;

            for (List<Integer> it : adj.get(node)) {
                int adjNode = it.get(0);
                int edgeWt = it.get(1);

                if (!visited[adjNode]) {
                    pq.offer(new int[] { edgeWt, adjNode });
                }
            }
        }

        return sum;
    }
}

// Time Complexity: O(E log E) - Kruskal's Algorithm with Disjoint Set
// Space Complexity: O(V) for Disjoint Set parent and rank
class Solution {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        // {wt,u,v}
        List<List<Integer>> edges = new ArrayList<>();

        for (int u = 0; u < V; u++) {
            for (List<Integer> edge : adj.get(u)) {
                int v = edge.get(0);
                int wt = edge.get(1);

                edges.add(new ArrayList<>(List.of(wt, u, v)));
            }
        }

        Collections.sort(edges, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        DSU dsu = new DSU(V);

        int sum = 0;

        for (List<Integer> edge : edges) {
            int wt = edge.get(0);
            int u = edge.get(1);
            int v = edge.get(2);

            if (dsu.findUlParent(u) != dsu.findUlParent(v)) {
                sum += wt;

                dsu.unionBySize(u, v);
            }
        }

        return sum;
    }
}

class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.fill(size, 1);
    }

    public int findUlParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        return parent[node] = findUlParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUlParent(u);
        int ulp_v = findUlParent(v);

        if (ulp_u == ulp_v)
            return;

        // connet smaller one to bigger one
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

public class FindMSTWeight_Prims_Kruskal {
    public static void main(String[] args) {

    }
}
