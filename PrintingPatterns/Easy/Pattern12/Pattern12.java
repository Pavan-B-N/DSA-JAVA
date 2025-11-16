package PrintingPatterns.Easy.Pattern12;
// https://takeuforward.org/practice/dsa/pattern-12?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern12(int n) {
        for (int i = 1; i <= n; i++) {
            // print 1-N
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // print space
            for (int j = i + 1; j <= (2 * n - i); j++) {
                System.out.print(" ");
            }

            // print N-1
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}

public class Pattern12 {
    public static void main(String[] args) {

    }
}
