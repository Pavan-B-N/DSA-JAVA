package DynamicProgramming.DP_2D_and_Grid.Medium.MinTriangleSum;
// https://takeuforward.org/practice/dsa/triangle?category=dp-on-grids&source=strivers-a2z-dsa-sheet&sidebar=0&tab=submissions&solution=tabulation
// https://leetcode.com/problems/triangle/

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public int minTriangleSum(int[][] triangle) {

        int m = triangle.length;
        int n = triangle[m - 1].length;

        int minPathSum = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            int sum = helper(m - 1, j, triangle);

            minPathSum = Math.min(minPathSum, sum);
        }

        return minPathSum;
    }

    private int helper(int i, int j, int[][] triangle) {
        if (i < 0 || j < 0 || j >= triangle[i].length) {
            return (int) 1e9;
        }

        if (i == 0 && j == 0) {
            return triangle[0][0];
        }

        int top = helper(i - 1, j, triangle);
        int topLeft = helper(i - 1, j - 1, triangle);

        return triangle[i][j] + Math.min(top, topLeft);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int minTriangleSum(int[][] triangle) {

        int m = triangle.length;
        int n = triangle[m - 1].length;

        int[][] dp = new int[m][];

        // create dp array
        for (int i = 0; i < m; i++) {
            dp[i] = new int[i + 1];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = triangle[0][0];
                } else {
                    int top = (int) 1e9;

                    if (i - 1 >= 0 && j < triangle[i - 1].length) {
                        top = dp[i - 1][j];
                    }

                    int topLeft = (int) 1e9;

                    if (i - 1 >= 0 && j - 1 >= 0) {
                        topLeft = dp[i - 1][j - 1];
                    }

                    dp[i][j] = triangle[i][j] + Math.min(top, topLeft);
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[m - 1][j]);
        }

        return ans;
    }
}

public class MinTriangleSum {
    public static void main(String[] args) {

    }
}
