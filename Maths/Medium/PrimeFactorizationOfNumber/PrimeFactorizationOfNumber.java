package Maths.Medium.PrimeFactorizationOfNumber;
// https://takeuforward.org/practice/dsa/prime-factorisation-of-a-number?category=sieve-of-eratosthenes&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(sqrt(N))
// Space Complexity: O(log N) for storing factors
class Solution {
    public List<List<Integer>> primeFactors(int[] queries) {
        int n = 100000;
        int[] SPF = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            SPF[i] = i;
        }

        for (int i = 2; i * i <= n; i++) {
            if (SPF[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (SPF[j] == j) {
                        SPF[j] = i;
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int q : queries) {
            res.add(primeFactorization(q, SPF));
        }

        return res;
    }

    private List<Integer> primeFactorization(int n, int[] SPF) {
        List<Integer> res = new ArrayList<>();

        while (n > 1) {
            res.add(SPF[n]);
            n /= SPF[n];
        }

        return res;
    }
}

public class PrimeFactorizationOfNumber {
    public static void main(String[] args) {

    }
}
