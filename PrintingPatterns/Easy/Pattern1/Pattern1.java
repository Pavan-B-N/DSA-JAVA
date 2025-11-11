package PrintingPatterns.Easy.Pattern1;
// https://takeuforward.org/practice/dsa/pattern-1?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

public class Pattern1 {
    public static void main(String[] args) {

    }
}
