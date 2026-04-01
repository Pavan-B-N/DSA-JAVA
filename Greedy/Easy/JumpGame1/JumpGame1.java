package Greedy.Easy.JumpGame1;
// https://takeuforward.org/practice/dsa/jump-game---i?category=easy&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/jump-game/

// Time Complexity: O(N)
// Space Complexity: O(1) tracking max reachable index
class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (farthest < i)
                return false;

            farthest = Math.max(farthest, i + nums[i]);
        }

        return true;
    }
}

public class JumpGame1 {
    public static void main(String[] args) {

    }
}
