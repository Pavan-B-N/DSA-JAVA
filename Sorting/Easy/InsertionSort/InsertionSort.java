package Sorting.Easy.InsertionSort;
// https://takeuforward.org/practice/dsa/insertion-sorting?category=algorithms&source=strivers-a2z-dsa-sheet&sidebar=0

/*
Best:    O(n)
Average: O(n²)
Worst:   O(n²)
*/
// Time Complexity: O(N^2) worst/avg, O(N) best
// Space Complexity: O(1)
class Solution {
    public int[] insertionSort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int key = nums[i];

            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key;
        }

        return nums;
    }
}

public class InsertionSort {
    public static void main(String[] args) {

    }
}
