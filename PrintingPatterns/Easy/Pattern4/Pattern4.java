package PrintingPatterns.Easy.Pattern4;
// https://takeuforward.org/practice/dsa/pattern-4?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}

public class Pattern4 {
    public static void main(String[] args) {

    }
}
