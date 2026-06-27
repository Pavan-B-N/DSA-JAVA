package DynamicProgramming.Intervals_and_Partition_DP.Advanced.CountPalindromicSubsequences;
// https://takeuforward.org/practice/dsa/count-palindromic-subsequences?category=dp-on-strings&source=strivers-a2z-dsa-sheet&tab=solution
// https://leetcode.com/problems/count-palindromic-subsequences/

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    public int countPalSubseqUtil(String s, int i, int j, int[][] dp) {
        if (i == j)
            return 1;

        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == s.charAt(j))
            dp[i][j] = 1 + countPalSubseqUtil(s, i + 1, j, dp) + countPalSubseqUtil(s, i, j - 1, dp);
        else
            dp[i][j] = countPalSubseqUtil(s, i + 1, j, dp)
                    + countPalSubseqUtil(s, i, j - 1, dp)
                    - countPalSubseqUtil(s, i + 1, j - 1, dp);

        return dp[i][j];
    }

    public int countPalSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            java.util.Arrays.fill(row, -1);
        return countPalSubseqUtil(s, 0, n - 1, dp);
    }
}

// Time Complexity: O(N^2)
// Space Complexity: O(N^2) for dp table
class Solution_Optimal {
    public int countPalSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }

        return dp[0][n - 1];
    }
}

public class CountPalindromicSubsequences {
    public static void main(String[] args) {

    }
}
