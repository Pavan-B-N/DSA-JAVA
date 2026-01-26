package BinarySearch.Medium.SearchIn2DMatrix2;
// https://leetcode.com/problems/search-a-2d-matrix-ii/description/
// https://takeuforward.org/practice/dsa/search-in-2d-matrix-ii?category=2d-arrays&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N + M)
// Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}

public class SearchIn2DMatrix2 {
    public static void main(String[] args) {

    }
}
