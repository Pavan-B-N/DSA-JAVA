package Strings.Advanced.ShortestPalindrome;
// https://takeuforward.org/practice/dsa/shortest-palindrome?category=advanced-problems-%28less-asked%29&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N) - KMP preprocessing
// Space Complexity: O(N) for LPS array
class Solution {
    private int[] computeLPS(String s) {
        int n = s.length();

        int[] LPS = new int[n];

        int i = 1, j = 0;

        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                LPS[i] = j + 1;
                i++;
                j++;
            } else {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = LPS[j - 1];
                }

                if (s.charAt(i) == s.charAt(j)) {
                    LPS[i] = j + 1;
                    j++;
                }
                i += 1;
            }
        }

        return LPS;
    }

    public String shortestPalindrome(String s) {

        StringBuilder revs = new StringBuilder(s);
        revs.reverse();

        String str = s + "$" + revs;

        int[] lps = computeLPS(str);

        int ans = s.length() - lps[lps.length - 1];

        String toAdd = revs.substring(0, ans);

        return toAdd + s;
    }
}

public class ShortestPalindrome {
    public static void main(String[] args) {

    }
}
