package DynamicProgramming.Intervals_and_Partition_DP.Advanced.PartitionArrayForMaximumSum;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/partition-array-for-maximum-sum?category=mcm-dp&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/partition-array-for-maximum-sum/description/

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    int n;
    int[] dp;

    private int solve(int[] arr, int i, int k) {
        if (i >= n)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int maxSum = 0;
        int subMax = 0;

        for (int len = 1; len <= k && i + len <= n; len++) {
            subMax = Math.max(subMax, arr[i + len - 1]);
            int total = subMax * len + solve(arr, i + len, k);
            maxSum = Math.max(maxSum, total);
        }

        return dp[i] = maxSum;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(arr, 0, k);
    }
}

// Time Complexity: O(N * K)
// Space Complexity: O(N) for dp array
class Solution_Better {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int maxSum = 0;
            int subMax = 0;

            for (int len = 1; len <= k && i + len <= n; len++) {
                subMax = Math.max(subMax, arr[i + len - 1]);
                int total = subMax * len + dp[i + len];
                maxSum = Math.max(maxSum, total);
            }

            dp[i] = maxSum;
        }

        return dp[0];
    }
}

// Time Complexity: O(N * K)
// Space Complexity: O(N) for dp array
class Solution_Optimal {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[k];

        for (int i = n - 1; i >= 0; i--) {
            int maxSum = 0;
            int subMax = 0;

            for (int len = 1; len <= k && i + len <= n; len++) {
                subMax = Math.max(subMax, arr[i + len - 1]);
                int total = subMax * len + (i + len < n ? dp[(i + len) % k] : 0);
                maxSum = Math.max(maxSum, total);
            }

            dp[i % k] = maxSum;
        }

        return dp[0];
    }
}

public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {

    }
}
