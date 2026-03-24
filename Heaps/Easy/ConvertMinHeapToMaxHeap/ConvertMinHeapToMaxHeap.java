package Heaps.Easy.ConvertMinHeapToMaxHeap;
// https://takeuforward.org/practice/dsa/convert-min-heap-to-max-heap?category=theory-and-implementation&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem

// Time Complexity: O(N) using bottom-up max-heapify
// Space Complexity: O(1) in-place
class Solution {
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;

        // Iterate backwards on non-leaf node
        for (int i = (n / 2 - 1); i >= 0; i--) {
            heapifyDown(nums, i);
        }
        return nums;
    }

    private void heapifyDown(int[] nums, int index) {
        if (index >= nums.length)
            return;

        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < nums.length && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }

        if (rightChild < nums.length && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }

        if (largest != index) {
            swap(nums, index, largest);
            heapifyDown(nums, largest);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public class ConvertMinHeapToMaxHeap {
    public static void main(String[] args) {

    }
}
