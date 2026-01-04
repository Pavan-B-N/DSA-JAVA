package Hashing.Medium.LongestSubArrayWithSum0;
import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/practice/dsa/largest-subarray-with-sum-0?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(N) for prefix sum map
class Solution {
    public int maxLen(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>(); // {prefixSum -> index}
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == 0)
                maxLen = i + 1;

            int remainderSum = prefixSum - 0;

            if (hashMap.containsKey(remainderSum)) {
                maxLen = Math.max(maxLen, i - hashMap.get(remainderSum));
            }

            hashMap.putIfAbsent(prefixSum, i);
        }
        return maxLen;
    }
}

public class LongestSubArrayWithSum0 {
    public static void main(String[] args) {

    }
}
