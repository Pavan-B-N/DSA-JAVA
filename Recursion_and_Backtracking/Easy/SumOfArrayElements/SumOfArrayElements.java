package Recursion_and_Backtracking.Easy.SumOfArrayElements;
// https://takeuforward.org/practice/dsa/sum-of-array-elements-ii?category=basic-recursion&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(N) recursion stack
class Solution {
    public int arraySum(int[] nums) {
        int n = nums.length;
        return arraySum(n - 1, nums);
    }

    private int arraySum(int index, int[] nums) {
        if (index == 0)
            return nums[0];

        return nums[index] + arraySum(index - 1, nums);
    }
}

public class SumOfArrayElements {
    public static void main(String[] args) {

    }
}
