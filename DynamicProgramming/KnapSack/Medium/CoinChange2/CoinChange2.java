package DynamicProgramming.KnapSack.Medium.CoinChange2;
import java.util.Arrays;

// https://leetcode.com/problems/coin-change-ii/
// https://takeuforward.org/practice/dsa/coin-change-ii?category=dp-on-subsequences&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        return change(n - 1, amount, coins);
    }

    private int change(int index, int amount, int[] coins) {
        if (index == 0) {
            if (amount % coins[0] == 0)
                return 1;
            return 0;
        }

        int notPick = change(index - 1, amount, coins);
        int pick = 0;

        if (amount >= coins[index]) {
            pick = change(index, amount - coins[index], coins);
        }

        return pick + notPick;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return change(n - 1, amount, coins, dp);
    }

    private int change(int index, int amount, int[] coins, int[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0)
                return 1;
            return 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int notPick = change(index - 1, amount, coins, dp);
        int pick = 0;

        if (amount >= coins[index]) {
            pick = change(index, amount - coins[index], coins, dp);
        }

        return dp[index][amount] = pick + notPick;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int change(int targetAmount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][targetAmount + 1];

        for (int amount = 0; amount <= targetAmount; amount++) {
            if (amount % coins[0] == 0)
                dp[0][amount] = 1;
        }

        for (int index = 1; index < n; index++) {
            for (int amount = 0; amount <= targetAmount; amount++) {
                int notPick = dp[index - 1][amount];
                int pick = 0;

                if (amount >= coins[index]) {
                    pick = dp[index][amount - coins[index]];
                }

                dp[index][amount] = pick + notPick;
            }
        }

        return dp[n - 1][targetAmount];
    }

}

public class CoinChange2 {
    public static void main(String[] args) {

    }
}
