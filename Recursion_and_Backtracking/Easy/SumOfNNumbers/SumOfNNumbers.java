package Recursion_and_Backtracking.Easy.SumOfNNumbers;
// https://takeuforward.org/practice/dsa/sum-of-first-n-numbers?category=basic-recursion&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(N) recursion stack
class Solution {
    public int NnumbersSum(int n) {
        if (n == 0)
            return 0;
        return n + NnumbersSum(n - 1);
    }
}

public class SumOfNNumbers {
    public static void main(String[] args) {

    }
}
