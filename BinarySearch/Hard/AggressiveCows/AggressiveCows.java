package BinarySearch.Hard.AggressiveCows;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/aggressive-cows?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem&solution=linear-search

// Time Complexity: O(N log N + N * log(max - min))
// Space Complexity: O(1)
class Solution {
    public int aggressiveCows(int[] nums, int k) {
        // binary search on distance
        // Pattern : min of max

        Arrays.sort(nums);

        int start = 1;
        int end = Arrays.stream(nums).max().getAsInt() - Arrays.stream(nums).min().getAsInt();

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (countCows(nums, mid) >= k) {
                // ans
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;

    }

    private int countCows(int[] nums, int minDist) {
        int count = 1;
        int prevPos = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[prevPos] >= minDist) {
                count++;
                prevPos = i;
            }
        }

        return count;

    }

}

public class AggressiveCows {
    public static void main(String[] args) {

    }
}
