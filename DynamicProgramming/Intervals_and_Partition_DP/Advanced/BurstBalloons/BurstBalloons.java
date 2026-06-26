package DynamicProgramming.Intervals_and_Partition_DP.Advanced.BurstBalloons;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/burst-balloons?category=mcm-dp&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/burst-balloons/

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {

    private int func(int i, int j, int[] nums) {
        if (i > j)
            return 0;
        int maxCoins = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {
            int coins = nums[i - 1] * nums[k] * nums[j + 1];

            int remainingCoins = func(i, k - 1, nums) + func(k + 1, j, nums);

            maxCoins = Math.max(maxCoins, coins + remainingCoins);
        }
        return maxCoins;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        return func(1, n, newNums);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    private int func(int i, int j, int[] nums, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int maxCoins = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {
            int coins = nums[i - 1] * nums[k] * nums[j + 1];

            int remainingCoins = func(i, k - 1, nums, dp) + func(k + 1, j, nums, dp);

            maxCoins = Math.max(maxCoins, coins + remainingCoins);
        }
        return dp[i][j] = maxCoins;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(1, n, newNums, dp);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    continue;
                int maxi = Integer.MIN_VALUE;

                for (int ind = i; ind <= j; ind++) {

                    int coins = newNums[i - 1] * newNums[ind] * newNums[j + 1];

                    int remainingCoins = dp[i][ind - 1] + dp[ind + 1][j];

                    maxi = Math.max(maxi, coins + remainingCoins);
                }
                dp[i][j] = maxi;
            }
        }

        return dp[1][n];
    }
}

public class BurstBalloons {
    public static void main(String[] args) {

    }
}
