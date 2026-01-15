package Recursion_and_Backtracking.Hard.WordSearch;
// https://leetcode.com/problems/word-search/

// https://takeuforward.org/practice/dsa/word-search?category=faqs-hard&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N * M * 4^L) where L = word length
// Space Complexity: O(L) recursion stack
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j] && dfsSearch(i, j, 0, board, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfsSearch(int row, int col, int index, char[][] board, String word, boolean[][] visited) {
        if (index == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;

        int[] rowNbr = new int[] { -1, 0, 1, 0 };
        int[] colNbr = new int[] { 0, 1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int drow = row + rowNbr[k];
            int dcol = col + colNbr[k];

            if (isValid(drow, dcol, index + 1, board, word, visited)
                    && dfsSearch(drow, dcol, index + 1, board, word, visited)) {
                return true;
            }
        }

        visited[row][col] = false;

        return false;
    }

    private boolean isValid(int row, int col, int index, char[][] board, String word, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;

        return row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]
                && board[row][col] == word.charAt(index);
    }

}

public class WordSearch {
    public static void main(String[] args) {

    }
}
