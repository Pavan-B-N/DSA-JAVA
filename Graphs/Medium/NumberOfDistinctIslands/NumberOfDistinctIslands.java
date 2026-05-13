package Graphs.Medium.NumberOfDistinctIslands;
import java.util.HashSet;
import java.util.Set;

// https://takeuforward.org/practice/dsa/number-of-distinct-islands?category=traversal-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N * M)
// Space Complexity: O(N * M) for HashSet of shapes
class Solution {
    public int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Set<String> shapesSet = new HashSet<>();

        boolean[][] visited = new boolean[m][n];

        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder shape = new StringBuilder();

                    dfs(i, j, shape, i, j, grid, visited);

                    if (!shapesSet.contains(shape.toString())) {
                        shapesSet.add(shape.toString());
                        islands++;
                    }
                }
            }
        }

        return islands;
    }

    private void dfs(
            int row,
            int col,
            StringBuilder shape,
            final int baseRow,
            final int baseCol,
            int[][] grid,
            boolean[][] visited) {

        visited[row][col] = true;
        shape.append((row - baseRow) + "," + (col - baseCol) + " ");

        int rowNbr[] = { -1, 0, 1, 0 };
        int colNbr[] = { 0, 1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int drow = row + rowNbr[k];
            int dcol = col + colNbr[k];

            if (isValid(drow, dcol, grid, visited)) {
                dfs(drow, dcol, shape, baseRow, baseCol, grid, visited);
            }
        }
    }

    private boolean isValid(int row, int col, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1 && !visited[row][col];
    }
}

public class NumberOfDistinctIslands {
    public static void main(String[] args) {

    }
}
