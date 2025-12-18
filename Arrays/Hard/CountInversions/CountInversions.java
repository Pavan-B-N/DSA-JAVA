package Arrays.Hard.CountInversions;
// https://takeuforward.org/practice/dsa/count-inversions?category=faqs-hard&source=strivers-a2z-dsa-sheet&sidebar=0
// tag: [revise]


// Time Complexity: O(N log N) - Modified Merge Sort
// Space Complexity: O(N) auxiliary space
class Solution {
    public long numberOfInversions(int[] nums) {
        int n = nums.length;
        return mergeSort(0, n - 1, nums);
    }

    private long mergeSort(int low, int high, int[] nums) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            long count = 0;

            count += mergeSort(low, mid, nums);
            count += mergeSort(mid + 1, high, nums);

            count += merge(low, mid, high, nums);

            return count;
        }
        return 0;
    }

    private long merge(int low, int mid, int high, int[] nums) {
        int temp[] = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        long count = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                count += (mid - i + 1);
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

        return count;
    }
}

public class CountInversions {
    public static void main(String[] args) {

    }
}
