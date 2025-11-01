package Maths.Easy.CountDigitsOfNumber;
// https://takeuforward.org/practice/dsa/count-all-digits-of-a-number

// Time Complexity: O(log10(N))
// Space Complexity: O(1)
class Solution {
    public int countDigit(int n) {
        if (n == 0)
            return 1;

        int count = 0;

        while (n != 0) {
            n /= 10;
            count++;
        }

        return count;
    }
}

public class CountDigitsOfNumber {
    public static void main(String[] args) {

    }
}
