package Heaps.Medium.MaximumSumCombination;
// https://takeuforward.org/practice/dsa/maximum-sum-combination?category=faqs&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(N log N + K log K)
// Space Complexity: O(K) for priority queue and visited set
class Solution {
    public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0])); // {sum, i, j}

        Set<String> hashSet = new HashSet<>();

        hashSet.add((n - 1) + "," + (n - 1));
        maxHeap.offer(new int[] { nums1[n - 1] + nums2[n - 1], n - 1, n - 1 });

        int[] res = new int[k];
        int idx = 0;

        while (!maxHeap.isEmpty() && idx < k) {
            int[] curr = maxHeap.poll();

            int sum = curr[0];
            int i = curr[1];
            int j = curr[2];

            res[idx++] = sum;

            // {i, j - 1}
            if (j - 1 >= 0) {
                String key = i + "," + (j - 1);

                if (!hashSet.contains(key)) {
                    maxHeap.offer(new int[] { nums1[i] + nums2[j - 1], i, j - 1 });

                    hashSet.add(key);
                }
            }

            // {i - 1, j}
            if (i - 1 >= 0) {
                String key = (i - 1) + "," + j;

                if (!hashSet.contains(key)) {
                    maxHeap.offer(new int[] { nums1[i - 1] + nums2[j], i - 1, j });

                    hashSet.add(key);
                }
            }
        }

        return Arrays.copyOf(res, idx);
    }
}

public class MaximumSumCombination {
    public static void main(String[] args) {

    }
}
