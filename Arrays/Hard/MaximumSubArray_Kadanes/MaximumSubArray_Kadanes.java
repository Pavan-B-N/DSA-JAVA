package Arrays.Hard.MaximumSubArray_Kadanes;
// https://leetcode.com/problems/maximum-subarray/
// https://takeuforward.org/practice/dsa/kadane's-algorithm?category=faqs-medium&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }
}

public class MaximumSubArray_Kadanes {
    public static void main(String[] args) {

    }
}
