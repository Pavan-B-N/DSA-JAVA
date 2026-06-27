package DynamicProgramming.Intervals_and_Partition_DP.Advanced.MatrixChainMultiplication;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/matrix-chain-multiplication?category=mcm-dp&source=strivers-a2z-dsa-sheet&tab=solution

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {

    private int func(int[] arr, int i, int j) {
        if (i == j)
            return 0;

        int mini = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int ans = func(arr, i, k) + func(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];

            mini = Math.min(mini, ans);
        }
        return mini;
    }

    public int matrixMultiplication(int[] nums) {
        int N = nums.length;

        int i = 1;

        int j = N - 1;

        return func(nums, i, j);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    private int func(int[] arr, int i, int j, int[][] dp) {
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int mini = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int ans = func(arr, i, k, dp) + func(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];

            mini = Math.min(mini, ans);
        }
        dp[i][j] = mini;
        return mini;
    }

    public int matrixMultiplication(int[] nums) {
        int N = nums.length;

        int i = 1;

        int j = N - 1;

        int[][] dp = new int[N][N];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return func(nums, i, j, dp);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int matrixMultiplication(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int length = 2; length < n; length++) {
            for (int i = 1; i <= n - length; i++) {
                int j = i + length - 1;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + nums[i - 1] * nums[k] * nums[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[1][n - 1];
    }
}

public class MatrixChainMultiplication {
    public static void main(String[] args) {

    }
}
