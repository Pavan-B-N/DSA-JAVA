package Maths.Medium.CountPrimes;
// https://leetcode.com/problems/count-primes/description/
// https://takeuforward.org/practice/dsa/count-of-prime-numbers-till-n

import java.util.Arrays;

// Time Complexity of sieve:  (O(nloglog n))
class Solution {
    public int countPrimes(int n) {
        boolean[] sieveArr = new boolean[n];
        Arrays.fill(sieveArr, true);

        for (int i = 2; i * i <= n; i++) {
            if (sieveArr[i]) {
                for (int j = i * i; j < n; j += i) {
                    sieveArr[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (sieveArr[i])
                count++;
        }

        return count;
    }
}

public class CountPrimes {
    public static void main(String[] args) {

    }
}
