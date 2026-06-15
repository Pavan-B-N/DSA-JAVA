package DynamicProgramming.LCS_Strings.Hard.EditDistance;
import java.util.Arrays;

// https://leetcode.com/problems/edit-distance/description/
// https://takeuforward.org/practice/dsa/edit-distance?category=dp-on-strings&source=strivers-a2z-dsa-sheet&tab=submissions

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        return minDistance(m - 1, n - 1, word1, word2);
    }

    private int minDistance(int i, int j, String s, String t) {
        if (i < 0) { // insert
            return j + 1;
        }

        if (j < 0) { // delete
            return i + 1;
        }

        if (s.charAt(i) == t.charAt(j)) {
            return minDistance(i - 1, j - 1, s, t);
        } else {
            int insert = minDistance(i, j - 1, s, t);
            int delete = minDistance(i - 1, j, s, t);
            int replace = minDistance(i - 1, j - 1, s, t);

            return 1 + Math.min(insert, Math.min(delete, replace));
        }
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minDistance(m - 1, n - 1, word1, word2, dp);
    }

    private int minDistance(int i, int j, String s, String t, int[][] dp) {
        if (i < 0) { // insert
            return j + 1;
        }

        if (j < 0) { // delete
            return i + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = minDistance(i - 1, j - 1, s, t, dp);
        } else {
            int insert = minDistance(i, j - 1, s, t, dp);
            int delete = minDistance(i - 1, j, s, t, dp);
            int replace = minDistance(i - 1, j - 1, s, t, dp);

            return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int minDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        // shift index technique index = index+1
        int[][] dp = new int[m + 1][n + 1];

        // base cases
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[m][n];
    }

}

public class EditDistance {
    public static void main(String[] args) {

    }
}
