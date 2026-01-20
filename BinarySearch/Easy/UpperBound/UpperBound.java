package BinarySearch.Easy.UpperBound;
// https://takeuforward.org/practice/dsa/upper-bound?category=fundamentals&source=strivers-a2z-dsa-sheet

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int upperBound(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}

public class UpperBound {
    public static void main(String[] args) {

    }
}
