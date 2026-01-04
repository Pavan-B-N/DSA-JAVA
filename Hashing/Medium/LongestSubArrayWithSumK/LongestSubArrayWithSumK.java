package Hashing.Medium.LongestSubArrayWithSumK;
import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/practice/dsa/longest-subarray-with-sum-k?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(N) for hash map
class Solution {
  public int longestSubarray(int[] nums, int k) {
    Map<Integer, Integer> hashMap = new HashMap<>(); // {prefixSum -> index}
    int prefixSum = 0;
    int maxLen = 0;

    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];

      if (prefixSum == k) maxLen = i + 1;

      int remainderSum = prefixSum - k;

      if (hashMap.containsKey(remainderSum)) {
        maxLen = Math.max(maxLen, i - hashMap.get(remainderSum));
      }

      hashMap.putIfAbsent(prefixSum, i);
    }
    return maxLen;
  }
}


public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        
    }
}
