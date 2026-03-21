package BitManipulation.Medium.DivideTwoNumbersWithoutMultiplicationAndDivision;
// https://takeuforward.org/practice/dsa/divide-two-numbers-without-multiplication-and-division?category=problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(log^2(dividend))
// Space Complexity: O(1)
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }

        long ldividend = dividend;
        long ldivisor = divisor;

        boolean isNeg = (ldividend < 0) ^ (ldivisor < 0);

        ldividend = Math.abs(ldividend);
        ldivisor = Math.abs(ldivisor);

        long res = 0;

        while (ldividend >= ldivisor) {
            long multiple = ldivisor;
            long powOf2 = 1;

            while ((multiple << 1) <= ldividend) {
                multiple = multiple << 1;
                powOf2 = powOf2 << 1;
            }

            res += powOf2;
            ldividend -= multiple;
        }

        return (int) (isNeg ? -res : res);
    }
}

public class DivideTwoNumbersWithoutMultiplicationAndDivision {
    public static void main(String[] args) {

    }
}
