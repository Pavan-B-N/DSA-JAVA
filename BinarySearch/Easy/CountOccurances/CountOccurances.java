package BinarySearch.Easy.CountOccurances;
// https://takeuforward.org/practice/dsa/count-occurrences-in-a-sorted-array?category=logic-building&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int countOccurrences(int[] arr, int target) {
        int first = findFirstOccurance(arr, target);
        if (first == arr.length) {
            return 0;
        }

        int second = findLastOccurance(arr, target);

        return second - first + 1;
    }

    private int findFirstOccurance(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

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

    private int findLastOccurance(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }

        return end;
    }
}

public class CountOccurances {
    public static void main(String[] args) {

    }
}
