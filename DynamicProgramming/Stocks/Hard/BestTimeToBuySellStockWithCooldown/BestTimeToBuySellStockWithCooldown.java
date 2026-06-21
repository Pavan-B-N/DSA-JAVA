package DynamicProgramming.Stocks.Hard.BestTimeToBuySellStockWithCooldown;
import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

// https://takeuforward.org/practice/dsa/best-time-to-buy-and-sell-stock-with-cooldown?category=dp-on-stocks&source=strivers-a2z-dsa-sheet

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int maxProfit(int[] prices) {
        return maxProfit(0, 1, prices);
    }

    private int maxProfit(int index, int buy, int[] prices) {
        if (index >= prices.length) {
            return 0;
        }

        if (buy == 1) {
            int buyNow = -prices[index] + maxProfit(index + 1, 0, prices);
            int skipBuy = maxProfit(index + 1, 1, prices);

            return Math.max(buyNow, skipBuy);

        } else {
            int sellNow = prices[index] + maxProfit(index + 2, 1, prices);
            int skipSell = maxProfit(index + 1, 0, prices);

            return Math.max(sellNow, skipSell);
        }

    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxProfit(0, true, prices, dp);
    }

    private int maxProfit(int index, boolean buy, int[] prices, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }

        int buyInt = buy ? 1 : 0;

        if (dp[index][buyInt] != -1) {
            return dp[index][buyInt];
        }

        if (buy) {
            int buyNow = -prices[index] + maxProfit(index + 1, false, prices, dp);
            int skipBuy = maxProfit(index + 1, true, prices, dp);

            return dp[index][buyInt] = Math.max(buyNow, skipBuy);

        } else {
            int sellNow = prices[index] + maxProfit(index + 2, true, prices, dp);
            int skipSell = maxProfit(index + 1, false, prices, dp);

            return dp[index][buyInt] = Math.max(sellNow, skipSell);
        }

    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int buyNow = -prices[index] + dp[index + 1][0];
                    int skipBuy = dp[index + 1][1];

                    dp[index][buy] = Math.max(buyNow, skipBuy);

                } else {
                    int sellNow = prices[index] + dp[index + 2][1];
                    int skipSell = dp[index + 1][0];

                    dp[index][buy] = Math.max(sellNow, skipSell);
                }
            }

        }

        return dp[0][1];
    }
}

public class BestTimeToBuySellStockWithCooldown {
    public static void main(String[] args) {

    }
}
