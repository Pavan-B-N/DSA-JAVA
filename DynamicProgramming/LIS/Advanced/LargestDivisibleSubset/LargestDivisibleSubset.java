package DynamicProgramming.LIS.Advanced.LargestDivisibleSubset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://takeuforward.org/practice/dsa/largest-divisible-subset?category=lis-dp&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/largest-divisible-subset/

// Time Complexity: O(N^2)
// Space Complexity: O(N) for dp and hash/parent arrays
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] parent = new int[n];

        int lastIndex = 0;

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            parent[i] = i;

            for (int prevInd = 0; prevInd < i; prevInd++) {

                if (nums[i] % nums[prevInd] == 0 && dp[i] < dp[prevInd] + 1) {
                    dp[i] = dp[prevInd] + 1;
                    parent[i] = prevInd;
                }
            }

            if (dp[i] > maxLen) {
                lastIndex = i;
                maxLen = dp[i];
            }
        }

        int i = lastIndex;

        while (parent[i] != i) {
            ans.add(nums[i]);
            i = parent[i];
        }
        ans.add(nums[i]);

        return ans;
    }
}

public class LargestDivisibleSubset {
    public static void main(String[] args) {

    }
}
