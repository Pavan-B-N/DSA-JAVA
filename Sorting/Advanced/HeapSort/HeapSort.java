package Sorting.Advanced.HeapSort;
// https://takeuforward.org/practice/dsa/heap-sort?category=theory-and-implementation&source=strivers-a2z-dsa-sheet&tab=problem

// Time Complexity: O(N log N)
// Space Complexity: O(1)
class Solution {
    private void heapifyDown(int[] arr, int last, int ind) {
        int largestInd = ind;

        int leftChildInd = 2 * ind + 1;
        int rightChildInd = 2 * ind + 2;

        if (leftChildInd <= last && arr[leftChildInd] > arr[largestInd]) {
            largestInd = leftChildInd;
        }

        if (rightChildInd <= last && arr[rightChildInd] > arr[largestInd]) {
            largestInd = rightChildInd;
        }

        if (largestInd != ind) {
            int temp = arr[largestInd];
            arr[largestInd] = arr[ind];
            arr[ind] = temp;

            heapifyDown(arr, last, largestInd);
        }
    }

    private void buildMaxHeap(int[] nums) {
        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(nums, n - 1, i);
        }
    }

    public void heapSort(int[] nums) {
        buildMaxHeap(nums);

        int last = nums.length - 1;

        while (last > 0) {
            int temp = nums[0];
            nums[0] = nums[last];
            nums[last] = temp;

            last--;

            if (last > 0) {
                heapifyDown(nums, last, 0);
            }
        }
    }
}

public class HeapSort {
    public static void main(String[] args) {

    }
}
