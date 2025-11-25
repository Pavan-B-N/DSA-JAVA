package Sorting.Easy.BubbleSort;
// https://takeuforward.org/practice/dsa/bubble-sort?category=algorithms&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem

/*
Best:    O(n)
Average: O(n²)
Worst:   O(n²)
*/
// Time Complexity: O(N^2) worst/avg, O(N) best
// Space Complexity: O(1)
class Solution {
    public int[] bubbleSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            boolean isAnySwap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isAnySwap = true;
                }
            }

            if (!isAnySwap) {
                break;
            }
        }

        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        if (i >= j)
            return;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

public class BubbleSort {
    public static void main(String[] args) {

    }
}
