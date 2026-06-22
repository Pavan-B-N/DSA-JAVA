package DynamicProgramming.LIS.Medium.LIS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/longest-increasing-subsequence/description/
// https://takeuforward.org/practice/dsa/longest-increasing-subsequence?category=lis-dp&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem&solution=binary-search

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(0, -1, nums);
    }

    private int lengthOfLIS(int index, int prev, int[] nums) {
        if (index == nums.length) {
            return 0;
        }

        int notPick = lengthOfLIS(index + 1, prev, nums);
        int pick = 0;

        if (prev == -1 || nums[prev] < nums[index]) {
            pick = 1 + lengthOfLIS(index + 1, index, nums);
        }

        return Math.max(notPick, pick);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lengthOfLIS(0, -1, nums, dp);
    }

    private int lengthOfLIS(int index, int prev, int[] nums, int[][] dp) {
        if (index == nums.length) {
            return 0;
        }

        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }

        int notPick = lengthOfLIS(index + 1, prev, nums, dp);
        int pick = 0;

        if (prev == -1 || nums[prev] < nums[index]) {
            pick = 1 + lengthOfLIS(index + 1, index, nums, dp);
        }

        return dp[index][prev + 1] = Math.max(notPick, pick);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // shift index technique is applied for prev
        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            // prev = n-1 or (index-1) optimal
            for (int prev = index - 1; prev >= -1; prev--) {
                int notPick = dp[index + 1][prev + 1];
                int pick = 0;

                if (prev == -1 || nums[prev] < nums[index]) {
                    pick = 1 + dp[index + 1][index + 1];
                }

                dp[index][prev + 1] = Math.max(notPick, pick);
            }
        }

        return dp[0][0];
    }

}

// Time Complexity: O(N log N) using Binary Search (patience sorting)
// Space Complexity: O(N) for tails array
class Solution_BinarySearch {
    public int LIS(int[] nums) {
        List<Integer> list = new ArrayList<>(); // this is maintained in sorted order
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                // replace the element

                // find the index at which current element can be place
                // found: exact index
                // not found: -(insertionPosition+1)

                int index = Collections.binarySearch(list, nums[i]);
                if (index < 0)
                    index = -(index + 1);

                list.set(index, nums[i]);
            }
        }

        return list.size();
    }
}

public class LIS {
    public static void main(String[] args) {

    }
}
