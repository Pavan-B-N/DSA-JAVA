package DynamicProgramming.Intervals_and_Partition_DP.Advanced.PalindromePartitioning2;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/palindrome-partitioning-ii-?category=mcm-dp&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/palindrome-partitioning-ii/description/

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private int minPartitions(int i, int n, String str) {
        if (i == n)
            return 0;

        int minCost = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, str)) {

                int cost = 1 + minPartitions(j + 1, n, str);
                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }

    public int minCut(String s) {
        int n = s.length();
        return minPartitions(0, n, s) - 1;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private int minPartitions(int i, int n, String str, int[] dp) {
        if (i == n)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int minCost = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, str)) {

                int cost = 1 + minPartitions(j + 1, n, str, dp);
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[i] = minCost;
    }

    int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return minPartitions(0, n, s, dp) - 1;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }

        return dp[0] - 1;
    }
}

public class PalindromePartitioning2 {
    public static void main(String[] args) {

    }
}
