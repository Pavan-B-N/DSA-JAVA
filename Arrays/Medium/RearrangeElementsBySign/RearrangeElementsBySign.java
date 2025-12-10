package Arrays.Medium.RearrangeElementsBySign;
// https://leetcode.com/problems/rearrange-array-elements-by-sign/
// https://takeuforward.org/practice/dsa/rearrange-array-elements-by-sign

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posIndex = 0;
        int negIndex = 1;

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                res[posIndex] = nums[i];
                posIndex += 2;
            } else {
                res[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return res;
    }
}

public class RearrangeElementsBySign {
    public static void main(String[] args) {

    }
}
