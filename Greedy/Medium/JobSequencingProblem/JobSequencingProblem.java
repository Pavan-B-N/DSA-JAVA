package Greedy.Medium.JobSequencingProblem;
import java.util.Arrays;
import java.util.PriorityQueue;

// https://takeuforward.org/practice/dsa/job-sequencing-problem?category=scheduling-and-interval-problems&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem

// Time Complexity: O(N log N + N * maxDeadline)
// Space Complexity: O(maxDeadline) for time slots
class Solution {
    public int[] JobScheduling(int[][] Jobs) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> Integer.compare(Jobs[j][2], Jobs[i][2]));

        for (int i = 0; i < Jobs.length; i++) {
            maxHeap.offer(i);
        }

        boolean[] slots = new boolean[Jobs.length + 1];
        Arrays.fill(slots, true);

        int maxProfit = 0;
        int jobCount = 0;

        while (!maxHeap.isEmpty()) {
            int i = maxHeap.poll();

            int deadline = Jobs[i][1];
            int profit = Jobs[i][2];

            int j = deadline;

            while (j > 0) {
                if (slots[j]) {
                    jobCount++;
                    maxProfit += profit;
                    slots[j] = false;
                    break;
                }

                j--;
            }
        }

        return new int[] { jobCount, maxProfit };

    }
}

public class JobSequencingProblem {
    public static void main(String[] args) {

    }
}
