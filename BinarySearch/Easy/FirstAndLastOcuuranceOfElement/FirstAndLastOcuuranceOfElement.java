package BinarySearch.Easy.FirstAndLastOcuuranceOfElement;
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// https://takeuforward.org/practice/dsa/first-and-last-occurrence?category=logic-building&source=strivers-a2z-dsa-sheet

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirstOccurance(nums, target);
        if (first == -1) {
            return new int[] { -1, -1 };
        }

        int second = findLastOccurance(nums, target);

        return new int[] { first, second };
    }

    private int findFirstOccurance(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private int findLastOccurance(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}

public class FirstAndLastOcuuranceOfElement {
    public static void main(String[] args) {

    }
}
