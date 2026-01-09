package Recursion_and_Backtracking.Medium.CountGoodNumbers;
// https://leetcode.com/problems/count-good-numbers/description/
// https://takeuforward.org/practice/dsa/count-good-numbers?category=implementation-problems&source=strivers-a2z-dsa-sheet&tab=problem

// Time Complexity: O(log N) using binary exponentiation
// Space Complexity: O(log N) recursion stack
class Solution {
    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long MOD = (long) 1e9 + 7;

        return (int) ((xPowN(5, evenCount) * xPowN(4, oddCount)) % MOD);
    }

    long xPowN(long x, long n) {
        long MOD = (long) 1e9 + 7;

        long res = 1;

        while (n != 0) {
            if (n % 2 == 0) {
                x = (x * x) % MOD;
                n /= 2;
            } else {
                n--;
                res = (res * x) % MOD;
            }
        }

        return res;
    }
}

public class CountGoodNumbers {
    public static void main(String[] args) {

    }
}
