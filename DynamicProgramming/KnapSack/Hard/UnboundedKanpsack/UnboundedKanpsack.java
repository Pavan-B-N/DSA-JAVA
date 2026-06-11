package DynamicProgramming.KnapSack.Hard.UnboundedKanpsack;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/unbounded-knapsack?category=dp-on-subsequences&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {

        return unboundedKnapsack(n - 1, W, wt, val);
    }

    private int unboundedKnapsack(int index, int W, int[] wt, int[] val) {
        if (index == 0) {
            return val[0] * (W / wt[0]);
        }

        int notPick = unboundedKnapsack(index - 1, W, wt, val);
        int pick = Integer.MIN_VALUE;

        if (W >= wt[index]) {
            pick = val[index] + unboundedKnapsack(index, W - wt[index], wt, val);
        }

        return Math.max(notPick, pick);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {

        int[][] dp = new int[n][W + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return unboundedKnapsack(n - 1, W, wt, val, dp);
    }

    private int unboundedKnapsack(int index, int W, int[] wt, int[] val, int[][] dp) {
        if (index == 0) {
            return val[0] * (W / wt[0]);
        }

        if (dp[index][W] != -1) {
            return dp[index][W];
        }

        int notPick = unboundedKnapsack(index - 1, W, wt, val, dp);
        int pick = Integer.MIN_VALUE;

        if (W >= wt[index]) {
            pick = val[index] + unboundedKnapsack(index, W - wt[index], wt, val, dp);
        }

        return dp[index][W] = Math.max(notPick, pick);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];

        for (int W = 0; W <= maxWeight; W++) {
            dp[0][W] = val[0] * (W / wt[0]);
        }

        for (int index = 1; index < n; index++) {
            for (int W = 0; W <= maxWeight; W++) {
                int notPick = dp[index - 1][W];
                int pick = Integer.MIN_VALUE;

                if (W >= wt[index]) {
                    pick = val[index] + dp[index][W - wt[index]];
                }

                dp[index][W] = Math.max(notPick, pick);
            }
        }

        return dp[n - 1][maxWeight];
    }
}

public class UnboundedKanpsack {
    public static void main(String[] args) {

    }
}
