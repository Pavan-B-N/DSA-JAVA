package Recursion_and_Backtracking.Hard.RatInMaze;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/rat-in-a-maze?category=faqs-hard&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(4^(N^2))
// Space Complexity: O(N^2) recursion stack and path matrix
class Solution {
    public List<String> findPath(int[][] grid) {

        int n = grid.length;
        if (grid[0][0] == 0 || grid[n - 1][n - 1] == 0)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        findPaths(0, 0, grid, visited, "", res);

        return res;
    }

    private void findPaths(
            int row, int col, int[][] grid, boolean[][] visited, String path, List<String> res) {
        int n = grid.length;
        if (row == n - 1 && col == n - 1) {
            res.add(path);
            return;
        }

        visited[row][col] = true;

        int[] rowNbr = { -1, 0, 1, 0 };
        int[] colNbr = { 0, 1, 0, -1 };
        char[] dir = { 'U', 'R', 'D', 'L' };

        for (int k = 0; k < 4; k++) {
            int drow = row + rowNbr[k];
            int dcol = col + colNbr[k];

            if (isSafe(drow, dcol, grid, visited)) {
                findPaths(drow, dcol, grid, visited, path + dir[k], res);
            }
        }

        visited[row][col] = false;
    }

    private boolean isSafe(int row, int col, int[][] grid, boolean[][] visited) {
        int n = grid.length;

        return row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 1 && !visited[row][col];
    }
}

public class RatInMaze {
    public static void main(String[] args) {

    }
}
