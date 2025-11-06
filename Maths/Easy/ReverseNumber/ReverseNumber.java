package Maths.Easy.ReverseNumber;
// https://takeuforward.org/practice/dsa/reverse-a-number
// https://leetcode.com/problems/reverse-integer/

// Time Complexity: O(log10(N))
// Space Complexity: O(1)
class Solution {
    public int reverse(int num) {
        if (num == Integer.MIN_VALUE || num == Integer.MAX_VALUE)
            return 0;

        int n = Math.abs(num);
        int sign = Integer.signum(num);

        int revNum = 0;

        while (n != 0) {
            int lastDigit = n % 10;
            n /= 10;

            if (revNum > Integer.MAX_VALUE / 10 || (revNum == Integer.MAX_VALUE && lastDigit > 7))
                return 0;

            revNum = revNum * 10 + lastDigit;
        }

        return revNum * sign;
    }
}

public class ReverseNumber {
    public static void main(String[] args) {

    }
}
