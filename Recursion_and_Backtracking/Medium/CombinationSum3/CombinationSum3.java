package Recursion_and_Backtracking.Medium.CombinationSum3;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/combination-sum-iii?category=faqs-medium&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/combination-sum-iii/

// Time Complexity: O(C(9, K) * K)
// Space Complexity: O(K) recursion stack
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        combinationSum3(1, n, k, subset, res);

        return res;
    }

    private void combinationSum3(
            int digit, int target, final int len, List<Integer> subset, List<List<Integer>> res) {
        if (digit == 10 || target == 0 || subset.size() == len) {
            if (subset.size() == len && target == 0) {
                res.add(new ArrayList<>(subset));
            }
            return;
        }

        // notPick
        combinationSum3(digit + 1, target, len, subset, res);

        // pick
        if (target >= digit) {
            subset.add(digit);
            combinationSum3(digit + 1, target - digit, len, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}

public class CombinationSum3 {
    public static void main(String[] args) {

    }
}
