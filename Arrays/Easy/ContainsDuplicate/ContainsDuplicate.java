package Arrays.Easy.ContainsDuplicate;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
        }

        return false;
    }
}

public class ContainsDuplicate {
    public static void main(String[] args) {

    }
}
