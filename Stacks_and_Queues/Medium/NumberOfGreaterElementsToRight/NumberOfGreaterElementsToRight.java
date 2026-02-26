package Stacks_and_Queues.Medium.NumberOfGreaterElementsToRight;
// https://takeuforward.org/practice/dsa/number-of-greater-elements-to-the-right?category=faqs&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(N * Q) brute, O(N log N) using merge sort / BIT
// Space Complexity: O(N)
class Solution {
    public List<Integer> count_NGE(int[] arr, int[] indices) {
        List<Integer> ans = new ArrayList<>();

        for (int idx : indices) {
            int x = arr[idx];
            int cnt = 0;

            for (int j = idx + 1; j < arr.length; j++) {
                if (arr[j] > x) {
                    cnt++;
                }
            }

            ans.add(cnt);
        }

        return ans;
    }
}

public class NumberOfGreaterElementsToRight {
    public static void main(String[] args) {

    }
}
