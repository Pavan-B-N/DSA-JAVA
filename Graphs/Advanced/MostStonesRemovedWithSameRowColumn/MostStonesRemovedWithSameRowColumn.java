package Graphs.Advanced.MostStonesRemovedWithSameRowColumn;
// https://takeuforward.org/practice/dsa/most-stones-removed-with-same-row-or-column?category=hard-problems-ii&source=strivers-a2z-dsa-sheet&tab=problem

import java.util.*;

class DisjointSet {
    int[] rank, parent, size;

    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUPar(parent[node]);
    }

    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

// Time Complexity: O(N * alpha) using Disjoint Set
// Space Complexity: O(N) for Disjoint Set map
class Solution {
    public int maxRemove(int[][] stones, int n) {
        int maxRow = 0;
        int maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Set<Integer> stoneNodes = new HashSet<>();

        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;

            ds.unionBySize(nodeRow, nodeCol);

            stoneNodes.add(nodeRow);
            stoneNodes.add(nodeCol);
        }

        int components = 0;

        for (int node : stoneNodes) {
            if (ds.findUPar(node) == node) {
                components++;
            }
        }

        return n - components;
    }
}

public class MostStonesRemovedWithSameRowColumn {
    public static void main(String[] args) {

    }
}
