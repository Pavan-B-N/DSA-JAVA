package BinarySearch.Medium.FindMinimumInRotatedSortedArray;
import java.util.ArrayList;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// https://takeuforward.org/practice/dsa/find-minimum-in-rotated-sorted-array?category=logic-building&source=strivers-a2z-dsa-sheet

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int peak = findPeak(nums);

        return nums[(peak + 1) % n];
    }

    private int findPeak(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[start] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return nums.length - 1;
    }
}

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution_CollectionFrameworkType {
    public int findMin(ArrayList<Integer> arr) {
        int n = arr.size();

        int[] nums = arr.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int peak = findPeak(nums);

        return arr.get((peak + 1) % n);
    }

    private int findPeak(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[start] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return nums.length - 1;
    }
}

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {

    }
}
