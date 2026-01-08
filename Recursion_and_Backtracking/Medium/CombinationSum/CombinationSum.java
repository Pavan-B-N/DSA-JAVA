package Recursion_and_Backtracking.Medium.CombinationSum;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/combination-sum?category=faqs-medium&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/combination-sum/description/

// Time Complexity: O(2^T * K) where T = target, K = average length
// Space Complexity: O(K) recursion stack
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        combinationSum(0, target, nums, subset, res);

        return res;
    }

    private void combinationSum(
            int index, int target, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        if (target == 0 || index == nums.length) {
            if (target == 0) {
                res.add(new ArrayList<>(subset));
            }

            return;
        }

        // not Pick
        combinationSum(index + 1, target, nums, subset, res);

        // pick
        if (target >= nums[index]) {
            subset.add(nums[index]);
            combinationSum(index, target - nums[index], nums, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}

public class CombinationSum {
    public static void main(String[] args) {

    }
}
