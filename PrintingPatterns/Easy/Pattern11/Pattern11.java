package PrintingPatterns.Easy.Pattern11;
// https://takeuforward.org/practice/dsa/pattern-11?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern11(int n) {
        for (int i = 0; i < n; i++) {
            int value = i % 2 == 0 ? 1 : 0;
            for (int j = 0; j <= i; j++) {
                System.out.print(value);
                if (j != i)
                    System.out.print(" ");
                value = value == 1 ? 0 : 1;
            }
            System.out.println();
        }
    }
}

public class Pattern11 {
    public static void main(String[] args) {

    }
}
