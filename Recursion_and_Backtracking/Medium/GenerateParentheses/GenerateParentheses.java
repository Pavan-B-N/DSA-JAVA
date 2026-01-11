package Recursion_and_Backtracking.Medium.GenerateParentheses;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/generate-parentheses?category=implementation-problems&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/generate-parentheses/

// Time Complexity: O(4^N / sqrt(N)) Catalan number
// Space Complexity: O(N) recursion stack
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        dfs(0, 0, n, "", res);

        return res;

    }

    private void dfs(int open, int close, final int n, String s, List<String> res) {
        if (open + close == 2 * n) {
            res.add(s);
            return;
        }

        if (open < n) {
            dfs(open + 1, close, n, s + "(", res);
        }

        if (open > close && close < n) {
            dfs(open, close + 1, n, s + ")", res);
        }
    }
}

// Time Complexity: O(4^N / sqrt(N)) Catalan number
// Space Complexity: O(N) recursion stack
class Solution_StringBuilder {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(0, 0, n, sb, res);

        return res;

    }

    private void dfs(int open, int close, final int n, StringBuilder sb, List<String> res) {
        if (open + close == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            dfs(open + 1, close, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);// backtrack or reset
        }

        if (open > close && close < n) {
            sb.append(")");
            dfs(open, close + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);

        }
    }
}

public class GenerateParentheses {
    public static void main(String[] args) {

    }
}
