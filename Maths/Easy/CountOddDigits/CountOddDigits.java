package Maths.Easy.CountOddDigits;
// https://takeuforward.org/practice/dsa/count-number-of-odd-digits-in-a-number

// Time Complexity: O(log10(N))
// Space Complexity: O(1)
class Solution {
    public int countOddDigit(int n) {
        int count = 0;

        while (n != 0) {
            int lastDigit = n % 10;

            if (lastDigit % 2 != 0)
                count++;
            n /= 10;
        }

        return count;
    }
}

public class CountOddDigits {
    public static void main(String[] args) {

    }
}
