package BinarySearch.Medium.FindRowWithMaximum1s;
// https://takeuforward.org/practice/dsa/find-row-with-maximum-1's?category=2d-arrays&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N + M) or O(N log M)
// Space Complexity: O(1)
class Solution {
    public int rowWithMax1s(int[][] mat) {
        int maxOnes = 0;
        int ans = -1;

        for (int i = 0; i < mat.length; i++) {
            int index = upperBound(mat[i]);

            if ((mat[i].length - index) > maxOnes) {
                maxOnes = mat[i].length - index;
                ans = i;
            }
        }

        return ans;
    }

    private int upperBound(int[] arr) {
        int target = 0;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                // ans
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}

public class FindRowWithMaximum1s {
    public static void main(String[] args) {

    }
}
