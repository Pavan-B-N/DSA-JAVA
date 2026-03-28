package Heaps.Hard.FindMedianFromDataStream;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/description/
// https://takeuforward.org/practice/dsa/find-median-from-data-stream?category=faqs&source=strivers-a2z-dsa-sheet

// Time Complexity: O(log N) for addNum, O(1) for findMedian
// Space Complexity: O(N) for two heaps
class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

    public MedianFinder() {

    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        int n = minHeap.size() + maxHeap.size();

        if (n % 2 == 1) {
            return minHeap.peek();
        } else {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        }
    }
}

// Time Complexity: O(log N) for addNum, O(1) for findMedian
// Space Complexity: O(N) for two heaps
public class FindMedianFromDataStream {
    public static void main(String[] args) {

    }
}
