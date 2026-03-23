package BitManipulation.Medium.XorInGivenRange;
// https://takeuforward.org/practice/dsa/xor-of-numbers-in-a-given-range?category=problems&source=strivers-a2z-dsa-sheet&tab=problem

// Time Complexity: O(1) using XOR pattern of multiples of 4
// Space Complexity: O(1)
class Solution {
    public int findRangeXOR(int l, int r) {
        return (findXorFrom0ToN(r) ^ findXorFrom0ToN(l - 1));
    }

    private int findXorFrom0ToN(int n) {
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 3) {
            return 0;
        } else {
            return n + 1;
        }
    }

}

public class XorInGivenRange {
    public static void main(String[] args) {

    }
}
