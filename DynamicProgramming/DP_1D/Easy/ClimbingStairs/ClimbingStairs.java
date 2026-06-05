package DynamicProgramming.DP_1D.Easy.ClimbingStairs;
import java.util.Arrays;

// https://leetcode.com/problems/climbing-stairs/description/
// https://takeuforward.org/practice/dsa/climbing-stairs?category=1d-dp&source=strivers-a2z-dsa-sheet

// Time Complexity: O(2^n)
// Space Complexity: O(1), recursion stack space = (n)
class Solution_Recursive {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n = dp), recursion stack space = (n)
class Solution_Memoization {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return climbStairs(n, dp);
    }

    private int climbStairs(int n, int[] dp) {
        if (n == 1 || n == 2) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n = dp)
class Solution_Tabulation {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution_SpaceOptimized {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int a = 1;
        int b = 2;

        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}

public class ClimbingStairs {
    public static void main(String[] args) {

    }
}
