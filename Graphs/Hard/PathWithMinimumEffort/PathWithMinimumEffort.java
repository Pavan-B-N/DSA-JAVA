package Graphs.Hard.PathWithMinimumEffort;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://takeuforward.org/practice/dsa/path-with-minimum-effort?category=shortest-path-algorithms&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N * M * log(N * M)) using Dijkstra
// Space Complexity: O(N * M) for effort matrix and priority queue
class Solution {
    public int MinimumEffort(List<List<Integer>> heights) {
        int m = heights.size();
        int n = heights.get(0).size();

        int[][] effort = new int[m][n];

        for (int[] row : effort) {
            Arrays.fill(row, (int) 1e9);
        }

        PriorityQueue<Tuple> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.effort, b.effort));

        effort[0][0] = 0;

        minHeap.offer(new Tuple(0, 0, 0));

        while (!minHeap.isEmpty()) {
            Tuple it = minHeap.poll();

            int eff = it.effort;
            int row = it.row;
            int col = it.col;

            int[] rowNbr = { -1, 0, 1, 0 };
            int[] colNbr = { 0, 1, 0, -1 };

            for (int k = 0; k < 4; k++) {
                int drow = row + rowNbr[k];
                int dcol = col + colNbr[k];

                if (isSafe(drow, dcol, heights)) {
                    int currEff = Math.abs(heights.get(row).get(col) - heights.get(drow).get(dcol));

                    int maxEffort = Math.max(currEff, eff);

                    if (maxEffort < effort[drow][dcol]) {
                        effort[drow][dcol] = maxEffort;

                        minHeap.offer(new Tuple(maxEffort, drow, dcol));
                    }
                }
            }
        }

        return effort[m - 1][n - 1] == 1e9 ? -1 : effort[m - 1][n - 1];
    }

    private boolean isSafe(int row, int col, List<List<Integer>> heights) {
        int m = heights.size();
        int n = heights.get(0).size();

        return row >= 0 && row < m && col >= 0 && col < n;
    }
}

class Tuple {
    int effort;
    int row;
    int col;

    public Tuple(int effort, int row, int col) {
        this.effort = effort;
        this.row = row;
        this.col = col;
    }
}

public class PathWithMinimumEffort {
    public static void main(String[] args) {

    }
}
