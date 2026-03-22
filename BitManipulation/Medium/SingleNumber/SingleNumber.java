package BitManipulation.Medium.SingleNumber;
// https://leetcode.com/problems/single-number/description/
// https://takeuforward.org/plus/dsa/problems/single-number---i?source=strivers-a2z-dsa-track

import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();// {ele -> freq}

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> pair : hashMap.entrySet()) {
            if (pair.getValue() == 1)
                return pair.getKey();
        }

        return -1;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
class SolutionXor {
    public int singleNumber(int[] nums) {
        int xorVal = 0;

        for (int i = 0; i < nums.length; i++) {
            xorVal ^= nums[i];
        }

        return xorVal;
    }
}

public class SingleNumber {
    public static void main(String[] args) {

    }
}
