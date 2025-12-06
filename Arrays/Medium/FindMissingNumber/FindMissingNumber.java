package Arrays.Medium.FindMissingNumber;
import java.util.HashSet;
import java.util.Set;

// https://takeuforward.org/practice/dsa/find-missing-number
// https://leetcode.com/problems/missing-number/

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }

        return -1; // unreachable code
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution_CyclicSort {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != n && nums[i] != i) {
                swap(nums, i, nums[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return n;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

public class FindMissingNumber {
    public static void main(String[] args) {

    }
}
