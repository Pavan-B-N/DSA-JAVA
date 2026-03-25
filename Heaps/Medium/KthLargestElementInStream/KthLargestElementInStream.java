package Heaps.Medium.KthLargestElementInStream;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
// https://takeuforward.org/practice/dsa/kth-largest-element-in-a-stream-of-running-integers?category=faqs&source=strivers-a2z-dsa-sheet&tab=problem&sidebar=0

// Time Complexity: O(log K) per add operation
// Space Complexity: O(K) for min-heap of size K
class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;

        for (int ele : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(ele);
            } else if (ele > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(ele);
            }
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }
}

// Time Complexity: O(log K) per add operation
// Space Complexity: O(K) for min-heap of size K
public class KthLargestElementInStream {
    public static void main(String[] args) {

    }
}
