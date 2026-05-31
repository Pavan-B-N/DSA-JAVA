package Graphs.Advanced.NumberOfIslands2;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/number-of-islands-ii?category=hard-problems-ii&source=strivers-a2z-dsa-sheet

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

    void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        } else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
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

// Time Complexity: O(K * alpha) using Disjoint Set where K = number of queries
// Space Complexity: O(N * M) for parent array
class Solution {
    int[] delRow = { -1, 0, 1, 0 };
    int[] delCol = { 0, 1, 0, -1 };

    boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public List<Integer> numOfIslands(int n, int m, int[][] A) {
        DisjointSet ds = new DisjointSet(n * m);

        int[][] vis = new int[n][m];
        int cnt = 0;

        List<Integer> ans = new ArrayList<>();

        for (int[] it : A) {
            int row = it[0];
            int col = it[1];

            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }

            vis[row][col] = 1;
            cnt++;

            for (int ind = 0; ind < 4; ind++) {
                int newRow = row + delRow[ind];
                int newCol = col + delCol[ind];

                if (isValid(newRow, newCol, n, m)
                        && vis[newRow][newCol] == 1) {

                    int nodeNo = row * m + col;
                    int adjNodeNo = newRow * m + newCol;

                    if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                        cnt--;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }

            ans.add(cnt);
        }

        return ans;
    }
}

public class NumberOfIslands2 {
    public static void main(String[] args) {

    }
}
