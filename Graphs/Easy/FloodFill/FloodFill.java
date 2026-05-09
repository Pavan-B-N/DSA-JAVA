package Graphs.Easy.FloodFill;
// https://takeuforward.org/practice/dsa/flood-fill-algorithm?category=traversal-problems&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/flood-fill/description/

// Time Complexity: O(N * M)
// Space Complexity: O(N * M) recursion stack in worst case
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;

        dfs(sr, sc, newColor, image);

        return image;
    }

    private void dfs(int row, int col, int newColor, int[][] image) {
        int initalColor = image[row][col];

        image[row][col] = newColor;

        int[] rowNbr = new int[] { -1, 0, 1, 0 };
        int[] colNbr = new int[] { 0, 1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int drow = row + rowNbr[k];
            int dcol = col + colNbr[k];

            if (isValid(drow, dcol, initalColor, image)) {
                dfs(drow, dcol, newColor, image);
            }
        }
    }

    private boolean isValid(int row, int col, int initalColor, int[][] image) {
        int m = image.length;
        int n = image[0].length;
        return row >= 0 && row < m && col >= 0 && col < n && image[row][col] == initalColor;
    }

}

public class FloodFill {
    public static void main(String[] args) {

    }
}
