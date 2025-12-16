package Arrays.Medium.SpriralMatrix;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
// https://takeuforward.org/practice/dsa/print-the-matrix-in-spiral-manner

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        List<Integer> list = new ArrayList<>();

        while (top <= bottom && left <= right) {
            // print top
            for (int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }
            top++;

            // print right
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            // print bottom
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    list.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // print left
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}

public class SpriralMatrix {
    public static void main(String[] args) {

    }
}
