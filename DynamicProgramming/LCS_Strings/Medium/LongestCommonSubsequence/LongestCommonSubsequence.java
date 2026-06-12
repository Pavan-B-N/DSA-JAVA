package DynamicProgramming.LCS_Strings.Medium.LongestCommonSubsequence;
import java.util.Arrays;

// https://leetcode.com/problems/longest-common-subsequence/
// https://takeuforward.org/practice/dsa/longest-common-subsequence?category=dp-on-strings&source=strivers-a2z-dsa-sheet

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int longestCommonSubsequence(String s1, String s2) {
        return longestCommonSubsequence(s1.length() - 1, s2.length() - 1, s1, s2);
    }

    private int longestCommonSubsequence(int i, int j, String s1, String s2) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + longestCommonSubsequence(i - 1, j - 1, s1, s2);
        }

        int noMatchS1 = longestCommonSubsequence(i - 1, j, s1, s2);
        int noMatchS2 = longestCommonSubsequence(i, j - 1, s1, s2);

        return Math.max(noMatchS1, noMatchS2);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return longestCommonSubsequence(m - 1, n - 1, s1, s2, dp);
    }

    private int longestCommonSubsequence(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + longestCommonSubsequence(i - 1, j - 1, s1, s2, dp);
        }

        int noMatchS1 = longestCommonSubsequence(i - 1, j, s1, s2, dp);
        int noMatchS2 = longestCommonSubsequence(i, j - 1, s1, s2, dp);

        return dp[i][j] = Math.max(noMatchS1, noMatchS2);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];

    }

}

public class LongestCommonSubsequence {
    public static void main(String[] args) {

    }
}
