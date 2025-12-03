package Arrays.Easy.MoveZeroesToEnd;
// https://leetcode.com/problems/move-zeroes/
// https://takeuforward.org/practice/dsa/move-zeros-to-end

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }

        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

public class MoveZeroesToEnd {
    public static void main(String[] args) {

    }
}
