package DynamicProgramming.LIS.Advanced.LongestBitonicSubsequence;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/longest-bitonic-subsequence?category=lis-dp&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2) or O(N log N)
// Space Complexity: O(N) for increasing and decreasing dp arrays
class Solution {
    public int LongestBitonicSequence(int[] arr) {
        int n = arr.length;

        int[] LIS_dp = new int[n];
        Arrays.fill(LIS_dp, 1);

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i] && LIS_dp[i] < LIS_dp[prev] + 1) {
                    LIS_dp[i] = LIS_dp[prev] + 1;
                }
            }
        }

        int[] LDS_dp = new int[n];
        Arrays.fill(LDS_dp, 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = n - 1; prev > i; prev--) {
                if (arr[prev] < arr[i] && LDS_dp[i] < LDS_dp[prev] + 1) {
                    LDS_dp[i] = LDS_dp[prev] + 1;
                }
            }

            maxLen = Math.max(maxLen, LIS_dp[i] + LDS_dp[i] - 1);
        }

        return maxLen;
    }
}

public class LongestBitonicSubsequence {
    public static void main(String[] args) {

    }
}
