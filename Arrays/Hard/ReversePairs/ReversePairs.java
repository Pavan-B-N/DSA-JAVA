package Arrays.Hard.ReversePairs;
// https://leetcode.com/problems/reverse-pairs/
// https://takeuforward.org/practice/dsa/reverse-pairs?category=faqs-hard&source=strivers-a2z-dsa-sheet
// tag:[revise]
// Time Complexity: O(N log N) - Modified Merge Sort
// Space Complexity: O(N) auxiliary space
class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(0, n - 1, nums);
    }

    private int mergeSort(int low, int high, int[] nums) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            int count = 0;

            count += mergeSort(low, mid, nums);
            count += mergeSort(mid + 1, high, nums);

            count += countReversePairs(low, mid, high, nums);

            merge(low, mid, high, nums);

            return count;
        }
        return 0;
    }

    private int countReversePairs(int low, int mid, int high, int[] nums) {
        int j = mid + 1;
        int count = 0;

        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2L * nums[j]) {
                j++;
            }

            count += (j - (mid + 1));
        }

        return count;

    }

    private void merge(int low, int mid, int high, int[] nums) {
        int temp[] = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
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

public class ReversePairs {
    public static void main(String[] args) {

    }
}
