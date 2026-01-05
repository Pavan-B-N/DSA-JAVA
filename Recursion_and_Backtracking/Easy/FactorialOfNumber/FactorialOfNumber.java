package Recursion_and_Backtracking.Easy.FactorialOfNumber;
// https://takeuforward.org/practice/dsa/factorial-of-a-given-number-ii?category=basic-recursion&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public long factorial(int n) {
        if (n <= 1)
            return 1L;

        return (long) n * factorial(n - 1);
    }
}

public class FactorialOfNumber {
    public static void main(String[] args) {

    }
}
