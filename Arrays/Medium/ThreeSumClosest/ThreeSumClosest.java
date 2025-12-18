package Arrays.Medium.ThreeSumClosest;
import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/description/
// tag: [star]


// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;
    }
}

public class ThreeSumClosest {
    public static void main(String[] args) {

    }
}
