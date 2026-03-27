package Heaps.Medium.SortKSortedArray;
import java.util.PriorityQueue;

// https://takeuforward.org/practice/dsa/sort-a-k-sorted-array?category=faqs&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N log K)
// Space Complexity: O(K) for min-heap
class Solution {
    public int[] sortKSortedArray(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0;

        while (i <= k) {
            minHeap.offer(arr[i++]);
        }

        int ptr = 0;
        while (!minHeap.isEmpty()) {
            res[ptr++] = minHeap.poll();

            if (i < n) {
                minHeap.offer(arr[i++]);
            }
        }

        return res;
    }
}

public class SortKSortedArray {
    public static void main(String[] args) {

    }
}
