package DynamicProgramming.KnapSack.Hard.RodCuttingProblem;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/rod-cutting-problem?category=dp-on-subsequences&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int RodCutting(int price[], int n) {
        return RodCutting(n - 1, n, price);
    }

    private int RodCutting(int index, int N, int[] price) {
        if (index == 0) {
            return price[0] * N;// or N/index+1 because 0+1 = 1;
        }

        int notPick = RodCutting(index - 1, N, price);
        int pick = Integer.MIN_VALUE;

        if (N >= (index + 1)) {
            pick = price[index] + RodCutting(index, N - (index + 1), price);
        }

        return Math.max(notPick, pick);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int RodCutting(int price[], int n) {
        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return RodCutting(n - 1, n, price, dp);
    }

    private int RodCutting(int index, int N, int[] price, int[][] dp) {
        if (index == 0) {
            return price[0] * N; // or N/index+1 because 0+1 = 1;
        }

        if (dp[index][N] != -1) {
            return dp[index][N];
        }

        int notPick = RodCutting(index - 1, N, price, dp);
        int pick = Integer.MIN_VALUE;

        if (N >= (index + 1)) {
            pick = price[index] + RodCutting(index, N - (index + 1), price, dp);
        }

        return dp[index][N] = Math.max(notPick, pick);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int RodCutting(int price[], int n) {
        int[][] dp = new int[n][n + 1];

        for (int N = 0; N <= n; N++) {
            dp[0][N] = price[0] * N;
        }

        for (int index = 1; index < n; index++) {
            for (int N = 0; N <= n; N++) {
                int notPick = dp[index - 1][N];
                int pick = Integer.MIN_VALUE;

                if (N >= (index + 1)) {
                    pick = price[index] + dp[index][N - (index + 1)];
                }

                dp[index][N] = Math.max(notPick, pick);
            }
        }

        return dp[n - 1][n];
    }
}

public class RodCuttingProblem {
    public static void main(String[] args) {

    }
}
