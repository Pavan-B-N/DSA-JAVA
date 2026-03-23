package Heaps.Easy.CheckIfArrayRepresentsMinHeap;
// https://takeuforward.org/practice/dsa/check-if-an-array-represents-a-min-heap-?category=theory-and-implementation&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public boolean isHeap(int[] nums) {
        int n = nums.length;

        for (int i = 0; i <= (n / 2 - 1); i++) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            if (leftChild < n && nums[leftChild] < nums[i])
                return false;
            if (rightChild < n && nums[rightChild] < nums[i])
                return false;
        }

        return true;
    }
}

public class CheckIfArrayRepresentsMinHeap {
    public static void main(String[] args) {

    }
}
