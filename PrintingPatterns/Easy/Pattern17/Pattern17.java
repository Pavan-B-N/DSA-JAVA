package PrintingPatterns.Easy.Pattern17;
// https://takeuforward.org/practice/dsa/pattern-17?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern17(int n) {
        for (int i = 0; i < n; i++) {
            // print space
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print(" ");
            }

            // print A - Z
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ('A' + j));
            }

            // print Z- A
            for (int j = (i - 1); j >= 0; j--) {
                System.out.print((char) ('A' + j));
            }

            System.out.println();
        }
    }
}

public class Pattern17 {
    public static void main(String[] args) {

    }
}
