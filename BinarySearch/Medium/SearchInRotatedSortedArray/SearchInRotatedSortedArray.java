package BinarySearch.Medium.SearchInRotatedSortedArray;
// https://leetcode.com/problems/search-in-rotated-sorted-array/
// https://takeuforward.org/practice/dsa/search-in-rotated-sorted-array-i?category=logic-building&source=strivers-a2z-dsa-sheet

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // left sorted
            else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // right sorted
            else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }

        return -1;
    }
}

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {

    }
}
