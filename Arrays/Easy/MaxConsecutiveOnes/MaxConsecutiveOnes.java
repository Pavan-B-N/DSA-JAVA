package Arrays.Easy.MaxConsecutiveOnes;
// https://leetcode.com/problems/max-consecutive-ones/
// https://takeuforward.org/practice/dsa/maximum-consecutive-ones

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }

            maxOnes = Math.max(maxOnes, count);
        }

        return maxOnes;
    }
}

public class MaxConsecutiveOnes {
    public static void main(String[] args) {

    }
}
