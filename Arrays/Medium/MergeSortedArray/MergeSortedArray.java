package Arrays.Medium.MergeSortedArray;
// https://leetcode.com/problems/merge-sorted-array/
// https://takeuforward.org/practice/dsa/merge-two-sorted-arrays-without-extra-space?category=faqs-hard&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;

        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}

public class MergeSortedArray {
    public static void main(String[] args) {

    }
}
