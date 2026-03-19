package BitManipulation.Easy.SetRightmostUnsetBit;
// https://takeuforward.org/practice/dsa/set-the-rightmost-unset-bit?category=bit-fundamentals&source=strivers-a2z-dsa-sheet&tab=problem&solution=optimal

// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public int setRightmostUnsetBit(int n) {
        // All bits in the existing binary representation are already set.
        if ((n & (n + 1)) == 0) {
            return n;
        }

        for (int i = 0; i < 32; i++) {
            int bit = n & (1 << i);

            if (bit == 0) {
                // unsetBit
                return n | (1 << i);
            }

        }

        return -1;
    }
}

public class SetRightmostUnsetBit {
    public static void main(String[] args) {

    }
}
