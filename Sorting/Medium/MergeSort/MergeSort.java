package Sorting.Medium.MergeSort;
// https://takeuforward.org/practice/dsa/merge-sorting?category=algorithms&source=strivers-a2z-dsa-sheet&tab=solution&sidebar=0

// Time Complexity: O(N log N)
// Space Complexity: O(N) for auxiliary array
class Solution {
    public int[] mergeSort(int[] nums) {
        int n = nums.length;
        mergeSort(0, n - 1, nums);
        return nums;
    }

    private void mergeSort(int low, int high, int[] nums) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSort(low, mid, nums);
            mergeSort(mid + 1, high, nums);

            merge(low, mid, high, nums);
        }
    }

    private void merge(int low, int mid, int high, int[] nums) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= high) {
            temp[k++] = nums[j++];
        }

        for (int index = 0; index < temp.length; index++) {
            nums[index + low] = temp[index];
        }
    }
}

public class MergeSort {
    public static void main(String[] args) {

    }
}
