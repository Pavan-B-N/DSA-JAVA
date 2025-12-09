package Arrays.Medium.NextPermutation;
// https://leetcode.com/problems/next-permutation/description/
// https://takeuforward.org/practice/dsa/next-permutation?category=faqs-medium&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1) in-place
class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;

        // find pivot
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // RGE > pivot
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }

        // rever pivot+1 to n
        reverse(nums, pivot + 1, n - 1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int i, int j) {
        if (i >= j)
            return;

        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}

public class NextPermutation {
    public static void main(String[] args) {

    }
}
