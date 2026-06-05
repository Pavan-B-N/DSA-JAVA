package DynamicProgramming.DP_1D.Medium.FrongJumpWithKDistance;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/frog-jump-with-k-distances?category=1d-dp&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(k^n)
// Space Complexity: recursion stack space = O(n)
class Solution_Recursive {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;

        return frogJump(n - 1, heights, k);
    }

    private int frogJump(int index, int[] heights, int k) {
        if (index == 0) {
            return 0;
        }

        int minEnergy = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int energy = Math.abs(heights[index] - heights[index - i]) + frogJump(index - i, heights, k);
                minEnergy = Math.min(minEnergy, energy);
            }
        }

        return minEnergy;

    }

}

// Time Complexity: O(nk)
// Space Complexity: dp = O(n) recursion stack space = O(n)
class Solution_Memoization {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return frogJump(n - 1, heights, k, dp);
    }

    private int frogJump(int index, int[] heights, int k, int[] dp) {
        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int minEnergy = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int energy = Math.abs(heights[index] - heights[index - i]) + frogJump(index - i, heights, k, dp);
                minEnergy = Math.min(minEnergy, energy);
            }
        }

        return dp[index] = minEnergy;
    }
}

// Time Complexity: O(nk)
// Space Complexity: dp = O(n)
class Solution_Tabulation {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;

        int[] dp = new int[n];
        dp[0] = 0;

        for (int index = 1; index < heights.length; index++) {
            int minEnergy = Integer.MAX_VALUE;

            for (int i = 1; i <= k; i++) {
                if (index - i >= 0) {
                    int energy = Math.abs(heights[index] - heights[index - i]) + dp[index - i];
                    minEnergy = Math.min(minEnergy, energy);
                }
            }

            dp[index] = minEnergy;
        }

        return dp[n - 1];
    }
}

// Time Complexity: O(nk)
// Space Complexity: dp = O(k)
class Solution {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;

        int[] dp = new int[k];
        dp[0] = 0;

        for (int index = 1; index < heights.length; index++) {
            int minEnergy = Integer.MAX_VALUE;

            for (int i = 1; i <= k; i++) {
                if (index - i >= 0) {
                    int prevIndex = (index - i) % k;
                    int energy = Math.abs(heights[index] - heights[index - i]) + dp[prevIndex];
                    minEnergy = Math.min(minEnergy, energy);
                }
            }

            dp[index % k] = minEnergy;
        }

        return dp[(n - 1) % k];
    }
}

public class FrongJumpWithKDistance {
    public static void main(String[] args) {

    }
}
