package Recursion_and_Backtracking.Hard.SudokuSolver;
// https://leetcode.com/problems/sudoku-solver/
// https://takeuforward.org/practice/dsa/sudoko-solver?category=faqs-hard&source=strivers-a2z-dsa-sheet

// Time Complexity: O(9^(empty cells))
// Space Complexity: O(1) recursion stack limited to 81 calls
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    // place number

                    for (char num = '1'; num <= '9'; num++) {
                        if (isSafe(num, i, j, board)) {

                            board[i][j] = num;
                            if (solve(board))
                                return true;
                            board[i][j] = '.';

                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isSafe(char num, int row, int col, char[][] board) {
        // check for the current row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num)
                return false;
        }

        // check for column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num)
                return false;
        }

        // check subBoard
        for (int i = 0; i < 9; i++) {
            int subBoardRow = (row / 3) * 3 + i / 3;
            int subBoardCol = (col / 3) * 3 + i % 3;

            if (board[subBoardRow][subBoardCol] == num)
                return false;
        }

        return true;
    }
}

public class SudokuSolver {
    public static void main(String[] args) {

    }
}
