package Recursion_and_Backtracking.Easy.SumOfDigits;
// https://takeuforward.org/practice/dsa/sum-of-digits-in-a-given-number?category=basic-recursion&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(log10(N))
// Space Complexity: O(log10(N)) recursion stack
class Solution {
    public int addDigits(int num) {
        if (num <= 9)
            return num;

        return addDigits(sumOfDigits(num));

    }

    private int sumOfDigits(int n) {
        int res = 0;

        while (n != 0) {
            int lastDigit = n % 10;

            res += lastDigit;

            n /= 10;
        }

        return res;
    }
}

public class SumOfDigits {
    public static void main(String[] args) {

    }
}
