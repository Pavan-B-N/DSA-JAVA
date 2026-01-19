package BinarySearch.Easy.FloorAndCeilInSortedArray;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/floor-and-ceil-in-sorted-array?category=logic-building&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int[] getFloorAndCeil(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int floor = -1;
        int ceil = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return new int[] { nums[mid], nums[mid] };
            } else if (nums[mid] > target) {
                end = mid - 1;
                ceil = nums[mid];
            } else {
                start = mid + 1;
                floor = nums[mid];
            }
        }

        return new int[] { floor, ceil };
    }
}

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution_OppositePolarity {
    public int[] getFloorAndCeil(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return new int[] { nums[mid], nums[mid] };
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        int[] res = new int[2];
        Arrays.fill(res, -1);

        if (end != -1) {
            res[0] = nums[end];
        }

        if (start != nums.length) {
            res[1] = nums[start];
        }

        return new int[] { res[0], res[1] };
    }
}

public class FloorAndCeilInSortedArray {
    public static void main(String[] args) {

    }
}
