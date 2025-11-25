package Sorting.Easy.SelectionSort;
// https://takeuforward.org/practice/dsa/selection-sort?category=algorithms&source=strivers-a2z-dsa-sheet&sidebar=0

/*
Best:    O(n²)
Average: O(n²)
Worst:   O(n²)
*/
// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution {
    public int[] selectionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            if (min != i) {
                swap(nums, i, min);
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public class SelectionSort {
    public static void main(String[] args) {

    }
}
