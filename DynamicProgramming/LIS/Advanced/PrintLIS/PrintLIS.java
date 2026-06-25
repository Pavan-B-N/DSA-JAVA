package DynamicProgramming.LIS.Advanced.PrintLIS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://takeuforward.org/practice/dsa/print-longest-increasing-subsequence?category=lis-dp&source=strivers-a2z-dsa-sheet&tab=solution

// Time Complexity: O(N^2)
// Space Complexity: O(N) for dp and parent arrays
class Solution {
    public List<Integer> longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;

        List<Integer> ans = new ArrayList<>();
        int[] dp = new int[n];
        int[] parent = new int[n];

        int lastIndex = 0;

        int maxLen = 0;

        Arrays.fill(dp, 1);

        // Computing the DP array
        for (int i = 0; i < n; i++) {
            parent[i] = i;

            for (int prevInd = 0; prevInd < i; prevInd++) {

                if (arr[prevInd] < arr[i]) {
                    if (dp[i] < dp[prevInd] + 1) {
                        dp[i] = dp[prevInd] + 1;
                        parent[i] = prevInd;
                    } else if (dp[i] == dp[prevInd] + 1 && prevInd < parent[i]) {
                        parent[i] = prevInd;
                    }
                }
            }

            if (dp[i] > maxLen) {
                lastIndex = i;
                maxLen = dp[i];
            }
        }

        int i = lastIndex;

        while (parent[i] != i) {
            ans.add(arr[i]);
            i = parent[i];
        }
        ans.add(arr[i]);

        Collections.reverse(ans);

        return ans;
    }
}

public class PrintLIS {
    public static void main(String[] args) {

    }
}
