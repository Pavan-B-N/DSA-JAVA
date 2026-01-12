package Recursion_and_Backtracking.Medium.Subsets1;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/subsets-i?category=faqs-medium&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(2^N)
// Space Complexity: O(2^N * N) for storing all subsets
class Solution {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        subsetSums(n - 1, 0, nums, res);
        return res;
    }

    private void subsetSums(int index, int sum, int[] nums, List<Integer> res) {
        if (index == 0) {
            res.add(sum); // notPick
            res.add(sum + nums[index]); // pick

            return;
        }

        // not pick
        subsetSums(index - 1, sum, nums, res);

        // pick
        subsetSums(index - 1, sum + nums[index], nums, res);
    }
}

public class Subsets1 {
    public static void main(String[] args) {

    }
}
