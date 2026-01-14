package Recursion_and_Backtracking.Hard.NQueens;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-queens/description/
// https://takeuforward.org/practice/dsa/n-queen?category=faqs-hard&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    public List<List<String>> solveNQueens(int n) {
        String rowInBoard = ".".repeat(n);

        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            board.add(rowInBoard);
        }

        List<List<String>> res = new ArrayList<>();

        solve(0, board, res);

        return res;
    }

    private void solve(int col, List<String> board, List<List<String>> res) {
        if (col == board.size()) {
            // res.add(board);
            res.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < board.size(); row++) {
            if (isSafe(row, col, board)) {
                char[] rowInBoard = board.get(row).toCharArray();
                rowInBoard[col] = 'Q';

                board.set(row, new String(rowInBoard));

                solve(col + 1, board, res);

                rowInBoard[col] = '.';
                board.set(row, new String(rowInBoard));
            }
        }
    }

    private boolean isSafe(int row, int col, List<String> board) {
        int drow = row;
        int dcol = col;

        // check top left diagonal: (row-1,col-1)
        while (drow >= 0 && dcol >= 0) {
            char symbol = board.get(drow).charAt(dcol);
            if (symbol == 'Q')
                return false;
            drow--;
            dcol--;
        }

        // check left: (row,col-1)
        drow = row;
        dcol = col;
        while (dcol >= 0) {
            char symbol = board.get(drow).charAt(dcol);
            if (symbol == 'Q')
                return false;
            dcol--;
        }

        // check bottom left diagonal: (row+1,col-1)
        drow = row;
        dcol = col;
        while (drow < board.size() && dcol >= 0) {
            char symbol = board.get(drow).charAt(dcol);
            if (symbol == 'Q')
                return false;
            drow++;
            dcol--;
        }

        return true;
    }
}

// Time Complexity: O(N!)
// Space Complexity: O(N) for board and lookup sets
class Solution_Optimal {
    public List<List<String>> solveNQueens(int n) {
        String rowInBoard = ".".repeat(n);

        List<String> board = new ArrayList<>();

        boolean[] leftTopDiagonal = new boolean[2 * n - 1];
        boolean[] left = new boolean[n];
        boolean[] leftBottomDiagonal = new boolean[2 * n - 1];

        for (int i = 0; i < n; i++) {
            board.add(rowInBoard);
        }

        List<List<String>> res = new ArrayList<>();

        solve(0, board, res, leftTopDiagonal, left, leftBottomDiagonal);

        return res;
    }

    private void solve(int col, List<String> board, List<List<String>> res, boolean[] leftTopDiagonal, boolean[] left,
            boolean[] leftBottomDiagonal) {
        int n = board.size();
        if (col == board.size()) {
            // res.add(board);
            res.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < board.size(); row++) {
            if (isSafe(row, col, board, leftTopDiagonal, left, leftBottomDiagonal)) {
                char[] rowInBoard = board.get(row).toCharArray();
                rowInBoard[col] = 'Q';

                board.set(row, new String(rowInBoard));

                leftTopDiagonal[n - 1 + col - row] = true;
                left[row] = true;
                leftBottomDiagonal[row + col] = true;

                solve(col + 1, board, res, leftTopDiagonal, left, leftBottomDiagonal);

                rowInBoard[col] = '.';
                leftTopDiagonal[n - 1 + col - row] = false;
                left[row] = false;
                leftBottomDiagonal[row + col] = false;

                board.set(row, new String(rowInBoard));
            }
        }
    }

    private boolean isSafe(int row, int col, List<String> board, boolean[] leftTopDiagonal, boolean[] left,
            boolean[] leftBottomDiagonal) {
        int n = board.size();
        return !leftTopDiagonal[n - 1 + col - row] && !left[row] && !leftBottomDiagonal[row + col];
    }
}

public class NQueens {
    public static void main(String[] args) {

    }
}
