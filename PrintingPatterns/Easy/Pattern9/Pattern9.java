package PrintingPatterns.Easy.Pattern9;
// https://takeuforward.org/practice/dsa/pattern-9?category=patterns&source=strivers-a2z-dsa-sheet&tab=problem

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern9(int n) {
        printPyramid(n);
        printInvertedPyramid(n);
    }

    private void printPyramid(int n) {
        for (int i = 0; i < n; i++) {
            // print space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // print asterik
            for (int j = (n - i); j <= (n + i); j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    private void printInvertedPyramid(int n) {
        for (int i = 0; i < n; i++) {
            // print space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // print asterik
            for (int j = i; j < (2 * n - i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

public class Pattern9 {
    public static void main(String[] args) {

    }
}
