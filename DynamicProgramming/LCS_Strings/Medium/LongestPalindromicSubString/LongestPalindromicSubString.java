package DynamicProgramming.LCS_Strings.Medium.LongestPalindromicSubString;
// https://takeuforward.org/practice/dsa/longest-palindromic-substring?category=substring-problems&source=strivers-a2z-dsa-sheet&tab=problem
// https://leetcode.com/problems/longest-palindromic-substring/

// Time Complexity: O(N^2)
// Space Complexity: O(1) expanding around centers
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String t = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n + 1][n + 1];

        int maxLen = 0;
        int startIndex = -1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > maxLen) {
                        int startS = i - dp[i][j];
                        int startT = n - j;

                        if (startS == startT) {
                            maxLen = dp[i][j];
                            startIndex = startS;
                        }
                    }
                }
            }
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + maxLen);
    }
}

public class LongestPalindromicSubString {
    public static void main(String[] args) {

    }
}
