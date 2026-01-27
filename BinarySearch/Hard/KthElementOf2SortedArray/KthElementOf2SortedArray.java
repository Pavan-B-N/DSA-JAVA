package BinarySearch.Hard.KthElementOf2SortedArray;
// https://takeuforward.org/practice/dsa/kth-element-of-2-sorted-arrays?category=faqs&source=strivers-a2z-dsa-sheet

// Time Complexity: O(log(min(K, N1, N2)))
// Space Complexity: O(1)
class Solution {
    public int kthElement(int[] arr1, int[] arr2, int k) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        if (n1 > n2) {
            return kthElement(arr2, arr1, k);
        }

        int left = k;

        int start = Math.max(0, left - n2); // 0
        int end = Math.min(n1, left); // n1

        while (start <= end) {
            int mid1 = start + (end - start) / 2; // mid1 = r1
            int mid2 = left - mid1; // r2

            int l1 = (mid1 - 1 >= 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 - 1 >= 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;

            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                end = mid1 - 1;
            } else {
                start = mid1 + 1;
            }
        }

        return -1;
    }
}

public class KthElementOf2SortedArray {
    public static void main(String[] args) {

    }
}
