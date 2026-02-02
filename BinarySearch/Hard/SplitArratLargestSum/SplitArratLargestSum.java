package BinarySearch.Hard.SplitArratLargestSum;
import java.util.Arrays;

// https://leetcode.com/problems/split-array-largest-sum/
// https://takeuforward.org/practice/dsa/split-array---largest-sum?category=faqs&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N * log(sum - max))
// Space Complexity: O(1)
class Solution {
    public int splitArray(int[] nums, int k) {
        int start = Arrays.stream(nums).max().getAsInt();
        int end = Arrays.stream(nums).sum();

        while (start <= end) {
            // mid = sum
            int mid = start + (end - start) / 2;

            if (countSplits(nums, mid) > k) {
                // increase sum
                start = mid + 1;
            } else {
                // ans
                end = mid - 1;
            }
        }

        return (int) start;
    }

    private int countSplits(int[] nums, int maxSubArraySum) {
        int count = 1;

        int currSum = 0;

        for (int ele : nums) {
            if (currSum + ele <= maxSubArraySum) {
                currSum += ele;
            } else {
                currSum = ele;
                count++;
            }
        }

        return count;

    }
}

public class SplitArratLargestSum {
    public static void main(String[] args) {

    }
}
