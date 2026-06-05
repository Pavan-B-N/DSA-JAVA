package DynamicProgramming.DP_1D.Easy.FrogJump;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/frog-jump?category=1d-dp&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(2^n)
// Space Complexity: recursion stack space = O(n)
class Solution_Recursive {
    public int frogJump(int[] heights) {
        int n = heights.length;

        return frogJump(n - 1, heights);
    }

    private int frogJump(int index, int[] heights) {
        if (index == 0) {
            return 0;
        }

        // i-1
        int step1 = Math.abs(heights[index] - heights[index - 1]) + frogJump(index - 1, heights);

        // i-2
        int step2 = Integer.MAX_VALUE;

        if (index - 2 >= 0) {
            step2 = Math.abs(heights[index] - heights[index - 2]) + frogJump(index - 2, heights);
        }

        return Math.min(step1, step2);
    }
}

// Time Complexity: O(n)
// Space Complexity: dp space = O(n), recursion stack space = O(n)
class Solution_Memoization {
    public int frogJump(int[] heights) {
        int n = heights.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return frogJump(n - 1, heights, dp);
    }

    private int frogJump(int index, int[] heights, int[] dp) {
        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // i-1
        int step1 = Math.abs(heights[index] - heights[index - 1]) + frogJump(index - 1, heights, dp);

        // i-2
        int step2 = Integer.MAX_VALUE;

        if (index - 2 >= 0) {
            step2 = Math.abs(heights[index] - heights[index - 2]) + frogJump(index - 2, heights, dp);
        }

        return dp[index] = Math.min(step1, step2);
    }
}

// Time Complexity: O(n)
// Space Complexity: dp space = O(n)
class Solution_Tabulation {
    public int frogJump(int[] heights) {
        int n = heights.length;

        if (n == 1)
            return 0;

        int[] dp = new int[n];

        // base case
        dp[0] = 0;

        for (int index = 1; index < heights.length; index++) {
            // i-1
            int step1 = Math.abs(heights[index] - heights[index - 1]) + dp[index - 1];

            // i-2
            int step2 = Integer.MAX_VALUE;

            if (index - 2 >= 0) {
                step2 = Math.abs(heights[index] - heights[index - 2]) + dp[index - 2];
            }

            dp[index] = Math.min(step1, step2);
        }

        return dp[n - 1];
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution_SpaceOptimized {
    public int frogJump(int[] heights) {
        int n = heights.length;

        if (n < 2)
            return 0;

        int a = 0;// index-2
        int b = Math.abs(heights[0] - heights[1]);// index-1

        for (int index = 2; index < heights.length; index++) {
            // i-1
            int step1 = Math.abs(heights[index] - heights[index - 1]) + b;

            // i-2
            int step2 = Integer.MAX_VALUE;

            if (index - 2 >= 0) {
                step2 = Math.abs(heights[index] - heights[index - 2]) + a;
            }

            int c = Math.min(step1, step2);
            a = b;
            b = c;
        }

        return b;
    }
}

public class FrogJump {
    public static void main(String[] args) {

    }
}
