package Graphs.Medium.NumberOfEnclaves;
// https://takeuforward.org/practice/dsa/number-of-enclaves?category=traversal-problems&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/number-of-enclaves/

// Time Complexity: O(N * M)
// Space Complexity: O(N * M) for queue and visited matrix
class Solution {
    public int numberOfEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // top & bottom boundry traversal
        for (int j = 0; j < n; j++) {
            // top row
            if (grid[0][j] == 1 && !visited[0][j])
                dfs(0, j, grid, visited);

            // bottom row
            if (grid[m - 1][j] == 1 && !visited[m - 1][j])
                dfs(m - 1, j, grid, visited);
        }

        // left & right boundry traversal
        for (int i = 0; i < m; i++) {
            // left col
            if (grid[i][0] == 1 && !visited[i][0])
                dfs(i, 0, grid, visited);

            // right col
            if (grid[i][n - 1] == 1 && !visited[i][n - 1])
                dfs(i, n - 1, grid, visited);
        }

        int enclaves = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }

        return enclaves;
    }

    private void dfs(int row, int col, int[][] grid, boolean[][] visited) {
        visited[row][col] = true;

        int[] rowNbr = new int[] { -1, 0, 1, 0 };
        int[] colNbr = new int[] { 0, 1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int drow = row + rowNbr[k];
            int dcol = col + colNbr[k];

            if (isValid(drow, dcol, grid, visited)) {
                dfs(drow, dcol, grid, visited);
            }
        }
    }

    private boolean isValid(int row, int col, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1 && !visited[row][col];
    }
}

public class NumberOfEnclaves {
    public static void main(String[] args) {

    }
}
