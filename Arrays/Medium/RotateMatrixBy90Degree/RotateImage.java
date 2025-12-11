package Arrays.Medium.RotateMatrixBy90Degree;
// https://leetcode.com/problems/rotate-image/
// https://takeuforward.org/practice/dsa/rotate-matrix-by-90-degrees

// Time Complexity: O(N^2)
// Space Complexity: O(1) in-place transpose and reverse
class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }

    }

    private void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
}

public class RotateImage {
    public static void main(String[] args) {

    }
}
