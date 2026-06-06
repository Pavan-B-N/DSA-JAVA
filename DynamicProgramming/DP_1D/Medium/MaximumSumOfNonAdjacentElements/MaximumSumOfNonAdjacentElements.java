package DynamicProgramming.DP_1D.Medium.MaximumSumOfNonAdjacentElements;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/maximum-sum-of-non-adjacent-elements?category=1d-dp&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/house-robber/

// Time Complexity: O(2^n)
// Space Complexity: recursion stack space = O(n)
class Solution_Recursive {
    public int nonAdjacent(int[] nums) {
        int n = nums.length;

        return nonAdjacent(n - 1, nums);
    }

    private int nonAdjacent(int index, int[] nums) {
        if (index == 0) {
            return nums[0];
        }

        int notPick = nonAdjacent(index - 1, nums);

        int pick = nums[index];

        if (index - 2 >= 0) {
            pick += nonAdjacent(index - 2, nums);
        }

        return Math.max(pick, notPick);
    }
}

// Time Complexity: O(n)
// Space Complexity:dp = o(n) recursion stack space = O(n)
class Solution_Memoization {
    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return nonAdjacent(n - 1, nums, dp);
    }

    private int nonAdjacent(int index, int[] nums, int[] dp) {
        if (index == 0) {
            return nums[0];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int notPick = nonAdjacent(index - 1, nums, dp);

        int pick = nums[index];

        if (index - 2 >= 0) {
            pick += nonAdjacent(index - 2, nums, dp);
        }

        return dp[index] = Math.max(pick, notPick);
    }
}

// Time Complexity: O(n)
// Space Complexity:dp = o(n)
class Solution_Tabulation {
    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];

        for (int index = 1; index < n; index++) {
            int notPick = dp[index - 1];

            int pick = nums[index];
            if (index - 2 >= 0) {
                pick += dp[index - 2];
            }

            dp[index] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution_SpaceOptimized {
    public int nonAdjacent(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int a = nums[0]; // index-2
        int b = Math.max(nums[0], nums[1]); // index-1

        for (int index = 2; index < n; index++) {
            int notPick = b;

            int pick = nums[index];
            if (index - 2 >= 0) {
                pick += a;
            }

            int c = Math.max(pick, notPick);
            a = b;
            b = c;
        }

        return b;
    }
}

public class MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {

    }
}
