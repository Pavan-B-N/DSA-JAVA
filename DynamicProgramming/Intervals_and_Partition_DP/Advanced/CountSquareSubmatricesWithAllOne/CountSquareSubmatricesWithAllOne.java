package DynamicProgramming.Intervals_and_Partition_DP.Advanced.CountSquareSubmatricesWithAllOne;
// https://takeuforward.org/practice/dsa/count-square-submatrices-with-all-one?category=dp-on-grids&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/count-square-submatrices-with-all-ones/

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    private boolean isAllOnes(int[][] matrix, int startRow, int startCol, int size) {
        for (int row = startRow; row < startRow + size; row++) {
            for (int col = startCol; col < startCol + size; col++) {
                if (matrix[row][col] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalSquares = 0;

        for (int startRow = 0; startRow < rows; startRow++) {
            for (int startCol = 0; startCol < cols; startCol++) {
                for (int size = 1; startRow + size <= rows && startCol + size <= cols; size++) {
                    if (isAllOnes(matrix, startRow, startCol, size)) {
                        totalSquares++;
                    }
                }
            }
        }

        return totalSquares;
    }
}

// Time Complexity: O(N * M)
// Space Complexity: O(N * M) or O(M) space optimized
class Solution_Better {
    private int squareSum(int[][] prefix, int startRow, int startCol, int size) {
        int bottom = startRow + size;
        int right = startCol + size;

        return prefix[bottom][right]
                - prefix[startRow][right]
                - prefix[bottom][startCol]
                + prefix[startRow][startCol];
    }

    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] prefix = new int[rows + 1][cols + 1];

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                prefix[row][col] = matrix[row - 1][col - 1]
                        + prefix[row - 1][col]
                        + prefix[row][col - 1]
                        - prefix[row - 1][col - 1];
            }
        }

        int totalSquares = 0;

        for (int startRow = 0; startRow < rows; startRow++) {
            for (int startCol = 0; startCol < cols; startCol++) {
                for (int size = 1; startRow + size <= rows && startCol + size <= cols; size++) {
                    int neededSum = size * size;

                    if (squareSum(prefix, startRow, startCol, size) == neededSum) {
                        totalSquares++;
                    }
                }
            }
        }

        return totalSquares;
    }
}

// Time Complexity: O(N * M)
// Space Complexity: O(N * M) or O(M) space optimized
class Solution_Optimal {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int totalSquares = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    dp[row][col] = 0;
                } else if (row == 0 || col == 0) {
                    dp[row][col] = 1;
                } else {
                    dp[row][col] = 1 + Math.min(dp[row - 1][col], Math.min(dp[row][col - 1], dp[row - 1][col - 1]));
                }

                totalSquares += dp[row][col];
            }
        }

        return totalSquares;
    }
}

public class CountSquareSubmatricesWithAllOne {
    public static void main(String[] args) {

    }
}
