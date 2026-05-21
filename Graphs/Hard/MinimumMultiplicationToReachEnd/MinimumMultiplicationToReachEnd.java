package Graphs.Hard.MinimumMultiplicationToReachEnd;
// https://takeuforward.org/practice/dsa/minimum-multiplications-to-reach-end?category=shortest-path-algorithms&source=strivers-a2z-dsa-sheet

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: O(100000) - BFS across remainder states
// Space Complexity: O(100000) for distance array and queue
class Solution {
    public int minimumMultiplications(int[] arr, int start, int end) {
        int MOD = 100000;
        int[] minSteps = new int[100000];
        Arrays.fill(minSteps, 100000);

        if (start == end) {
            return 0;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        minSteps[start] = 0;
        int steps = 0;

        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                int curr = q.poll();

                for (int ele : arr) {
                    int next = (int) (((long) ele * curr) % MOD);

                    if (next == end) {
                        return steps + 1;
                    }

                    if (steps + 1 < minSteps[next]) {
                        minSteps[next] = steps + 1;
                        q.offer(next);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}

public class MinimumMultiplicationToReachEnd {
    public static void main(String[] args) {

    }
}
