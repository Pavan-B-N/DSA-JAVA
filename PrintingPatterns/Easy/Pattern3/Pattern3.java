package PrintingPatterns.Easy.Pattern3;
// https://takeuforward.org/practice/dsa/pattern-3?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

public class Pattern3 {
    public static void main(String[] args) {

    }
}
