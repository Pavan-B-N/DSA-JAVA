package Graphs.Medium.DistanceOfNearestCellHavingOne;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://takeuforward.org/practice/dsa/distance-of-nearest-cell-having-one?category=traversal-problems&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/01-matrix/

// Time Complexity: O(N * M)
// Space Complexity: O(N * M) for BFS queue and distance matrix
class Solution {
    public int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n]; // -1 = not visited

        for (int[] arr : dist) {
            Arrays.fill(arr, -1);
        }

        Deque<Tuple> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Tuple(i, j, 0));
                    dist[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            int row = tuple.row;
            int col = tuple.col;
            int d = tuple.distance;

            int rowNbr[] = { -1, 0, 1, 0 };
            int colNbr[] = { 0, 1, 0, -1 };

            for (int k = 0; k < 4; k++) {
                int drow = row + rowNbr[k];
                int dcol = col + colNbr[k];

                if (isValid(drow, dcol, dist)) {
                    dist[drow][dcol] = d + 1;
                    queue.offer(new Tuple(drow, dcol, d + 1));
                }
            }
        }

        return dist;
    }

    private boolean isValid(int row, int col, int[][] dist) {
        int m = dist.length;
        int n = dist[0].length;

        return row >= 0 && row < m && col >= 0 && col < n && dist[row][col] == -1;
    }
}

class Tuple {
    int row, col, distance;

    public Tuple(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class DistanceOfNearestCellHavingOne {
    public static void main(String[] args) {

    }
}
