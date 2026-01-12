package Recursion_and_Backtracking.Medium.Subset2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://takeuforward.org/practice/dsa/subsets-ii?category=faqs-medium&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/subsets-ii/

// Time Complexity: O(2^N * N)
// Space Complexity: O(N) recursion stack
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        subsetsWithDup(0, nums, subset, res);

        return res;

    }

    private void subsetsWithDup(int index, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;

            subset.add(nums[i]);
            subsetsWithDup(i + 1, nums, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}

public class Subset2 {
    public static void main(String[] args) {

    }
}
