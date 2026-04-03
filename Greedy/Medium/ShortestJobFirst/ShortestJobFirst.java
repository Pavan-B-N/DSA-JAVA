package Greedy.Medium.ShortestJobFirst;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/shortest-job-first?category=scheduling-and-interval-problems&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N log N)
// Space Complexity: O(1)
class Solution {
    public long solve(int[] bt) {
        Arrays.sort(bt);

        long waitingTime = 0;
        long totalWaitingTime = 0;

        for (int i = 0; i < bt.length; i++) {
            totalWaitingTime += waitingTime;
            waitingTime += (long) bt[i];
        }

        return totalWaitingTime / bt.length;
    }
}

public class ShortestJobFirst {
    public static void main(String[] args) {

    }
}
