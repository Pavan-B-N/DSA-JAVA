package DynamicProgramming.Intervals_and_Partition_DP.Advanced.DifferentWaysToEvaluateBooleanExpression;
import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/practice/dsa/different-ways-to-evaluate-a-boolean-expression?category=mcm-dp&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    private final int MOD = 1_000_000_007;

    public int countTrue(String s) {
        Map<String, Integer> memo = new HashMap<>();
        return solve(s, 0, s.length() - 1, true, memo);
    }

    private int solve(String s, int i, int j, boolean isTrue, Map<String, Integer> memo) {
        if (i == j)
            return isTrue ? (s.charAt(i) == 'T' ? 1 : 0) : (s.charAt(i) == 'F' ? 1 : 0);

        // Memo key
        String key = i + "_" + j + "_" + isTrue;
        if (memo.containsKey(key))
            return memo.get(key);

        int ways = 0;
        // Iterate over operators
        for (int k = i + 1; k < j; k += 2) {
            char op = s.charAt(k);
            int leftTrue = solve(s, i, k - 1, true, memo);
            int leftFalse = solve(s, i, k - 1, false, memo);
            int rightTrue = solve(s, k + 1, j, true, memo);
            int rightFalse = solve(s, k + 1, j, false, memo);

            // Combine based on operator
            if (op == '&')
                ways = (ways + (isTrue ? (int) (((long) leftTrue * rightTrue) % MOD)
                        : (int) ((((long) leftTrue * rightFalse + (long) leftFalse * rightTrue
                                + (long) leftFalse * rightFalse) % MOD))))
                        % MOD;
            else if (op == '|')
                ways = (ways
                        + (isTrue
                                ? (int) (((long) leftTrue * rightTrue + (long) leftTrue * rightFalse
                                        + (long) leftFalse * rightTrue) % MOD)
                                : (int) ((long) leftFalse * rightFalse % MOD)))
                        % MOD;
            else if (op == '^')
                ways = (ways + (isTrue ? (int) (((long) leftTrue * rightFalse + (long) leftFalse * rightTrue) % MOD)
                        : (int) (((long) leftTrue * rightTrue + (long) leftFalse * rightFalse) % MOD))) % MOD;
        }
        memo.put(key, ways);
        return ways;
    }
}

// Time Complexity: O(N^3)
// Space Complexity: O(N^2) for 3D memoization table
class Solution_Optimal {
    public int countTrue(String s) {
        int n = s.length();

        long[][] dpTrue = new long[n][n];

        long[][] dpFalse = new long[n][n];

        long MOD = 1000000007L;

        for (int i = 0; i < n; i += 2) {
            dpTrue[i][i] = (s.charAt(i) == 'T') ? 1 : 0;
            dpFalse[i][i] = (s.charAt(i) == 'F') ? 1 : 0;
        }

        for (int len = 3; len <= n; len += 2) {
            for (int i = 0; i + len - 1 < n; i += 2) {
                int j = i + len - 1;
                dpTrue[i][j] = dpFalse[i][j] = 0;

                for (int k = i + 1; k < j; k += 2) {
                    char op = s.charAt(k);

                    long lt = dpTrue[i][k - 1];
                    long lf = dpFalse[i][k - 1];
                    long rt = dpTrue[k + 1][j];
                    long rf = dpFalse[k + 1][j];

                    if (op == '&') {
                        dpTrue[i][j] = (dpTrue[i][j] + lt * rt) % MOD;
                        dpFalse[i][j] = (dpFalse[i][j] + lt * rf + lf * rt + lf * rf) % MOD;
                    } else if (op == '|') {
                        dpTrue[i][j] = (dpTrue[i][j] + lt * rt + lt * rf + lf * rt) % MOD;
                        dpFalse[i][j] = (dpFalse[i][j] + lf * rf) % MOD;
                    } else if (op == '^') {
                        dpTrue[i][j] = (dpTrue[i][j] + lt * rf + lf * rt) % MOD;
                        dpFalse[i][j] = (dpFalse[i][j] + lt * rt + lf * rf) % MOD;
                    }
                }
            }
        }

        return (int) dpTrue[0][n - 1];
    }
}

public class DifferentWaysToEvaluateBooleanExpression {
    public static void main(String[] args) {

    }
}
