package Strings.Advanced.ZFunction;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/z-function?category=advanced-problems-%28less-asked%29&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_Brute {
    private int[] computeZarray(String s) {
        int n = s.length();

        int[] Z = new int[n];

        for (int i = 1; i < n; i++) {
            while (i + Z[i] < n && s.charAt(i + Z[i]) == s.charAt(Z[i])) {
                Z[i]++;
            }
        }

        return Z;
    }

    public List<Integer> search(String text, String pattern) {
        String s = pattern + '$' + text;

        int[] Z = computeZarray(s);

        int n = text.length(), m = pattern.length();

        List<Integer> ans = new ArrayList<>();

        for (int i = m + 1; i < s.length(); i++) {
            if (Z[i] == m)
                ans.add(i - (m + 1));
        }

        return ans;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for Z-array
class Solution_Optimal {

    private int[] computeZarray(String s) {
        int n = s.length();

        int[] Z = new int[n];

        int left = 0, right = 0;

        for (int i = 1; i < n; i++) {
            if (i > right) {
                while (i + Z[i] < n && s.charAt(i + Z[i]) == s.charAt(Z[i])) {
                    Z[i]++;
                }
            } else {
                if (i + Z[i - left] <= right) {
                    Z[i] = Z[i - left];
                } else {
                    Z[i] = right - i + 1;

                    while (i + Z[i] < n && s.charAt(i + Z[i]) == s.charAt(Z[i])) {
                        Z[i]++;
                    }
                }
            }

            if (i + Z[i] - 1 > right) {
                left = i;
                right = i + Z[i] - 1;
            }
        }

        return Z;
    }

    public List<Integer> search(String text, String pattern) {
        String s = pattern + '$' + text;

        int[] Z = computeZarray(s);

        int n = text.length(), m = pattern.length();

        List<Integer> ans = new ArrayList<>();

        for (int i = m + 1; i < s.length(); i++) {
            if (Z[i] == m) {
                ans.add(i - (m + 1));
            }
        }

        return ans;
    }
}

public class ZFunction {
    public static void main(String[] args) {

    }
}
