package Heaps.Easy.HeapifyAlgorithm;
// https://takeuforward.org/practice/dsa/heapify-algorithm?category=theory-and-implementation&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(log N)
// Space Complexity: O(1) iterative or O(log N) recursion stack
class Solution {
    public void heapify(int[] nums, int ind, int val) {
        if (val < nums[ind]) {
            nums[ind] = val;
            heapifyUp(nums, ind);
        } else {
            nums[ind] = val;
            heapifyDown(nums, ind);
        }
    }

    private void heapifyUp(int[] nums, int index) {
        if (index == 0) {
            return;
        }

        int parent = (index - 1) / 2;

        if (parent >= 0 && nums[index] < nums[parent]) {
            swap(nums, index, parent);
            heapifyUp(nums, parent);
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

public class HeapifyAlgorithm {
    public static void main(String[] args) {

    }
}
