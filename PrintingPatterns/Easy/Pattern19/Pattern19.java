package PrintingPatterns.Easy.Pattern19;
// https://takeuforward.org/practice/dsa/pattern-19?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern19(int n) {
        printInvertedPattern(n);
        printPattern(n);
    }

    private void printInvertedPattern(int n) {
        for (int i = 0; i < n; i++) {
            // print asterik
            for (int j = 0; j < (n - i); j++) {
                System.out.print("*");
            }

            // print space
            for (int j = (n - i); j < (n + i); j++) {
                System.out.print(" ");
            }

            // print asterik
            for (int j = (n + i); j < 2 * n; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    private void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            // print asterik
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            // print space
            for (int j = (i + 1); j < (2 * n - i - 1); j++) {
                System.out.print(" ");
            }

            // print asterik
            for (int j = (2 * n - i - 1); j < 2 * n; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

public class Pattern19 {
    public static void main(String[] args) {

    }
}
