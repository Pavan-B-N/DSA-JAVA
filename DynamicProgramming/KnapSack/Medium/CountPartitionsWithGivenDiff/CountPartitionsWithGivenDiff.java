package DynamicProgramming.KnapSack.Medium.CountPartitionsWithGivenDiff;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/count-partitions-with-given-difference?category=dp-on-subsequences&source=strivers-a2z-dsa-sheet&tab=problem&solution=recursion

// Time Complexity: O(N * target)
// Space Complexity: O(target) space optimized
class Solution {
    public int countPartitions(int n, int diff, int[] arr) {
        long totalSum = Arrays.stream(arr).sum();

        if ((totalSum < diff) || (totalSum + diff) % 2 != 0)
            return 0;

        int MOD = (int) 1e9 + 7;

        long s1 = (totalSum + diff) / 2;
        int target = (int) (s1 % MOD);

        return countSubsets(arr, target);
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

public class CountPartitionsWithGivenDiff {
    public static void main(String[] args) {

    }
}
