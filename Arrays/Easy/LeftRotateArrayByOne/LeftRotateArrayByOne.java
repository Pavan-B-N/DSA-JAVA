package Arrays.Easy.LeftRotateArrayByOne;
// https://takeuforward.org/practice/dsa/left-rotate-array-by-one

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public void rotateArrayByOne(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return;

        int key = nums[0];

        for (int i = 0; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[n - 1] = key;
    }
}

public class LeftRotateArrayByOne {
    public static void main(String[] args) {

    }
}
