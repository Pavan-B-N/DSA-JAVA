package Strings.Medium.RomanToInteger;
// https://leetcode.com/problems/roman-to-integer/
// https://takeuforward.org/practice/dsa/roman-to-integer?category=string-conversions&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int prev = 0;
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            char symbol = s.charAt(i);
            int value = romanValue(symbol);

            if (value >= prev) {
                res += value;
            } else {
                res -= value;
            }

            prev = value;
        }

        return res;
    }

    private int romanValue(char symbol) {
        switch (symbol) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }

        return 0;
    }
}

public class RomanToInteger {
    public static void main(String[] args) {

    }
}
