package PrintingPatterns.Easy.Pattern7;
// https://takeuforward.org/practice/dsa/pattern-7?category=patterns&source=strivers-a2z-dsa-sheet&tab=problem

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern7(int n) {
        for (int i = 0; i < n; i++) {
            // print space
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print(" ");
            }

            // print *
            for (int j = (n - i - 1); j < (n + i); j++) {
                System.out.print("*");
            }

            // print space
            // for(int j=(n+i);j<(2*n-1);j++){
            // System.out.print(" ");
            // }

            System.out.println();
        }
    }
}

public class Pattern7 {
    public static void main(String[] args) {

    }
}
