package BinarySearch.Medium.KokoEatingBananas;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/koko-eating-bananas?category=on-answers&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/koko-eating-bananas/

// Time Complexity: O(N * log(max(piles)))
// Space Complexity: O(1)
class Solution {
    public int minimumRateToEatBananas(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long requiredTime = timeToEatBananas(mid, piles, h);

            if (requiredTime <= h) {
                // ans
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private long timeToEatBananas(int bananas, int[] nums, int H) {
        long time = 0;

        for (int i = 0; i < nums.length; i++) {
            time += Math.ceil(((double) nums[i] / bananas));

            if (time > H)
                return time;
        }

        return time;
    }
}

public class KokoEatingBananas {
    public static void main(String[] args) {

    }
}
