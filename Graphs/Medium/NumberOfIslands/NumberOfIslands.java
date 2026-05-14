package Graphs.Medium.NumberOfIslands;
// https://takeuforward.org/practice/dsa/number-of-islands?category=traversal-problems&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/number-of-islands/

// Time Complexity: O(N * M)
// Space Complexity: O(N * M) for visited array / queue
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        visited[row][col] = true;

        int[] rowNbr = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] colNbr = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };

        for (int k = 0; k < 8; k++) {
            int drow = row + rowNbr[k];
            int dcol = col + colNbr[k];

            if (isValid(drow, dcol, grid, visited)) {
                dfs(drow, dcol, grid, visited);
            }
        }
    }

    private boolean isValid(int row, int col, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        return row >= 0
                && row < m
                && col >= 0
                && col < n
                && grid[row][col] == '1'
                && !visited[row][col];
    }
}

public class NumberOfIslands {
    public static void main(String[] args) {

    }
}
