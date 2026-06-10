package DynamicProgramming.KnapSack.Medium.PartitionEqualsSubsetSum;
import java.util.Arrays;

// https://leetcode.com/problems/partition-equal-subset-sum/description/
// https://takeuforward.org/practice/dsa/partition-equal-subset-sum?category=dp-on-subsequences&source=strivers-a2z-dsa-sheet&sidebar=0


// Time Complexity: O(N * target)
// Space Complexity: O(target) space optimized
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();

        if(totalSum % 2 != 0){
            return false;
        }

        int target = totalSum / 2;

        return isSubsetSum(nums,target);
    }

    private boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;

        boolean[][] dp = new boolean[n][target + 1];

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

        return dp[n - 1][target];
    }
}

public class PartitionEqualsSubsetSum {
    public static void main(String[] args) {
        
    }
}
