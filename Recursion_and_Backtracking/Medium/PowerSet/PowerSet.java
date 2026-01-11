package Recursion_and_Backtracking.Medium.PowerSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://takeuforward.org/practice/dsa/power-set?category=implementation-problems&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem
// https://leetcode.com/problems/subsets/

// Does not eliminate duplicate subsets when the input contains duplicate values.
// Time Complexity: O(n.2^n)
class Solution_Pick_NotPick {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(0, nums, subset, res);

        return res;
    }

    private void dfs(int index, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // not pick
        dfs(index + 1, nums, subset, res);

        // pick
        subset.add(nums[index]);
        dfs(index + 1, nums, subset, res);
        subset.remove(subset.size() - 1);
    }
}

// Loop-based backtracking
// Time Complexity: O(n.2^n)
class Solution_SkipDuplicates {
    public List<List<Integer>> powerSet(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(0, nums, subset, res);

        return res;
    }

    private void dfs(int index, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;

            subset.add(nums[i]);
            dfs(i + 1, nums, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}

public class PowerSet {
    public static void main(String[] args) {

    }
}
