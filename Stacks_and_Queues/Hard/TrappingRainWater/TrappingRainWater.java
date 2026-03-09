package Stacks_and_Queues.Hard.TrappingRainWater;
// relevant: Arrays/ContainerWithMostWater/ContainerWithMostWater.java

// https://leetcode.com/problems/trapping-rain-water/description/
// https://takeuforward.org/practice/dsa/trapping-rainwater?category=faqs&source=strivers-a2z-dsa-sheet&tab=problem&solution=optimal-approach

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int leftMax = 0;
        int rightMax = 0;

        int ans = 0;

        while (i <= j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);

            if (leftMax < rightMax) {
                ans += (leftMax - height[i]);
                i++;
            } else {
                ans += (rightMax - height[j]);
                j--;
            }
        }

        return ans;
    }
}

public class TrappingRainWater {
    public static void main(String[] args) {

    }
}
