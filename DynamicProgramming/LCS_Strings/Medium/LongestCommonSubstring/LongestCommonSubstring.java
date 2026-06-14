package DynamicProgramming.LCS_Strings.Medium.LongestCommonSubstring;
// https://takeuforward.org/practice/dsa/longest-common-substring?category=dp-on-strings&source=strivers-a2z-dsa-sheet&sidebar=0

// Derived from LCS technique

// Time Complexity: O(N * M)
// Space Complexity: O(M) space optimized
class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int maxLen = 0;

        int m = s1.length();
        int n = s2.length();

        // shift index technique
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLen;
    }
}

public class LongestCommonSubstring {
    public static void main(String[] args) {

    }
}
