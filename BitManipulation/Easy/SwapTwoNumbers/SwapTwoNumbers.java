package BitManipulation.Easy.SwapTwoNumbers;
// https://takeuforward.org/practice/dsa/swap-two-numbers?category=bit-fundamentals&source=strivers-a2z-dsa-sheet

// Time Complexity: O(1) using XOR
// Space Complexity: O(1)
class Solution {
  public int[] swap(int a, int b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    return new int[] {a, b};
  }
}


public class SwapTwoNumbers {
    public static void main(String[] args) {
        
    }
}
