package Arrays.Medium.TwoSum;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
// https://takeuforward.org/practice/dsa/two-sum

// Time Complexity: O(N)
// Space Complexity: O(N) for hash map
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();// ele -> index

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (hashMap.containsKey(diff)) {
                return new int[] { hashMap.get(diff), i };
            }

            hashMap.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}

public class TwoSum {
    public static void main(String[] args) {

    }
}
