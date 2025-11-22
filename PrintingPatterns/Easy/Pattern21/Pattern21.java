package PrintingPatterns.Easy.Pattern21;
// https://takeuforward.org/practice/dsa/pattern-21?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern21(int n) {
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                printFirstOrLast(n);
            } else {
                printMiddleRow(n);
            }
        }
    }

    private void printFirstOrLast(int n) {
        for (int j = 0; j < n; j++) {
            System.out.print("*");
        }
        System.out.println();
    }

    private void printMiddleRow(int n) {
        System.out.print("*");

        for (int j = 1; j < (n - 1); j++) {
            System.out.print(" ");
        }

        System.out.print("*");

        System.out.println();
    }
}

public class Pattern21 {
    public static void main(String[] args) {

    }
}
