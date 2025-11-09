package Maths.Medium.PrintAllPrimesTillN;
import java.util.ArrayList;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/print-all-primes-till-n?category=sieve-of-eratosthenes&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N log(log N))
// Space Complexity: O(N) for sieve array
class Solution {
    public ArrayList<Integer> primeTillN(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);

        for (int i = 2; i * i <= n; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= n; j += i) {
                    sieve[j] = false;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (sieve[i]) {
                res.add(i);
            }
        }

        return res;
    }
}

public class PrintAllPrimesTillN {
    public static void main(String[] args) {

    }
}
