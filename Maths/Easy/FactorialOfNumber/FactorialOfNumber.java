package Maths.Easy.FactorialOfNumber;
// https://takeuforward.org/practice/dsa/factorial-of-a-given-number-i
// 

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}

public class FactorialOfNumber {
    public static void main(String[] args) {

    }
}
