package DynamicProgramming.DP_2D_and_Grid.Hard.CherryPickup;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/cherry-pickup-ii?category=dp-on-grids&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem
// https://leetcode.com/problems/cherry-pickup-ii/description/

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int cherryPickup(int[][] grid) {
        int n = grid[0].length;

        return cherryPickup(0, 0, n - 1, grid);
    }

    private int cherryPickup(int i, int j1, int j2, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j1 < 0 || j2 < 0 || j1 >= n || j2 >= n) {
            return (int) -1e9;
        }

        if (i == m - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        int maxi = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;

                if (j1 == j2) {
                    value = grid[i][j1];
                } else {
                    value = grid[i][j1] + grid[i][j2];
                }

                value += cherryPickup(i + 1, j1 + dj1, j2 + dj2, grid);

                maxi = Math.max(maxi, value);
            }
        }

        return maxi;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];// [i][j1][j2]

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return cherryPickup(0, 0, n - 1, grid, dp);
    }

    private int cherryPickup(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j1 < 0 || j2 < 0 || j1 >= n || j2 >= n) {
            return (int) -1e9;
            // return 0;// works by preventing further contribution and making the current
            // path < maximal path
        }

        if (i == m - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int maxi = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;

                if (j1 == j2) {
                    value = grid[i][j1];
                } else {
                    value = grid[i][j1] + grid[i][j2];
                }

                value += cherryPickup(i + 1, j1 + dj1, j2 + dj2, grid, dp);

                maxi = Math.max(maxi, value);
            }
        }

        return dp[i][j1][j2] = maxi;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];// [i][j1][j2]

        for (int j1 = n - 1; j1 >= 0; j1--) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2) {
                    dp[m - 1][j1][j2] = grid[m - 1][j1];
                } else {
                    dp[m - 1][j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
                }
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = n - 1; j1 >= 0; j1--) {
                for (int j2 = 0; j2 < n; j2++) {
                    int maxi = 0;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int value = 0;

                            if (j1 == j2) {
                                value = grid[i][j1];
                            } else {
                                value = grid[i][j1] + grid[i][j2];
                            }

                            if (i + 1 < m && (j1 + dj1) >= 0 && (j1 + dj1) < n && (j2 + dj2) >= 0 && (j2 + dj2) < n) {

                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            }

                            maxi = Math.max(maxi, value);
                        }
                    }

                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][n - 1];
    }
}

public class CherryPickup {
    public static void main(String[] args) {

    }
}
