package DynamicProgramming.DP_2D_and_Grid.Medium.GridUniquePaths2;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/unique-paths-ii?category=dp-on-grids&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/unique-paths-ii/

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (matrix[0][0] == 1 || matrix[m - 1][n - 1] == 1)
            return 0;

        return helper(m - 1, n - 1, matrix);
    }

    private int helper(int i, int j, int[][] matrix) {
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0 || matrix[i][j] == 1) {
            return 0;
        }

        int top = helper(i - 1, j, matrix);
        int left = helper(i, j - 1, matrix);

        return top + left;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (matrix[0][0] == 1 || matrix[m - 1][n - 1] == 1)
            return 0;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(m - 1, n - 1, matrix, dp);
    }

    private int helper(int i, int j, int[][] matrix, int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0 || matrix[i][j] == 1) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int top = helper(i - 1, j, matrix, dp);
        int left = helper(i, j - 1, matrix, dp);

        return dp[i][j] = top + left;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (matrix[0][0] == 1 || matrix[m - 1][n - 1] == 1)
            return 0;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}

public class GridUniquePaths2 {
    public static void main(String[] args) {

    }
}
