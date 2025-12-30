package Strings.Advanced.RabinKarpAlgorithm;
// https://takeuforward.org/practice/dsa/rabin-karp-algorithm?category=advanced-problems-%28less-asked%29&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(N + M) avg, O(N * M) worst
// Space Complexity: O(1)
class Solution {
    public ArrayList<Integer> search(String pat, String txt) {
        int p = 7;
        int mod = 101;

        int hashTxt = 0;
        int hashPat = 0;

        int pLeft = 1;
        int pRight = 1;

        int m = pat.length();
        int n = txt.length();

        if (m > n) {
            return new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            hashPat = (hashPat + ((pat.charAt(i) - 'a' + 1) * pRight)) % mod;
            hashTxt = (hashTxt + ((txt.charAt(i) - 'a' + 1) * pRight)) % mod;

            pRight = (pRight * p) % mod;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n - m; i++) {
            if (hashTxt == hashPat && txt.substring(i, i + m).equals(pat)) {
                res.add(i);
            }

            if (i < n - m) {
                hashTxt = (hashTxt - ((txt.charAt(i) - 'a' + 1) * pLeft) % mod + mod) % mod;
                hashTxt = (hashTxt + ((txt.charAt(i + m) - 'a' + 1) * pRight) % mod) % mod;

                pLeft = (pLeft * p) % mod;
                pRight = (pRight * p) % mod;
                hashPat = (hashPat * p) % mod;
            }
        }

        return res;
    }
}

public class RabinKarpAlgorithm {
    public static void main(String[] args) {

    }
}
