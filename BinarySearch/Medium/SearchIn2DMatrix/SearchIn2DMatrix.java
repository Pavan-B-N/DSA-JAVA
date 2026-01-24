package BinarySearch.Medium.SearchIn2DMatrix;
// https://leetcode.com/problems/search-a-2d-matrix/description/
// https://takeuforward.org/practice/dsa/search-in-a-2d-matrix?category=2d-arrays&source=strivers-a2z-dsa-sheet

// Time Complexity: O(log(N * M))
// Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = (m * n) - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // mid == index
            int row = (mid / n);
            int col = (mid % n);

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}

public class SearchIn2DMatrix {
    public static void main(String[] args) {

    }
}
