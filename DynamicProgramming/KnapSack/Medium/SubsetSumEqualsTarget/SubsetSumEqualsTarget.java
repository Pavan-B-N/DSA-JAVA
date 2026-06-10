package DynamicProgramming.KnapSack.Medium.SubsetSumEqualsTarget;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/subset-sum-equals-to-target?category=dp-on-subsequences&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        return isSubsetSum(n - 1, target, arr);
    }

    private boolean isSubsetSum(int index, int target, int[] arr) {
        if (index == 0) {
            return target == 0 || (arr[0] - target) == 0;
        }

        boolean notPick = isSubsetSum(index - 1, target, arr);
        boolean pick = false;
        if (target >= arr[index]) {
            pick = isSubsetSum(index - 1, target - arr[index], arr);
        }

        return notPick || pick;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;

        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return isSubsetSum(n - 1, target, arr, dp);
    }

    private boolean isSubsetSum(int index, int target, int[] arr, int[][] dp) {
        if (index == 0) {
            return target == 0 || (arr[0] - target) == 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        boolean notPick = isSubsetSum(index - 1, target, arr, dp);

        if (notPick) {
            dp[index][target] = 1;
            return true;
        }

        boolean pick = false;
        if (target >= arr[index]) {
            pick = isSubsetSum(index - 1, target - arr[index], arr, dp);
        }

        dp[index][target] = pick ? 1 : 0;

        return pick;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public boolean isSubsetSum(int[] arr, int target) {
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

public class SubsetSumEqualsTarget {
    public static void main(String[] args) {

    }
}
