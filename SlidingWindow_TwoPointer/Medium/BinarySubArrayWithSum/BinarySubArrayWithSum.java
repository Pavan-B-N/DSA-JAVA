package SlidingWindow_TwoPointer.Medium.BinarySubArrayWithSum;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/binary-subarrays-with-sum/description/
// https://takeuforward.org/practice/dsa/binary-subarrays-with-sum?category=counting-subarrays-and-substrings-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> hashMap = new HashMap<>();// {prefixSum -> count}

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == goal)
                count++;

            int remainderSum = prefixSum - goal;

            if (hashMap.containsKey(remainderSum)) {
                count += hashMap.get(remainderSum);
            }

            hashMap.put(prefixSum, hashMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution_Optimal {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int a = countSubarraySumLessThanGoal(nums, goal);
        int b = countSubarraySumLessThanGoal(nums, goal - 1);

        return a - b;
    }

    private int countSubarraySumLessThanGoal(int[] nums, int goal) {
        if (goal < 0)
            return 0;

        int count = 0;
        int sum = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (sum > goal) {
                sum -= nums[i++];
            }

            count += (j - i + 1);
        }

        return count;
    }
}

public class BinarySubArrayWithSum {
    public static void main(String[] args) {

    }
}
