package PrintingPatterns.Easy.Pattern13;
// https://takeuforward.org/practice/dsa/pattern-13?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern13(int n) {
        int curr = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(curr++);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

public class Pattern13 {
    public static void main(String[] args) {

    }
}
