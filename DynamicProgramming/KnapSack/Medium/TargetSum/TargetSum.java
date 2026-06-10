package DynamicProgramming.KnapSack.Medium.TargetSum;
import java.util.Arrays;

// https://leetcode.com/problems/target-sum/
// https://takeuforward.org/practice/dsa/target-sum?category=dp-on-subsequences&source=strivers-a2z-dsa-sheet

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        return helper(n - 1, target, nums);
    }

    private int helper(int index, int target, int[] nums) {
        if (index == 0) {
            if (target + nums[0] == 0 && target - nums[0] == 0)
                return 2;
            else if (target + nums[0] == 0 || target - nums[0] == 0)
                return 1;
            else
                return 0;
        }

        int plus = helper(index - 1, target + nums[index], nums);
        int minus = helper(index - 1, target - nums[index], nums);

        return plus + minus;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int targetSum(int n, int target, int[] nums) {
        // target == diff
        // s1 - s2 = target/diff, (plusOps) - (minusPos) = target
        long totalSum = Arrays.stream(nums).sum();

        if (totalSum < Math.abs(target) || (totalSum + target) % 2 != 0) {
            return 0;
        }

        int MOD = (int) 1e9 + 7;
        long s1 = (totalSum + target) / 2;
        int K = (int) s1 % MOD;

        return countSubsets(nums, K);
    }

    private int countSubsets(int[] arr, int K) {
        int n = arr.length;

        int[][] dp = new int[n][K + 1];
        int MOD = (int) 1e9 + 7;

        for (int target = 0; target <= K; target++) {
            if (target == 0 && (target - arr[0]) == 0)
                dp[0][target] = 2;
            else if (target == 0 || (target - arr[0]) == 0)
                dp[0][target] = 1;
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= K; target++) {
                int notPick = dp[index - 1][target];
                int pick = 0;
                if (target >= arr[index]) {
                    pick = dp[index - 1][target - arr[index]];
                }

                dp[index][target] = (int) (((long) pick + notPick) % MOD);
            }
        }

        return dp[n - 1][K];
    }
}

public class TargetSum {
    public static void main(String[] args) {

    }
}
