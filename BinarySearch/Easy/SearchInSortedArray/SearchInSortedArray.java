package BinarySearch.Easy.SearchInSortedArray;
// https://leetcode.com/problems/binary-search/
// https://takeuforward.org/practice/dsa/search-x-in-sorted-array?category=fundamentals&source=strivers-a2z-dsa-sheet

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
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}

public class SearchInSortedArray {
    public static void main(String[] args) {

    }
}
