package SlidingWindow_TwoPointer.Hard.CountSubarraysWithKDifferentIntegers;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarrays-with-k-different-integers/description/
// https://takeuforward.org/practice/dsa/subarrays-with-k-different-integers?category=counting-subarrays-and-substrings-problems&source=strivers-a2z-dsa-sheet&tab=problem&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(N) for frequency maps with two pointers
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        if (k < 0)
            return 0;

        int count = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();// {ele -> freq}

        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            hashMap.put(nums[j], hashMap.getOrDefault(nums[j], 0) + 1);

            while (hashMap.size() > k) {
                hashMap.put(nums[i], hashMap.get(nums[i]) - 1);

                if (hashMap.get(nums[i]) == 0) {
                    hashMap.remove(nums[i]);
                }

                i++;
            }

            // valid window
            count += (j - i + 1);
        }

        return count;
    }
}

public class CountSubarraysWithKDifferentIntegers {
    public static void main(String[] args) {

    }
}
