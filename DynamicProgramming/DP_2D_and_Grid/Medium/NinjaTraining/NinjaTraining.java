package DynamicProgramming.DP_2D_and_Grid.Medium.NinjaTraining;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/ninja's-training?category=2d-dp&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N * 4 * 3) = O(N)
// Space Complexity: O(4) = O(1) space optimized
class Solution {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        return ninjaTraining(n - 1, -1, matrix);
    }

    private int ninjaTraining(int day, int prev, int[][] matrix) {
        if (day < 0) {
            return 0;
        }

        int maxMerit = 0;

        for (int task = 0; task < 3; task++) {
            if (prev != task) {
                int merit = matrix[day][task] + ninjaTraining(day - 1, task, matrix);

                maxMerit = Math.max(maxMerit, merit);
            }
        }

        return maxMerit;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][4];
        // prev is applied shift index technique i.e prev[-1] = prev[-1+1]

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return ninjaTraining(n - 1, -1, matrix, dp);
    }

    private int ninjaTraining(int day, int prev, int[][] matrix, int[][] dp) {
        if (day < 0) {
            return 0;
        }

        if (dp[day][prev + 1] != -1) {
            return dp[day][prev + 1];
        }

        int maxMerit = 0;

        for (int task = 0; task < 3; task++) {
            if (prev != task) {
                int merit = matrix[day][task] + ninjaTraining(day - 1, task, matrix, dp);

                maxMerit = Math.max(maxMerit, merit);
            }
        }

        return dp[day][prev + 1] = maxMerit;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][4];
        // prevTask is applied shift index technique i.e prevTask[-1] = prevTask[-1+1]

        // day == 0, base case
        for (int prevTask = 2; prevTask >= -1; prevTask--) {
            int maxMerit = 0;
            for (int task = 0; task < 3; task++) {
                if (task != prevTask) {
                    int merit = matrix[0][task];

                    maxMerit = Math.max(maxMerit, merit);
                }
            }

            dp[0][prevTask + 1] = maxMerit;
        }

        for (int day = 1; day < n; day++) {
            for (int prevTask = 2; prevTask >= -1; prevTask--) {
                int maxMerit = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != prevTask) {
                        int merit = matrix[day][task] + dp[day - 1][task + 1];

                        maxMerit = Math.max(maxMerit, merit);
                    }
                }

                dp[day][prevTask + 1] = maxMerit;
            }
        }

        return dp[n - 1][0];
    }
}

public class NinjaTraining {
    public static void main(String[] args) {

    }
}
