package PrintingPatterns.Easy.Pattern8;
// https://takeuforward.org/practice/dsa/pattern-8?category=patterns&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public void pattern8(int n) {
        for(int i=0;i<n;i++){
            // print spaces
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }

            // print asterik
            for(int j=i;j<(2*n-i-1);j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

public class Pattern8 {
    public static void main(String[] args) {
        
    }
}
