package DynamicProgramming.KnapSack.Hard.WildCardMatching;
// https://leetcode.com/problems/wildcard-matching/
// https://takeuforward.org/practice/dsa/wildcard-matching?category=dp-on-strings&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        return isMatch(m - 1, n - 1, s, p);
    }

    private boolean isMatch(int i, int j, String s, String p) {
        // base case
        if (i < 0 && j < 0) {
            return true;
        }

        // base case
        if (i < 0) {
            while (j >= 0) {
                if (p.charAt(j) != '*') {
                    return false;
                }
                j--;
            }
            return true;
        }

        // base case
        if (j < 0) {
            return false;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return isMatch(i - 1, j - 1, s, p);
        } else if (p.charAt(j) == '*') {
            // zero or more match
            boolean zeroMatch = isMatch(i, j - 1, s, p);
            boolean moreMatch = isMatch(i - 1, j, s, p);

            return zeroMatch || moreMatch;
        } else {
            return false;
        }

    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        Boolean[][] dp = new Boolean[m][n];

        return isMatch(m - 1, n - 1, s, p, dp);
    }

    private boolean isMatch(int i, int j, String s, String p, Boolean[][] dp) {
        // base case
        if (i < 0 && j < 0) {
            return true;
        }

        // base case
        if (i < 0) {
            while (j >= 0) {
                if (p.charAt(j) != '*') {
                    return false;
                }
                j--;
            }
            return true;
        }

        // base case
        if (j < 0) {
            return false;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = isMatch(i - 1, j - 1, s, p, dp);
        } else if (p.charAt(j) == '*') {
            // zero or more match
            boolean zeroMatch = isMatch(i, j - 1, s, p, dp);
            boolean moreMatch = isMatch(i - 1, j, s, p, dp);

            return dp[i][j] = zeroMatch || moreMatch;
        } else {
            return dp[i][j] = false;
        }

    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // shift index technique
        boolean[][] dp = new boolean[m + 1][n + 1];

        // base case
        for (int j = 1; j <= n; j++) {
            int ptr = j;
            boolean flag = true;

            while (ptr >= 1) {
                if (p.charAt(ptr - 1) != '*') {
                    flag = false;
                    break;
                }
                ptr--;
            }

            dp[0][j] = flag;
        }

        // base case
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // zero or more match
                    boolean zeroMatch = dp[i][j - 1];
                    boolean moreMatch = dp[i - 1][j];

                    dp[i][j] = zeroMatch || moreMatch;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }
}

public class WildCardMatching {
    public static void main(String[] args) {

    }
}
