package Recursion_and_Backtracking.Hard.ExpressionAddOperators;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/expression-add-operators?category=faqs-hard&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/expression-add-operators/description/

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    public List<String> addOperators(String s, int target) {
        List<String> result = new ArrayList<>();

        if (s.length() == 0)
            return result;

        StringBuilder expr = new StringBuilder();

        backtrack(s, target, 0, expr, result);
        return result;
    }

    private void backtrack(
            String num, long target, int pos, StringBuilder expr, List<String> result) {

        int n = num.length();

        if (pos == n) {
            if (evaluate(expr.toString()) == target) {
                result.add(expr.toString());
            }
            return;
        }

        for (int end = pos; end < n; end++) {

            if (end > pos && num.charAt(pos) == '0')
                break;

            String part = num.substring(pos, end + 1);

            int exprLen = expr.length();

            if (pos == 0) {
                expr.append(part);
                backtrack(num, target, end + 1, expr, result);
                expr.setLength(exprLen);
            } else {
                // Try '+'
                expr.append('+').append(part);
                backtrack(num, target, end + 1, expr, result);
                expr.setLength(exprLen);

                // Try '-'
                expr.append('-').append(part);
                backtrack(num, target, end + 1, expr, result);
                expr.setLength(exprLen);

                // Try '*'
                expr.append('*').append(part);
                backtrack(num, target, end + 1, expr, result);
                expr.setLength(exprLen);
            }
        }
    }

    // Classic expression evaluator supporting +, -, *
    private long evaluate(String e) {
        long total = 0;
        long lastTerm = 0;
        long currentNumber = 0;

        char lastOp = '+';

        int n = e.length();
        for (int i = 0; i <= n; i++) {
            char c = (i < n ? e.charAt(i) : '#');

            if (i < n && Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            } else {
                if (lastOp == '+') {
                    total += lastTerm;
                    lastTerm = currentNumber;
                } else if (lastOp == '-') {
                    total += lastTerm;
                    lastTerm = -currentNumber;
                } else if (lastOp == '*') {
                    lastTerm = lastTerm * currentNumber;
                }

                if (i < n)
                    lastOp = c;
                currentNumber = 0;
            }
        }

        total += lastTerm;
        return total;
    }
}

// Time Complexity: O(4^N * N)
// Space Complexity: O(N) recursion stack
class Solution_Optimal {
    public List<String> addOperators(String s, int target) {
        List<String> result = new ArrayList<>();

        if (s.length() == 0)
            return result;

        StringBuilder expr = new StringBuilder();

        backtrack(s, target, 0, 0L, 0L, expr, result);

        return result;
    }

    private void backtrack(
            String num,
            long target,
            int pos,
            long value,
            long last,
            StringBuilder expr,
            List<String> result) {

        int n = num.length();

        if (pos == n) {
            if (value == target) {
                result.add(expr.toString());
            }
            return;
        }

        long currNum = 0;
        int exprLen = expr.length();

        for (int end = pos; end < n; end++) {

            if (end > pos && num.charAt(pos) == '0')
                break;

            currNum = currNum * 10 + (num.charAt(end) - '0');

            String part = num.substring(pos, end + 1);

            if (pos == 0) {
                expr.append(part);
                backtrack(num, target, end + 1, currNum, currNum, expr, result);
                expr.setLength(exprLen);
            } else {
                // Try '+'
                expr.append('+').append(part);
                backtrack(num, target, end + 1, value + currNum, currNum, expr, result);
                expr.setLength(exprLen);

                // Try '-'
                expr.append('-').append(part);
                backtrack(num, target, end + 1, value - currNum, -currNum, expr, result);
                expr.setLength(exprLen);

                // Try '*'
                expr.append('*').append(part);
                backtrack(
                        num, target, end + 1, value - last + last * currNum, last * currNum, expr, result);
                expr.setLength(exprLen);
            }
        }
    }
}

public class ExpressionAddOperators {
    public static void main(String[] args) {

    }
}
