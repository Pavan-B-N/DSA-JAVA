package DynamicProgramming.Stocks.Hard.BestTimeToBuySellStock4;
import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
// https://takeuforward.org/practice/dsa/best-time-to-buy-and-sell-stock-iv?category=dp-on-stocks&source=strivers-a2z-dsa-sheet

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int maxProfit(int k, int[] prices) {
        return maxProfit(0, true, k, prices);
    }

    private int maxProfit(int index, boolean buy, int maxTransactions, int[] prices) {
        if (index == prices.length || maxTransactions == 0) {
            return 0;
        }

        if (buy) {
            int buyNow = -prices[index] + maxProfit(index + 1, false, maxTransactions, prices);
            int skipBuy = maxProfit(index + 1, true, maxTransactions, prices);

            return Math.max(buyNow, skipBuy);

        } else {
            int sellNow = prices[index] + maxProfit(index + 1, true, maxTransactions - 1, prices);
            int skipSell = maxProfit(index + 1, false, maxTransactions, prices);

            return Math.max(sellNow, skipSell);
        }

    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][k + 1];

        // initialize dp
        for (int index = 0; index < n; index++) {
            for (int buy = 0; buy <= 1; buy++) {
                Arrays.fill(dp[index][buy], -1);
            }
        }

        return maxProfit(0, 1, k, prices, dp);
    }

    private int maxProfit(int index, int buy, int maxTransactions, int[] prices, int[][][] dp) {
        if (index == prices.length || maxTransactions == 0) {
            return 0;
        }

        if (dp[index][buy][maxTransactions] != -1) {
            return dp[index][buy][maxTransactions];
        }

        if (buy == 1) {
            int buyNow = -prices[index] + maxProfit(index + 1, 0, maxTransactions, prices, dp);
            int skipBuy = maxProfit(index + 1, 1, maxTransactions, prices, dp);

            return dp[index][buy][maxTransactions] = Math.max(buyNow, skipBuy);

        } else {
            int sellNow = prices[index] + maxProfit(index + 1, 1, maxTransactions - 1, prices, dp);
            int skipSell = maxProfit(index + 1, 0, maxTransactions, prices, dp);

            return dp[index][buy][maxTransactions] = Math.max(sellNow, skipSell);
        }

    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][k + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int maxTransactions = 1; maxTransactions <= k; maxTransactions++) {
                    if (buy == 1) {
                        int buyNow = -prices[index] + dp[index + 1][0][maxTransactions];
                        int skipBuy = dp[index + 1][1][maxTransactions];

                        dp[index][buy][maxTransactions] = Math.max(buyNow, skipBuy);

                    } else {
                        int sellNow = prices[index] + dp[index + 1][1][maxTransactions - 1];
                        int skipSell = dp[index + 1][0][maxTransactions];

                        dp[index][buy][maxTransactions] = Math.max(sellNow, skipSell);
                    }
                }
            }
        }

        return dp[0][1][k];
    }
}

public class BestTimeToBuySellStock4 {
    public static void main(String[] args) {

    }
}
