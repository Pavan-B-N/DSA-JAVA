package Graphs.Advanced.SwimInRisingWater;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

// https://takeuforward.org/practice/dsa/swim-in-rising-water?category=shortest-path-algorithms&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int maxElev = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxElev = Math.max(maxElev, grid[i][j]);
            }
        }

        for (int t = 0; t <= maxElev; t++) {
            if (canReach(grid, n, t)) {
                return t;
            }
        }

        return maxElev;
    }

    private boolean canReach(int[][] grid, int n, int t) {
        if (grid[0][0] > t) {
            return false;
        }

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { 0, 0 });
        visited[0][0] = true;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            if (r == n - 1 && c == n - 1) {
                return true;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && !visited[nr][nc] && grid[nr][nc] <= t) {
                    visited[nr][nc] = true;
                    q.offer(new int[] { nr, nc });
                }
            }
        }

        return false;
    }
}

// Time Complexity: O(N^2 log N) using Dijkstra or Binary Search
// Space Complexity: O(N^2) for priority queue and visited grid
class Solution_Optimal {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = true;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int cost = top[0];
            int r = top[1];
            int c = top[2];

            if (r == n - 1 && c == n - 1) {
                return cost;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && !visited[nr][nc]) {
                    visited[nr][nc] = true;

                    int newCost = Math.max(cost, grid[nr][nc]);

                    pq.offer(new int[] { newCost, nr, nc });
                }
            }
        }

        return -1;
    }
}

public class SwimInRisingWater {
    public static void main(String[] args) {

    }
}
