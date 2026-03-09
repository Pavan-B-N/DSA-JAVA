package Stacks_and_Queues.Hard.MaximumRectangle;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://leetcode.com/problems/maximal-rectangle/
// https://takeuforward.org/practice/dsa/maximum-rectangles?category=faqs&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N * M) - Histogram technique per row
// Space Complexity: O(M) for heights array and stack
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        Arrays.fill(heights, 0);

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;

    }

    private int largestRectangleArea(int[] heights) {
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

public class MaximumRectangle {
    public static void main(String[] args) {

    }
}
