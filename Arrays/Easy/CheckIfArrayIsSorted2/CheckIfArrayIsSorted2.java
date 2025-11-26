package Arrays.Easy.CheckIfArrayIsSorted2;
// https://takeuforward.org/practice/dsa/check-if-the-array-is-sorted-i?tab=problem

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    boolean arraySortedOrNot(int[] nums, int n) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                return false;
        }
        return true;
    }
}

public class CheckIfArrayIsSorted2 {
    public static void main(String[] args) {

    }
}
