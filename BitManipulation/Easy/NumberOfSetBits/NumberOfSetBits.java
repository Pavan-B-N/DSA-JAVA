package BitManipulation.Easy.NumberOfSetBits;
// https://leetcode.com/problems/number-of-1-bits/description/
// https://takeuforward.org/practice/dsa/count-the-number-of-set-bits?category=bit-fundamentals&source=strivers-a2z-dsa-sheet

// Time Complexity: O(number of set bits) using Brian Kernighan's Algorithm
// Space Complexity: O(1)
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while(n!=0){
            n = n & (n-1);
            count++;
        }

        return count;
    }
}

public class NumberOfSetBits {
    public static void main(String[] args) {
        
    }
}
