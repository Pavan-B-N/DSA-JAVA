package DynamicProgramming.Stocks.Easy.BestTimeToBuySellStock;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// https://takeuforward.org/practice/dsa/best-time-to-buy-and-sell-stock?category=dp-on-stocks&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int buyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }
        }

        return maxProfit;
    }
}

public class BestTimeToBuySellStock {
    public static void main(String[] args) {

    }
}
