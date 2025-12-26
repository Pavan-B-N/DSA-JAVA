package Strings.Advanced.KMP_LPSArray;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/kmp-algorithm-or-lps-array?category=advanced-problems-%28less-asked%29&source=strivers-a2z-dsa-sheet&tab=solution

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    private int[] computeLPS(String s) {
        int n = s.length();

        int[] LPS = new int[n];

        for (int i = 1; i < n; i++) {

            for (int len = 1; len < i; len++) {
                if (s.substring(0, len).equals(s.substring(i - len + 1, i + 1))) {
                    LPS[i] = len;
                }
            }
        }

        return LPS;
    }

    public List<Integer> search(String pattern, String text) {
        String s = pattern + '$' + text;

        int[] LPS = computeLPS(s);

        int n = text.length(), m = pattern.length();

        List<Integer> ans = new ArrayList<>();

        for (int i = m + 1; i < s.length(); i++) {
            if (LPS[i] == m)
                ans.add(i - 2 * m);
        }

        return ans;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for LPS array
class Solution_Optimal {
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

    public List<Integer> search(String pattern, String text) {
        String s = pattern + '$' + text;

        int[] LPS = computeLPS(s);

        int n = text.length(), m = pattern.length();

        List<Integer> ans = new ArrayList<>();

        for (int i = m + 1; i < s.length(); i++) {
            if (LPS[i] == m)
                ans.add(i - 2 * m);
        }

        return ans;
    }
}

public class KMP_LPSArray {
    public static void main(String[] args) {

    }
}
