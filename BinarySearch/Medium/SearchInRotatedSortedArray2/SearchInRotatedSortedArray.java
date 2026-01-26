package BinarySearch.Medium.SearchInRotatedSortedArray2;
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
// https://takeuforward.org/practice/dsa/search-in-rotated-sorted-array-2?category=logic-building&source=strivers-a2z-dsa-sheet

// Time Complexity: O(log N) avg, O(N) worst with duplicates
// Space Complexity: O(1)
class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if(nums[start]==nums[mid] && nums[mid]==nums[end]){
                start++;
                end--;
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

        return false;
    }
}

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        
    }
}
