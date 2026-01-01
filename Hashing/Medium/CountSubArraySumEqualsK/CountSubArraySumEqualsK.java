package Hashing.Medium.CountSubArraySumEqualsK;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/
// https://takeuforward.org/practice/dsa/count-subarrays-with-given-sum?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(N) for prefix sum frequency map
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();// {prefixSum -> count}

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == k)
                count++;

            int remainderSum = prefixSum - k;

            if (hashMap.containsKey(remainderSum)) {
                count += hashMap.get(remainderSum);
            }

            hashMap.put(prefixSum, hashMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

public class CountSubArraySumEqualsK {
    public static void main(String[] args) {

    }
}
