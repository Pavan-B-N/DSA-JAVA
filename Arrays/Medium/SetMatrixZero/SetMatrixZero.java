package Arrays.Medium.SetMatrixZero;
// https://leetcode.com/problems/set-matrix-zeroes/
// https://takeuforward.org/practice/dsa/set-matrix-zeroes?category=faqs-medium&source=strivers-a2z-dsa-sheet&sidebar=0

import java.util.Arrays;;

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rows = new int[m];
        int[] cols = new int[n];

        Arrays.fill(rows, 1);
        Arrays.fill(cols, 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 0;
                    cols[j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 0 || cols[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution_Optimal {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int col0 = 1;
        int row0 = 1;

        // scan cols
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0)
                col0 = 0;
        }

        // scal rows
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                row0 = 0;
        }

        // scan subMatrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // update subMatrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // update tracker rows
        if (row0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        // update tracker cols
        if (col0 == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

    }
}

public class SetMatrixZero {
    public static void main(String[] args) {

    }
}
