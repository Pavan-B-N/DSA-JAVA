package Strings.Advanced.LongestHappyPrefix;
// https://takeuforward.org/practice/dsa/longest-happy-prefix?category=advanced-problems-%28less-asked%29&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N) - KMP LPS computation
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

    public String lps(String s) {
        int[] LPS = computeLPS(s);

        return s.substring(0, LPS[s.length() - 1]);
    }
}

public class LongestHappyPrefix {
    public static void main(String[] args) {

    }
}
