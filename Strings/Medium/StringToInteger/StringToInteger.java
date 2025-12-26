package Strings.Medium.StringToInteger;
// https://leetcode.com/problems/string-to-integer-atoi/description/
// https://takeuforward.org/practice/dsa/string-to-integer-atoi?category=string-conversions&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int myAtoi(String s) {
        int res = 0;
        int sign = 1;

        int n = s.length();

        int i = 0;

        // ignore leading white spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // check sign
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;

            i++;
        }

        // ignore leading zeros
        while (i < n && s.charAt(i) == '0') {
            i++;
        }

        // build digit
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;

            i++;
        }

        return res * sign;
    }
}

public class StringToInteger {
    public static void main(String[] args) {

    }
}
