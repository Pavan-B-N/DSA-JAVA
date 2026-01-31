package BinarySearch.Hard.MatrixMedian;
// https://takeuforward.org/practice/dsa/matrix-median?category=2d-arrays&source=strivers-a2z-dsa-sheet

// Time Complexity: O(32 * N * log M)
// Space Complexity: O(1)
class Solution {
    public int findMedian(int[][] matrix) {
        int start = 1;
        int end = (int) 1e9;

        int m = matrix.length;
        int n = matrix[0].length;

        int total = n * m;
        int left = total / 2;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (countLessThanEquals(mid, matrix) <= left) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    private int countLessThanEquals(int num, int[][] matrix) {
        int count = 0;

        for (int[] row : matrix) {
            int index = upperBound(row, num);
            count += index;
        }

        return count;
    }

    // Returns the first index whose value is greater than num
    private int upperBound(int[] row, int num) {
        int low = 0;
        int high = row.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (row[mid] <= num) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}

public class MatrixMedian {
    public static void main(String[] args) {

    }
}
