package Graphs.Easy.NumberOfProvinces;
// https://takeuforward.org/practice/dsa/number-of-provinces?category=traversal-problems&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/number-of-provinces/

// Time Complexity: O(V + E)
// Space Complexity: O(V) for visited array / DSU
class Solution {
    public int numProvinces(int[][] adj) {
        int provinces = 0;

        boolean[] visited = new boolean[adj.length];

        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int node, int[][] adj, boolean[] visited) {
        visited[node] = true;

        for (int neighbor = 0; neighbor < adj.length; neighbor++) {
            if (adj[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}

public class NumberOfProvinces {
    public static void main(String[] args) {

    }
}
