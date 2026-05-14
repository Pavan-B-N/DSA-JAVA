package Graphs.Medium.ShortestDistanceInBinaryMaze;
// https://takeuforward.org/practice/dsa/shortest-path-with-minimum-effort?category=shortest-path-algorithms&source=strivers-a2z-dsa-sheet&tab=problem

import java.util.*;

// Time Complexity: O(N * M) - BFS
// Space Complexity: O(N * M) for distance matrix and queue
class Solution {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;

        // source == destination
        if (source[0] == destination[0] && source[1] == destination[1])
            return 0;

        // destination is not reachable
        if (grid[destination[0]][destination[1]] == 0)
            return -1;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        // {node:(row,col)}
        Queue<Pair> queue = new ArrayDeque<>();

        queue.offer(new Pair(source[0], source[1]));

        dist[source[0]][source[1]] = 0;

        while (!queue.isEmpty()) {
            Pair pr = queue.poll();
            int row = pr.first;
            int col = pr.second;

            // if

            int[] rowNbr = { -1, 0, 1, 0 };
            int[] colNbr = { 0, 1, 0, -1 };

            for (int k = 0; k < 4; k++) {
                int drow = row + rowNbr[k];
                int dcol = col + colNbr[k];

                if (isSafe(drow, dcol, grid) && dist[row][col] + 1 < dist[drow][dcol]) {
                    dist[drow][dcol] = dist[row][col] + 1;

                    queue.offer(new Pair(drow, dcol));
                }
            }
        }

        return dist[destination[0]][destination[1]] == 1e9 ? -1 : dist[destination[0]][destination[1]];

    }

    private boolean isSafe(int row, int col, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1;
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

public class ShortestDistanceInBinaryMaze {
    public static void main(String[] args) {

    }
}
