package BinarySearch.Medium.MinCapacityToShipPackagesWithinDDays;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/capacity-to-ship-packages-within-d-days?category=on-answers&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

// Time Complexity: O(N * log(sum(weights) - max(weights)))
// Space Complexity: O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxEle = Arrays.stream(weights).max().getAsInt();
        int sum = Arrays.stream(weights).sum();

        int start = maxEle;
        int end = sum;

        while (start <= end) {
            int mid = start + (end - start) / 2; // capacity

            int requiredDays = getDays(weights, mid);

            if (requiredDays <= days) {
                // ans
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private int getDays(int[] weights, int maxCapacity) {
        int days = 1;
        int capacity = 0;
        for (int i = 0; i < weights.length; i++) {
            if (capacity + weights[i] <= maxCapacity) {
                capacity += weights[i];
            } else {
                capacity = weights[i];
                days++;
            }
        }

        return days;
    }
}

public class MinCapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {

    }
}
