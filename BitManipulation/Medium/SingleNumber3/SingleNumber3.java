package BitManipulation.Medium.SingleNumber3;
// https://takeuforward.org/practice/dsa/single-number---iii?category=problems&source=strivers-a2z-dsa-sheet&tab=problem&solution=optimal

// Time Complexity: O(N) using XOR partitioning
// Space Complexity: O(1)
class Solution {
    public int[] singleNumber(int[] nums) {
        int xorVal = 0;
        for (int ele : nums)
            xorVal ^= ele;

        // (xorVal & (xorVal - 1)) = unsets rightMostSetBit
        int rightMostSetBit = (xorVal & (xorVal - 1)) ^ xorVal;

        int a = 0;
        int b = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightMostSetBit) == 0) {
                a = a ^ nums[i];
            } else {
                b = b ^ nums[i];
            }
        }

        if (a < b)
            return new int[] { a, b };

        return new int[] { b, a };
    }
}

public class SingleNumber3 {
    public static void main(String[] args) {

    }
}
