package DynamicProgramming.DP_2D_and_Grid.Medium.GridUniquePaths;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/grid-unique-paths?category=dp-on-grids&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/unique-paths/

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int uniquePaths(int m, int n) {
        return helper(m - 1, n - 1);
    }

    private int helper(int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        int top = helper(i - 1, j);
        int left = helper(i, j - 1);

        return top + left;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(m - 1, n - 1, dp);
    }

    private int helper(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int top = helper(i - 1, j, dp);
        int left = helper(i, j - 1, dp);

        return dp[i][j] = top + left;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int uniquePaths(int m, int n) {
        // applying shift index technique
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}

public class GridUniquePaths {
    public static void main(String[] args) {

    }
}
