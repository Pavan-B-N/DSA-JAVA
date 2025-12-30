package Strings.Advanced.MinimumWindowSubsequence;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/minimum-window-subsequence?category=longest-and-smallest-window-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public String minWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp)
            Arrays.fill(row, 1000000000);

        dp[0][0] = 0;

        int end = 0, length = n + 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
            for (int j = 1; j <= m; j++) {
                dp[i][j] = 1 + (s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j]);
            }

            if (dp[i][m] < length) {
                length = dp[i][m];
                end = i;
            }
        }

        return length > n ? "" : s1.substring(end - length, end);
    }
}

public class MinimumWindowSubsequence {
    public static void main(String[] args) {

    }
}
