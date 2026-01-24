package BinarySearch.Medium.MinDaysToMakeMBouquets;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/minimum-days-to-make-m-bouquets?category=on-answers&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

// Time Complexity: O(N * log(max(bloomDay) - min(bloomDay)))
// Space Complexity: O(1)
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) k * m > n)
            return -1;

        int start = Arrays.stream(bloomDay).min().getAsInt();
        int end = Arrays.stream(bloomDay).max().getAsInt();

        while (start <= end) {
            int mid = start + (end - start) / 2; // day

            long bouquets = getBouquets(bloomDay, mid, k);

            if (bouquets >= m) {
                // ans
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private long getBouquets(int[] nums, int day, int k) {
        long bouquets = 0;
        long roses = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= day) {
                roses++;
            } else {
                roses = 0;
            }

            if (roses == k) {
                bouquets++;
                roses = 0;
            }
        }

        return bouquets;
    }
}

public class MinDaysToMakeMBouquets {
    public static void main(String[] args) {

    }
}
