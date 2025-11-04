package Maths.Easy.PalindromeNumber;
// https://takeuforward.org/practice/dsa/palindrome-number
// https://leetcode.com/problems/palindrome-number/

// Time Complexity: O(log10(N))
// Space Complexity: O(1)
class Solution {
    public boolean isPalindrome(int n) {
        if (n < 0)
            return false;

        int revNum = 0;
        int N = n;

        while (n != 0) {
            int lastDigit = n % 10;

            revNum = revNum * 10 + lastDigit;
            n /= 10;
        }

        return revNum == N;
    }
}

public class PalindromeNumber {
    public static void main(String[] args) {

    }
}
