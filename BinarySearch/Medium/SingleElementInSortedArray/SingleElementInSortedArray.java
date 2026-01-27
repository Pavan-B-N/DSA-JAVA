package BinarySearch.Medium.SingleElementInSortedArray;
// https://leetcode.com/problems/single-element-in-a-sorted-array/
// https://takeuforward.org/practice/dsa/single-element-in-sorted-array?category=logic-building&source=strivers-a2z-dsa-sheet

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int n = nums.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            boolean left = (mid - 1 >= 0 && nums[mid - 1] == nums[mid]);
            boolean right = (mid + 1 < n && nums[mid + 1] == nums[mid]);

            if (!left && !right) {
                return nums[mid];
            }
            // left
            else if ((mid % 2 == 0 && right) || (mid % 2 == 1 && left)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}

public class SingleElementInSortedArray {
    public static void main(String[] args) {

    }
}
