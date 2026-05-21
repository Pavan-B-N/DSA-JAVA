package Graphs.Hard.DisJointSet;
// https://takeuforward.org/practice/dsa/disjoint-set-?category=minimum-spanning-tree&source=strivers-a2z-dsa-sheet

import java.util.Arrays;

// Time Complexity: O(4 * alpha) ~ O(1) per find/union operation
// Space Complexity: O(V) for parent and rank/size arrays
class DisjointSet {
    private int[] size;
    private int[] parent;

    public DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        Arrays.fill(size, 1);

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int findUParent(int node) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findUParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

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

public class DisJointSet {
    public static void main(String[] args) {

    }
}
