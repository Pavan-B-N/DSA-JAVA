package Graphs.Medium.RottenOranges;
import java.util.ArrayDeque;
import java.util.Deque;

// https://takeuforward.org/practice/dsa/rotten-oranges?category=traversal-problems&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/rotting-oranges/

// Time Complexity: O(N * M)
// Space Complexity: O(N * M) for BFS queue
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int time = 0;

        Deque<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean rot = false;

            for (int i = 0; i < levelSize; i++) {

                Pair pr = queue.poll();
                int row = pr.row;
                int col = pr.col;

                int rowNbr[] = { -1, 0, 1, 0 };
                int colNbr[] = { 0, 1, 0, -1 };

                for (int k = 0; k < 4; k++) {
                    int drow = row + rowNbr[k];
                    int dcol = col + colNbr[k];

                    if (isValid(drow, dcol, grid)) {
                        grid[drow][dcol] = 2;
                        queue.offer(new Pair(drow, dcol));
                        rot = true;
                    }
                }
            }

            if (rot) {
                time++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return time;
    }

    private boolean isValid(int row, int col, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1;
    }
}

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class RottenOranges {
    public static void main(String[] args) {

    }
}
