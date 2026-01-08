package Recursion_and_Backtracking.Medium.CombinationSum2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://takeuforward.org/practice/dsa/combination-sum-ii?category=faqs-medium&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/combination-sum-ii/

// Time Complexity: O(2^N * K)
// Space Complexity: O(K) recursion stack
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        combinationSum2(0, target, candidates, subset, res);

        return res;
    }

    private void combinationSum2(
            int index, int target, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(subset));
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;

            if (target >= nums[i]) {
                subset.add(nums[i]);
                combinationSum2(i + 1, target - nums[i], nums, subset, res);
                subset.remove(subset.size() - 1);
            }
        }
    }
}

public class CombinationSum2 {
    public static void main(String[] args) {

    }
}
