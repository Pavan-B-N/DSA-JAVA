package Heaps.Medium.TopKFrequentElements;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-elements/description/
// https://takeuforward.org/practice/dsa/top-k-frequent-elements?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N log K) using min-heap or O(N) using bucket sort
// Space Complexity: O(N) for frequency map
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();// ele -> freq

        // compute frequency
        for (int ele : nums) {
            hashMap.put(ele, hashMap.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int ele = entry.getKey();
            int freq = entry.getValue();

            if (minHeap.size() < k) {
                minHeap.offer(new Pair(freq, ele));
            } else if (freq > minHeap.peek().freq) {
                minHeap.poll();
                minHeap.offer(new Pair(freq, ele));
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll().ele;
        }
        return res;

    }
}

class Pair {
    int freq;
    int ele;

    public Pair(int freq, int ele) {
        this.freq = freq;
        this.ele = ele;
    }
}

public class TopKFrequentElements {
    public static void main(String[] args) {

    }
}
