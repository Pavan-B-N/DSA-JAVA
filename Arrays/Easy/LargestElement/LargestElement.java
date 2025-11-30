package Arrays.Easy.LargestElement;
// https://takeuforward.org/practice/dsa/largest-element

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int largestElement(int[] nums) {
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, nums[i]);
        }

        return ans;
    }
}

public class LargestElement {
    public static void main(String[] args) {

    }
}
