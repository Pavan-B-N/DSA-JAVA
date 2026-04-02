package Greedy.Medium.JumpGame2;
// https://takeuforward.org/practice/dsa/jump-game-ii?category=hard&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1) greedy range expansion
class Solution {
    int jump(int[] nums) {
        int curr = 0;
        int farthest = 0;

        int step = 0;

        for (int i = 0; i < nums.length; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == curr) {
                if (i == nums.length - 1)
                    return step;
                curr = farthest;
                step++;
            }
        }

        return step;
    }
}

public class JumpGame2 {
    public static void main(String[] args) {

    }
}
