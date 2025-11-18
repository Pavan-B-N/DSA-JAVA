package PrintingPatterns.Easy.Pattern18;
// https://takeuforward.org/practice/dsa/pattern-18?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern18(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ('A' + (n - i + j - 1)) + " ");
            }
            System.out.println();
        }
    }
}

public class Pattern18 {
    public static void main(String[] args) {

    }
}
