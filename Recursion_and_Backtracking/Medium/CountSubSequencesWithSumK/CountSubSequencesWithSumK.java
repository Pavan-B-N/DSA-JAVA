package Recursion_and_Backtracking.Medium.CountSubSequencesWithSumK;
// https://takeuforward.org/practice/dsa/count-all-subsequences-with-sum-k?category=subsequence-pattern-problems&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(2^N)
// Space Complexity: O(N) recursion stack
class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        int n = nums.length;

        return countSubsequenceWithTargetSum(n - 1, nums, k);
    }

    private int countSubsequenceWithTargetSum(int index, int[] nums, int target) {
        if (index == 0) {
            int count = 0;
            if (nums[0] - target == 0)
                count++;
            if (target == 0)
                count++;

            return count;
        }

        int notPick = countSubsequenceWithTargetSum(index - 1, nums, target);

        int pick = 0;

        if (target >= nums[index]) {
            pick = countSubsequenceWithTargetSum(index - 1, nums, target - nums[index]);
        }

        return pick + notPick;
    }
}

public class CountSubSequencesWithSumK {
    public static void main(String[] args) {

    }
}
