package SlidingWindow_TwoPointer.Hard.MaxConsecutiveOnes3;
// https://leetcode.com/problems/max-consecutive-ones-iii/
// https://takeuforward.org/practice/dsa/max-consecutive-ones-iii?category=longest-and-smallest-window-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1) two pointers
class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[i] == 0)
                    zeroCount--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1) two pointers
class Solution_Optimal {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeroCount++;
            }

            if (zeroCount > k) {
                if (nums[i] == 0)
                    zeroCount--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}

public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        
    }
}
