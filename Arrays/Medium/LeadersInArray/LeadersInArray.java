package Arrays.Medium.LeadersInArray;
// https://takeuforward.org/practice/dsa/leaders-in-an-array

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public List<Integer> leaders(int[] nums) {
        int maxEle = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > maxEle) {
                res.add(nums[i]);
                maxEle = nums[i];
            }
        }

        Collections.reverse(res);

        return res;
    }
}

public class LeadersInArray {
    public static void main(String[] args) {

    }
}
