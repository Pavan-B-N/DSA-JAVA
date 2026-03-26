package Heaps.Medium.MinimumCostToConnectSticks;
import java.util.List;
import java.util.PriorityQueue;

// https://takeuforward.org/practice/dsa/minimum-cost-to-connect-sticks?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N log N)
// Space Complexity: O(N) for priority queue
class Solution {
    public int connectSticks(List<Integer> sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int ele : sticks)
            minHeap.offer(ele);

        int ans = 0;

        while (minHeap.size() > 1) {
            int ele1 = minHeap.poll();
            int ele2 = minHeap.poll();

            int newStick = ele1 + ele2;

            ans += newStick;

            minHeap.offer(newStick);
        }

        return ans;
    }
}

public class MinimumCostToConnectSticks {
    public static void main(String[] args) {

    }
}
