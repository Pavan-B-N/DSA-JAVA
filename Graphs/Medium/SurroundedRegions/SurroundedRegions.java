package Graphs.Medium.SurroundedRegions;
// https://takeuforward.org/practice/dsa/surrounded-regions?category=traversal-problems&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/surrounded-regions/description/

// Time Complexity: O(N * M)
// Space Complexity: O(N * M) recursion stack / queue
class Solution {
    public char[][] fill(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];

        // top & bottom
        for (int j = 0; j < n; j++) {
            if (mat[0][j] == 'O' && !visited[0][j]) {
                dfs(0, j, mat, visited);
            }

            if (mat[m - 1][j] == 'O' && !visited[m - 1][j]) {
                dfs(m - 1, j, mat, visited);
            }
        }

        // left & right\
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, mat, visited);
            }

            if (mat[i][n - 1] == 'O' && !visited[i][n - 1]) {
                dfs(i, n - 1, mat, visited);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 'O' && !visited[i][j]) {
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }

    private void dfs(int row, int col, char[][] mat, boolean[][] visited) {
        visited[row][col] = true;

        int[] rowNbr = { -1, 0, 1, 0 };
        int[] colNbr = { 0, 1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int drow = row + rowNbr[k];
            int dcol = col + colNbr[k];

            if (isValid(drow, dcol, mat, visited)) {
                dfs(drow, dcol, mat, visited);
            }
        }
    }

    private boolean isValid(int row, int col, char[][] mat, boolean[][] visited) {
        int m = mat.length;
        int n = mat[0].length;

        return row >= 0 && row < m && col >= 0 && col < n && mat[row][col] == 'O' && !visited[row][col];
    }
}

public class SurroundedRegions {
    public static void main(String[] args) {

    }
}
