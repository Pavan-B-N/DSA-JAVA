package DynamicProgramming.KnapSack.Medium.CountSubsetSumK;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/count-subsets-with-sum-k?category=dp-on-subsequences&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int perfectSum(int[] arr, int K) {
        int n = arr.length;

        return countSubsets(n - 1, K, arr);
    }

    private int countSubsets(int index, int target, int[] arr) {
        int MOD = (int) 1e9 + 7;

        if (index == 0) {
            if (target == 0 && (target - arr[0]) == 0)
                return 2;
            else if (target == 0 || (target - arr[0]) == 0)
                return 1;
            return 0;
        }

        int notPick = countSubsets(index - 1, target, arr);
        int pick = 0;
        if (target >= arr[index]) {
            pick = countSubsets(index - 1, target - arr[index], arr);
        }

        return (int) (((long) pick + notPick) % MOD);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int perfectSum(int[] arr, int K) {
        int n = arr.length;

        int[][] dp = new int[n][K + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return countSubsets(n - 1, K, arr, dp);
    }

    private int countSubsets(int index, int target, int[] arr, int[][] dp) {
        int MOD = (int) 1e9 + 7;

        if (index == 0) {
            if (target == 0 && (target - arr[0]) == 0)
                return 2;
            else if (target == 0 || (target - arr[0]) == 0)
                return 1;
            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notPick = countSubsets(index - 1, target, arr, dp);
        int pick = 0;
        if (target >= arr[index]) {
            pick = countSubsets(index - 1, target - arr[index], arr, dp);
        }

        return dp[index][target] = (int) (((long) pick + notPick) % MOD);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int perfectSum(int[] arr, int K) {
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

public class CountSubsetSumK {
    public static void main(String[] args) {

    }
}
