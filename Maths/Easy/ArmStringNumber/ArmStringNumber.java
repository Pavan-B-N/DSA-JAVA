package Maths.Easy.ArmStringNumber;
// https://takeuforward.org/practice/dsa/check-if-the-number-if-armstrong

// Time Complexity: O(log10(N))
// Space Complexity: O(1)
class Solution {
    public boolean isArmstrong(int num) {
        int n = num;
        int x = countDigits(n);
        int sumOfDigitsToX = 0;

        while (n != 0) {
            int lastDigit = n % 10;

            n /= 10;

            sumOfDigitsToX += Math.pow(lastDigit, x);
        }

        return sumOfDigitsToX == num;

    }

    private int countDigits(int n) {
        if (n == 0)
            return 1;
        int count = 0;

        while (n != 0) {
            count++;
            n /= 10;
        }

        return count;
    }
}

public class ArmStringNumber {
    public static void main(String[] args) {

    }
}
