package DynamicProgramming.Intervals_and_Partition_DP.Advanced.MinimumCostToCutTheStick;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://takeuforward.org/practice/dsa/minimum-cost-to-cut-the-stick?category=mcm-dp&source=strivers-a2z-dsa-sheet&tab=solution
// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    private int func(int i, int j, int[] cuts) {
        if (i > j) {
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int ans = cuts[j + 1] - cuts[i - 1] + func(i, ind - 1, cuts) + func(ind + 1, j, cuts);

            mini = Math.min(mini, ans);
        }
        return mini;
    }

    public int minCost(int n, List<Integer> cuts) {
        int c = cuts.size();
        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        for (int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts.get(i);
        }
        newCuts[c + 1] = n;
        Arrays.sort(newCuts);

        return func(1, c, newCuts);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    private int func(int i, int j, int[] cuts, int[][] dp) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {

            int ans = cuts[j + 1] - cuts[i - 1] + func(i, ind - 1, cuts, dp) + func(ind + 1, j, cuts, dp);

            mini = Math.min(mini, ans);
        }

        return dp[i][j] = mini;
    }

    public int minCost(int n, List<Integer> cuts) {
        int c = cuts.size();
        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        for (int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts.get(i);
        }
        newCuts[c + 1] = n;
        Arrays.sort(newCuts);

        int[][] dp = new int[c + 1][c + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(1, c, newCuts, dp);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int minCost(int n, List<Integer> cuts) {
        int c = cuts.size();

        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);

        int[][] dp = new int[c + 2][c + 2];

        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j)
                    continue;

                int mini = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int ans = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];

                    mini = Math.min(mini, ans);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][c];
    }
}

public class MinimumCostToCutTheStick {
    public static void main(String[] args) {

    }
}
