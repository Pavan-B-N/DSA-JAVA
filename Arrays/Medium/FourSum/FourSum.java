package Arrays.Medium.FourSum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/4sum/description/
// https://takeuforward.org/practice/dsa/4-sum?category=faqs-medium&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N^3)
// Space Complexity: O(1) auxiliary space
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        // List.of() is immutable, so use ArrayList to allow driver-side sorting.
                        // res.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        res.add(new ArrayList<>(List.of(nums[i], nums[j], nums[left], nums[right])));

                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;

                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return res;
    }
}

public class FourSum {
    public static void main(String[] args) {

    }
}
