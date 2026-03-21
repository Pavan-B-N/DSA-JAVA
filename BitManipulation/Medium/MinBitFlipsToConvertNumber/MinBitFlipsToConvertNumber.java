package BitManipulation.Medium.MinBitFlipsToConvertNumber;
// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
// https://takeuforward.org/practice/dsa/minimum-bit-flips-to-convert-number?category=problems&source=strivers-a2z-dsa-sheet


// Time Complexity: O(number of set bits in XOR)
// Space Complexity: O(1)
class Solution {
    public int minBitFlips(int start, int goal) {
        int n = start ^ goal;
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}

public class MinBitFlipsToConvertNumber {
    public static void main(String[] args) {

    }
}
