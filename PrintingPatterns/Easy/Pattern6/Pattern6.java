package PrintingPatterns.Easy.Pattern6;
// https://takeuforward.org/practice/dsa/pattern-6?category=patterns&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i + 1); j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

public class Pattern6 {
    public static void main(String[] args) {

    }
}
