package DynamicProgramming.KnapSack.Medium.CoinChange;
import java.util.Arrays;

// https://leetcode.com/problems/coin-change/
// https://takeuforward.org/practice/dsa/minimum-coins?category=dp-on-subsequences&source=strivers-a2z-dsa-sheet&sidebar=0&tab=submissions

// Time Complexity: O(N * amount)
// Space Complexity: O(amount) space optimized
class Solution_Greedy_Fails_Proof {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            count += (amount / coins[i]);
            amount %= coins[i];
        }

        return amount == 0 ? count : -1;
    }
}

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int res = coinChange(n - 1, amount, coins);
        return res == 1e9 ? -1 : res;
    }

    private int coinChange(int index, int amount, int[] coins) {
        if (index == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            return (int) 1e9;
        }

        int notPick = coinChange(index - 1, amount, coins);

        int pick = Integer.MAX_VALUE;

        if (amount >= coins[index]) {
            pick = 1 + coinChange(index, amount - coins[index], coins);
        }

        return Math.min(notPick, pick);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int res = coinChange(n - 1, amount, coins, dp);
        return res == 1e9 ? -1 : res;
    }

    private int coinChange(int index, int amount, int[] coins, int[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            return (int) 1e9;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int notPick = coinChange(index - 1, amount, coins, dp);

        int pick = Integer.MAX_VALUE;

        if (amount >= coins[index]) {
            pick = 1 + coinChange(index, amount - coins[index], coins, dp);
        }

        return dp[index][amount] = Math.min(notPick, pick);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int coinChange(int[] coins, int targetAmount) {
        int n = coins.length;

        int[][] dp = new int[n][targetAmount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], (int) 1e9);
        }

        for (int amount = 0; amount <= targetAmount; amount++) {
            if (amount % coins[0] == 0) {
                dp[0][amount] = amount / coins[0];
            }
        }

        for (int index = 1; index < coins.length; index++) {
            for (int amount = 0; amount <= targetAmount; amount++) {
                int notPick = dp[index - 1][amount];

                int pick = Integer.MAX_VALUE;

                if (amount >= coins[index]) {
                    pick = 1 + dp[index][amount - coins[index]];
                }

                dp[index][amount] = Math.min(notPick, pick);
            }
        }

        return dp[n - 1][targetAmount] == 1e9 ? -1 : dp[n - 1][targetAmount];
    }

}

public class CoinChange {
    public static void main(String[] args) {

    }
}
