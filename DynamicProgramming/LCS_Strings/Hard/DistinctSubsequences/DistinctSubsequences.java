package DynamicProgramming.LCS_Strings.Hard.DistinctSubsequences;
import java.util.Arrays;

// https://leetcode.com/problems/distinct-subsequences/description/
// https://takeuforward.org/practice/dsa/distinct-subsequences?category=dp-on-strings&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        return countWays(m - 1, n - 1, s, t);
    }

    private int countWays(int i, int j, String s, String t) {
        if (j < 0) {
            return 1;
        }

        if (i < 0) {
            return 0;
        }

        if (s.charAt(i) == t.charAt(j)) {
            int take = countWays(i - 1, j - 1, s, t);
            int notTake = countWays(i - 1, j, s, t);

            return take + notTake;
        } else {
            return countWays(i - 1, j, s, t);
        }
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return countWays(m - 1, n - 1, s, t, dp);
    }

    private int countWays(int i, int j, String s, String t, int[][] dp) {
        if (j < 0) {
            return 1;
        }

        if (i < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            int take = countWays(i - 1, j - 1, s, t, dp);
            int notTake = countWays(i - 1, j, s, t, dp);

            return dp[i][j] = take + notTake;
        } else {
            return dp[i][j] = countWays(i - 1, j, s, t, dp);
        }
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // shift index technique index = index+1
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    int take = dp[i - 1][j - 1];
                    int notTake = dp[i - 1][j];

                    dp[i][j] = take + notTake;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}

public class DistinctSubsequences {
    public static void main(String[] args) {

    }
}
