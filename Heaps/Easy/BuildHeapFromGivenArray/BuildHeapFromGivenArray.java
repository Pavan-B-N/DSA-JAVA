package Heaps.Easy.BuildHeapFromGivenArray;
// https://takeuforward.org/practice/dsa/build-heap-from-a-given-array?category=theory-and-implementation&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1) in-place
class Solution {
    public void buildMinHeap(int[] nums) {
        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(nums, i);
        }
    }

    private void heapifyDown(int[] nums, int index) {
        if (index >= nums.length)
            return;

        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < nums.length && nums[leftChild] < nums[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < nums.length && nums[rightChild] < nums[smallest]) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(nums, index, smallest);
            heapifyDown(nums, smallest);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public class BuildHeapFromGivenArray {
    public static void main(String[] args) {

    }
}
