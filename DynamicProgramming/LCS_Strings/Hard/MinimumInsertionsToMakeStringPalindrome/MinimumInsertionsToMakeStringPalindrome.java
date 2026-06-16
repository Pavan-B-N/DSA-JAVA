package DynamicProgramming.LCS_Strings.Hard.MinimumInsertionsToMakeStringPalindrome;
// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
// https://takeuforward.org/practice/dsa/minimum-insertions-to-make-string-palindrome?category=dp-on-strings&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(N) space optimized
class Solution {
    public int minInsertions(String s1) {

        String s2 = new StringBuilder(s1).reverse().toString();

        return s1.length() - lcs(s1, s2);
    }

    private int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }
}

public class MinimumInsertionsToMakeStringPalindrome {
    public static void main(String[] args) {

    }
}
