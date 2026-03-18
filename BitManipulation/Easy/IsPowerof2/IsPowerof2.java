package BitManipulation.Easy.IsPowerof2;
// https://leetcode.com/problems/power-of-two/description/
// https://takeuforward.org/practice/dsa/check-if-a-number-is-power-of-2-or-not?category=bit-fundamentals&source=strivers-a2z-dsa-sheet

// Time Complexity: O(1) using n & (n - 1)
// Space Complexity: O(1)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;

        return (n & (n - 1)) == 0;
    }
}

public class IsPowerof2 {
    public static void main(String[] args) {

    }
}
