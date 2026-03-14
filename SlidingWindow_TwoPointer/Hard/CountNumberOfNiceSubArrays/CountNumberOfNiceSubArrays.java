package SlidingWindow_TwoPointer.Hard.CountNumberOfNiceSubArrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-number-of-nice-subarrays/description/
// https://takeuforward.org/practice/dsa/count-number-of-nice-subarrays?category=counting-subarrays-and-substrings-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1) sliding window (atMost(K) - atMost(K-1))
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();// oddCount -> subArrayCount

        int count = 0;
        int oddCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                oddCount++;
            }

            if (oddCount == k) {
                count++;
            }

            int remainder = oddCount - k;
            if (hashMap.containsKey(remainder)) {
                count += hashMap.get(remainder);
            }

            hashMap.put(oddCount, hashMap.getOrDefault(oddCount, 0) + 1);
        }

        return count;
    }
}

public class CountNumberOfNiceSubArrays {
    public static void main(String[] args) {

    }
}
