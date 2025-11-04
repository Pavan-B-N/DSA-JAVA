package Maths.Easy.IsPrime;
// https://takeuforward.org/practice/dsa/check-for-prime-number

// Time Complexity: O(sqrt(N))
// Space Complexity: O(1)
class Solution {
    public boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

public class IsPrime {
    public static void main(String[] args) {

    }
}
