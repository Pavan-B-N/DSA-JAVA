package BitManipulation.Easy.CheckifNumberIsOdd;
// https://takeuforward.org/practice/dsa/check-if-a-number-is-odd-or-not?category=bit-fundamentals&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public boolean isOdd(int n) {
        return (n & 1) != 0;
    }
}


public class CheckifNumberIsOdd {
    public static void main(String[] args) {

    }
}
