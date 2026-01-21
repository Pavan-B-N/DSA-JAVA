package BinarySearch.Medium.FindPeakElement2;
// https://takeuforward.org/practice/dsa/find-peak-element-ii?category=2d-arrays&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N log M)
// Space Complexity: O(1)
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        // Binary search on columns
        int m = mat.length;
        int n = mat[0].length;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int maxRow = 0;

            for (int i = 1; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            boolean left = (mid - 1 >= 0)
                    ? mat[maxRow][mid] > mat[maxRow][mid - 1]
                    : true;

            boolean right = (mid + 1 < n)
                    ? mat[maxRow][mid] > mat[maxRow][mid + 1]
                    : true;

            if (left && right) {
                return new int[] { maxRow, mid };
            } else if (mid - 1 >= 0
                    && mat[maxRow][mid - 1] > mat[maxRow][mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[] { -1, -1 };
    }
}

public class FindPeakElement2 {
    public static void main(String[] args) {

    }
}
