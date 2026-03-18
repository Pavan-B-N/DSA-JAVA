package BitManipulation.Easy.CheckIfithBitIsSetOrNot;
// https://takeuforward.org/practice/dsa/check-if-the-i-th-bit-is-set-or-not?category=bit-fundamentals&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public boolean checkIthBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }
}

public class CheckIfithBitIsSetOrNot {
    public static void main(String[] args) {

    }
}
