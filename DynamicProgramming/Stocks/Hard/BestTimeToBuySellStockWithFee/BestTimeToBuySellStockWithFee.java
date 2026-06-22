package DynamicProgramming.Stocks.Hard.BestTimeToBuySellStockWithFee;
import java.util.Arrays;

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int maxProfit(int[] prices, int fee) {
        return maxProfit(0, true, fee, prices);
    }

    private int maxProfit(int index, boolean buy, final int fee, int[] prices) {
        if (index == prices.length) {
            return 0;
        }

        if (buy) {
            int buyNow = -prices[index] + maxProfit(index + 1, false, fee, prices);
            int skipBuy = maxProfit(index + 1, true, fee, prices);

            return Math.max(buyNow, skipBuy);

        } else {
            int sellNow = -fee + prices[index] + maxProfit(index + 1, true, fee, prices);
            int skipSell = maxProfit(index + 1, false, fee, prices);

            return Math.max(sellNow, skipSell);
        }

    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxProfit(0, 1, fee, prices, dp);
    }

    private int maxProfit(int index, int buy, int fee, int[] prices, int[][] dp) {
        if (index == prices.length) {
            return 0;
        }

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        if (buy == 1) {
            int buyNow = -prices[index] + maxProfit(index + 1, 0, fee, prices, dp);
            int skipBuy = maxProfit(index + 1, 1, fee, prices, dp);

            return dp[index][buy] = Math.max(buyNow, skipBuy);

        } else {
            int sellNow = -fee + prices[index] + maxProfit(index + 1, 1, fee, prices, dp);
            int skipSell = maxProfit(index + 1, 0, fee, prices, dp);

            return dp[index][buy] = Math.max(sellNow, skipSell);
        }

    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int buyNow = -prices[index] + dp[index + 1][0];
                    int skipBuy = dp[index + 1][1];

                    dp[index][buy] = Math.max(buyNow, skipBuy);

                } else {
                    int sellNow = -fee + prices[index] + dp[index + 1][1];
                    int skipSell = dp[index + 1][0];

                    dp[index][buy] = Math.max(sellNow, skipSell);
                }
            }

        }

        return dp[0][1];
    }
}

public class BestTimeToBuySellStockWithFee {
    public static void main(String[] args) {

    }
}
