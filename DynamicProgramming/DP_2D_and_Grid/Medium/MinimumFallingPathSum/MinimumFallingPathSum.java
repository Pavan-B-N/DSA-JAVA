package DynamicProgramming.DP_2D_and_Grid.Medium.MinimumFallingPathSum;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/minimum-falling-path-sum?category=dp-on-grids&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/minimum-falling-path-sum/description/

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int minPathSum = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            int sum = helper(m - 1, j, matrix);

            minPathSum = Math.min(minPathSum, sum);
        }

        return minPathSum;
    }

    private int helper(int i, int j, int[][] matrix) {
        int n = matrix[0].length;

        if (i < 0 || j < 0 || j >= n) {
            return (int) 1e9;
        }

        if (i == 0) {
            return matrix[i][j];
        }

        int top = helper(i - 1, j, matrix);
        int topLeft = helper(i - 1, j - 1, matrix);
        int topRight = helper(i - 1, j + 1, matrix);

        return matrix[i][j] + Math.min(Math.min(top, topLeft), topRight);

    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int minPathSum = Integer.MAX_VALUE;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int j = 0; j < n; j++) {
            int sum = helper(m - 1, j, matrix, dp);

            minPathSum = Math.min(minPathSum, sum);
        }

        return minPathSum;
    }

    private int helper(int i, int j, int[][] matrix, int[][] dp) {
        int n = matrix[0].length;

        if (i < 0 || j < 0 || j >= n) {
            return (int) 1e9;
        }

        if (i == 0) {
            return matrix[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int top = helper(i - 1, j, matrix, dp);
        int topLeft = helper(i - 1, j - 1, matrix, dp);
        int topRight = helper(i - 1, j + 1, matrix, dp);

        return dp[i][j] = matrix[i][j] + Math.min(Math.min(top, topLeft), topRight);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        // base case
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = dp[i - 1][j];

                int topLeft = (int) 1e9;

                if (j >= 1)
                    topLeft = dp[i - 1][j - 1];

                int topRight = (int) 1e9;

                if (j + 1 < n)
                    topRight = dp[i - 1][j + 1];

                dp[i][j] = matrix[i][j] + Math.min(Math.min(top, topLeft), topRight);
            }
        }

        int minPathSum = (int) 1e9;

        for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, dp[m - 1][j]);
        }

        return minPathSum;
    }
}

public class MinimumFallingPathSum {
    public static void main(String[] args) {

    }
}
