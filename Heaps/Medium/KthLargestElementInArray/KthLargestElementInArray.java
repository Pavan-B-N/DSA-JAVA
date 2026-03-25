package Heaps.Medium.KthLargestElementInArray;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// https://takeuforward.org/practice/dsa/k-th-largest-element-in-an-array?category=theory-and-implementation&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/kth-largest-element-in-an-array/

// Time Complexity: O(nlogn)
// Space Complexity: O(1)
class Solution_Brute {
    public int kthLargestElement(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums); // sorted in ascending order

        return nums[n - k];
    }
}

// Time Complexity: O(nlogn)
// Space Complexity: O(n)
class Solution_Brute_MaxHeap {
    public int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int ele : nums) {
            maxHeap.offer(ele);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        if (maxHeap.isEmpty())
            return -1;

        return maxHeap.peek();
    }
}

// Time Complexity: O(nlogk)
// Space Complexity: O(k)
class Solution {
    public int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int ele : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(ele);
            } else if (ele > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(ele);
            }
        }

        return minHeap.isEmpty() ? -1 : minHeap.peek();
    }
}

public class KthLargestElementInArray {
    public static void main(String[] args) {

    }
}
