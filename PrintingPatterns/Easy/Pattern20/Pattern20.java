package PrintingPatterns.Easy.Pattern20;
// https://takeuforward.org/practice/dsa/pattern-20?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern20(int n) {
        printPattern(n);
        printInvertedPattern(n);
    }

    private void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = i + 1; j < 2 * n - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 2 * n - i - 1; j < 2 * n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private void printInvertedPattern(int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print("*");
            }

            for (int j = (n - i - 1); j < (n + i + 1); j++) {
                System.out.print(" ");
            }

            for (int j = (n + i + 1); j < 2 * n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

public class Pattern20 {
    public static void main(String[] args) {

    }
}
