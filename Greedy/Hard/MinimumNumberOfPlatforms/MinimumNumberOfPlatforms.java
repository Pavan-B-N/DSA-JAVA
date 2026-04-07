package Greedy.Hard.MinimumNumberOfPlatforms;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/minimum-number-of-platforms-required-for-a-railway?category=scheduling-and-interval-problems&source=strivers-a2z-dsa-sheet&tab=submissions

// Time Complexity: O(N log N)
// Space Complexity: O(1) using two pointers on sorted times
class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int i = 0;
        int j = 0;

        int n = Arrival.length;

        int currPlatforms = 0;
        int ans = 0;

        while (i < n && j < n) {
            if (Arrival[i] <= Departure[j]) {
                currPlatforms++;
                i++;
            } else {
                currPlatforms--;
                j++;
            }

            ans = Math.max(currPlatforms, ans);
        }

        return ans;
    }
}

public class MinimumNumberOfPlatforms {
    public static void main(String[] args) {

    }
}
