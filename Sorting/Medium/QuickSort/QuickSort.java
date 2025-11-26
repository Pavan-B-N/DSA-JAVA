package Sorting.Medium.QuickSort;
// https://takeuforward.org/practice/dsa/quick-sorting?category=algorithms&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N log N) avg, O(N^2) worst
// Space Complexity: O(log N) auxiliary recursion stack
class Solution {
    public int[] quickSort(int[] nums) {
        int n = nums.length;
        quickSort(0, n - 1, nums);

        return nums;
    }

    private void quickSort(int low, int high, int[] nums) {
        if (low < high) {
            int j = partition(low, high, nums);

            quickSort(low, j - 1, nums);
            quickSort(j + 1, high, nums);
        }
    }

    private int partition(int low, int high, int[] nums) {
        int pivot = nums[low];
        int i = low;
        int j = high;

        while (i <= j) {
            while (i <= j && nums[i] <= pivot)
                i++;
            while (i <= j && nums[j] >= pivot)
                j--;

            if (i <= j)
                swap(i, j, nums);
        }

        swap(low, j, nums);

        return j;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public class QuickSort {
    public static void main(String[] args) {

    }
}
