package Arrays.Medium.ContainerWithMostWater;
// https://leetcode.com/problems/container-with-most-water/description/

// tag: [star]

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int maxArea(int[] height) {
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        int ans = Integer.MIN_VALUE;

        int n = height.length;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);

            if (leftMax < rightMax) {
                ans = Math.max(ans, (leftMax * (j - i)));
                i++;
            } else {
                ans = Math.max(ans, (rightMax * (j - i)));
                j--;
            }
        }

        return ans;
    }
}

public class ContainerWithMostWater {
    public static void main(String[] args) {

    }
}
