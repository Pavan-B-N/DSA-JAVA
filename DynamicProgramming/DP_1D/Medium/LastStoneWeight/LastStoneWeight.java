package DynamicProgramming.DP_1D.Medium.LastStoneWeight;
import java.util.Arrays;

// https://leetcode.com/problems/last-stone-weight-ii/description/

// Time Complexity: O(N * sum)
// Space Complexity: O(sum) space optimized
class Solution {
    public int lastStoneWeightII(int[] arr) {
        int n = arr.length;

        int totalSum = Arrays.stream(arr).sum();

        int target = (totalSum) / 2;

        boolean[][] dp = new boolean[n][target + 1];
        ComputeSubsetSum(arr, target, dp);

        for (int t = target; t >= 0; t--) {
            if (dp[n - 1][t]) {
                int set1 = totalSum - t;
                int set2 = totalSum - set1;
                return Math.abs(set1 - set2);
            }
        }

        return -1;
    }

    private void ComputeSubsetSum(int[] arr, int target, boolean[][] dp) {
        int n = arr.length;

        for (int t = 0; t <= target; t++) {
            if (t == 0 || (arr[0] - t) == 0) {
                dp[0][t] = true;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                boolean notPick = dp[i - 1][t];
                boolean pick = false;
                if (t >= arr[i]) {
                    pick = dp[i - 1][t - arr[i]];
                }

                dp[i][t] = (pick || notPick);
            }
        }

    }
}

public class LastStoneWeight {
    public static void main(String[] args) {

    }
}
