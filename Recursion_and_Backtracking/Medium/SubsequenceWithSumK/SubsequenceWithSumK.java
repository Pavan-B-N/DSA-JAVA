package Recursion_and_Backtracking.Medium.SubsequenceWithSumK;
// https://takeuforward.org/practice/dsa/check-if-there-exists-a-subsequence-with-sum-k?category=subsequence-pattern-problems&source=strivers-a2z-dsa-sheet&sidebar=0
// Time Complexity: O(2^N)
// Space Complexity: O(N) recursion stack
class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        int n = nums.length;

        return checkSubsequenceSum(n - 1, nums, k);
    }

    private boolean checkSubsequenceSum(int index, int[] nums, int target) {
        if (index == 0 || target == 0) {
            if (target - nums[0] == 0 || target == 0)
                return true;
            return false;
        }

        boolean notPick = checkSubsequenceSum(index - 1, nums, target);

        if (notPick)
            return true;

        boolean pick = false;

        if (target >= nums[index]) {
            pick = checkSubsequenceSum(index - 1, nums, target - nums[index]);
        }

        return pick;
    }
}

public class SubsequenceWithSumK {
    public static void main(String[] args) {

    }
}
