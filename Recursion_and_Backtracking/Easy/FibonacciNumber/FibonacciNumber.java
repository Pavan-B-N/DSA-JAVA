package Recursion_and_Backtracking.Easy.FibonacciNumber;
// https://leetcode.com/problems/fibonacci-number/
// https://takeuforward.org/practice/dsa/fibonacci-number?category=basic-recursion&source=strivers-a2z-dsa-sheet

// Time Complexity: O(2^N) recursive, O(N) dynamic programming
// Space Complexity: O(N) recursion stack
class Solution {
    public int fib(int n) {
        if (n < 2)
            return n;
        return fib(n - 1) + fib(n - 2);

    }
}

public class FibonacciNumber {
    public static void main(String[] args) {

    }
}
