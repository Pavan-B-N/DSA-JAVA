package Arrays.Medium.RemoveDuplicatesFromSortedArray;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// https://takeuforward.org/practice/dsa/remove-duplicates-from-sorted-array

// Time Complexity: O(N)
// Space Complexity: O(1) in-place two pointers
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }

        return i + 1;
    }
}

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

    }
}
