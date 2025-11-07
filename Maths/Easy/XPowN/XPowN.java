package Maths.Easy.XPowN;
// https://takeuforward.org/practice/dsa/pow(x%2Cn)?category=implementation-problems&source=strivers-a2z-dsa-sheet&tab=problem&solution=optimal

// O(log N)
// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    // Binary Exponetiation Technique
    /*
     * it helps to compute Pow(x,n) with
     * - negative exponents
     * - Prevent Integer Overflow
     */
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;

        double res = 1;
        long N = Math.abs((long) n);
        boolean isNeg = n < 0;

        while (N != 0) {
            if (N % 2 == 0) {
                x = x * x;
                N /= 2;
            } else {
                N--;
                res *= x;
            }
        }

        return isNeg ? 1 / res : res;
    }
}

public class XPowN {
    public static void main(String[] args) {

    }
}
