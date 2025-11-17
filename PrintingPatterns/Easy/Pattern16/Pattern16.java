package PrintingPatterns.Easy.Pattern16;
// https://takeuforward.org/practice/dsa/pattern-16?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern16(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ('A' + i));
            }
            System.out.println();
        }
    }
}

public class Pattern16 {
    public static void main(String[] args) {

    }
}
