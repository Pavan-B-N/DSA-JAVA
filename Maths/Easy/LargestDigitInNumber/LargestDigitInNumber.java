package Maths.Easy.LargestDigitInNumber;
// https://takeuforward.org/practice/dsa/return-the-largest-digit-in-a-number

// Time Complexity: O(log10(N))
// Space Complexity: O(1)
class Solution {
    public int largestDigit(int n) {
        int maxVal = 0;

        while (n != 0) {
            int lastDigit = n % 10;
            n /= 10;

            maxVal = Math.max(maxVal, lastDigit);
        }

        return maxVal;
    }
}

public class LargestDigitInNumber {
    public static void main(String[] args) {

    }
}
