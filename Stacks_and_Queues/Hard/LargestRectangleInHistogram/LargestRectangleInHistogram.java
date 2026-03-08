package Stacks_and_Queues.Hard.LargestRectangleInHistogram;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
// https://takeuforward.org/practice/dsa/largest-rectangle-in-a-histogram?category=faqs&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N) - Monotonic Stack single-pass
// Space Complexity: O(N) for stack
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int maxArea = 0;

        Deque<Integer> stack = new ArrayDeque<>();// store indices

        // previous smaller element
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                int curr = stack.peek();
                stack.pop();

                int pse = stack.isEmpty() ? -1 : stack.peek();
                int nse = i;

                int width = (nse - pse) - 1;
                int area = heights[curr] * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}

public class LargestRectangleInHistogram {
    public static void main(String[] args) {

    }
}
