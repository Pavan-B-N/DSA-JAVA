package Arrays.Medium.LongestSumArrayWithSumK;
// https://takeuforward.org/plus/dsa/problems/longest-subarray-with-sum-k?source=strivers-a2z-dsa-track

import java.util.Map;
import java.util.HashMap;

// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public int longestSubarray(int[] nums, int k) {
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}

// prefixSum + HashMap
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution_Optimal {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>(); // {prefixSum -> index}

        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == k) {
                maxLen = i + 1;
            }

            int diff = prefixSum - k;

            if (hashMap.containsKey(diff)) {
                int len = i - hashMap.get(diff);
                maxLen = Math.max(maxLen, len);
            }

            if (!hashMap.containsKey(prefixSum)) {
                hashMap.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}

public class LongestSumArrayWithSumK {
    public static void main(String[] args) {

    }
}
