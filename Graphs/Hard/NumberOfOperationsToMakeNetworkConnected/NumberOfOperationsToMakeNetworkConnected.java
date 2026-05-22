package Graphs.Hard.NumberOfOperationsToMakeNetworkConnected;
// https://takeuforward.org/practice/dsa/number-of-operations-to-make-network-connected?category=hard-problems-ii&source=strivers-a2z-dsa-sheet

import java.util.Arrays;

// Time Complexity: O(V + E) using Disjoint Set
// Space Complexity: O(V) for parent and rank arrays
class Solution {
    public int solve(int n, int[][] edges) {
        int extraEdges = 0;

        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (dsu.findUlParent(u) == dsu.findUlParent(v)) {
                extraEdges++;
            } else {
                dsu.unionBySize(u, v);
            }
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (dsu.findUlParent(i) == i)
                components++;
        }

        if (extraEdges < components - 1) {
            return -1;
        }

        return extraEdges;
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

public class NumberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {

    }
}
