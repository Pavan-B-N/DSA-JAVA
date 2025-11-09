package Maths.Medium.CountPrimesInLtoR;
// https://takeuforward.org/practice/dsa/count-primes-in-range-l-to-r?category=sieve-of-eratosthenes&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(R log(log R))
// Space Complexity: O(R) for sieve array
class Solution {
    public ArrayList<Integer> primesInRange(ArrayList<int[]> queries) {
        int n = 100000;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] primeCount = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            primeCount[i] = primeCount[i - 1];

            if (isPrime[i]) {
                primeCount[i]++;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int[] query : queries) {
            int L = query[0];
            int R = query[1];

            res.add(primeCount[R] - primeCount[L - 1]);
        }

        return res;
    }
}

public class CountPrimesInLtoR {
    public static void main(String[] args) {

    }
}
