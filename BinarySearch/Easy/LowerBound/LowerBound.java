package BinarySearch.Easy.LowerBound;
// https://takeuforward.org/practice/dsa/lower-bound-?category=fundamentals&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int lowerBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int ans = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution_OppositePolarity {
    public int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}

public class LowerBound {
    public static void main(String[] args) {

    }
}
