package BinarySearch.Medium.FindSmallestDivisor;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/find-the-smallest-divisor?category=on-answers&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

// Time Complexity: O(N * log(max(nums)))
// Space Complexity: O(1)
class Solution {
    public int smallestDivisor(int[] nums, int limit) {
        int maxValue = Arrays.stream(nums).max().getAsInt();

        int start = 1;
        int end = maxValue;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long sum = getDivisorsSum(mid, nums, limit);

            if (sum <= limit) {
                // ans
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private long getDivisorsSum(long divisor, int[] nums, int threshold) {
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            res += Math.ceil(((double) nums[i] / divisor));
            // res += (nums[i] + divisor - 1) / divisor;

            if (res > threshold)
                return res;
        }

        return res;
    }
}

public class FindSmallestDivisor {
    public static void main(String[] args) {

    }
}
