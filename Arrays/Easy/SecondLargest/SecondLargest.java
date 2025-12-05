package Arrays.Easy.SecondLargest;
// https://takeuforward.org/practice/dsa/second-largest-element

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int secondLargestElement(int[] nums) {
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = nums[i];
            } else if (nums[i] > secondLargest && nums[i] < firstLargest) {
                secondLargest = nums[i];
            }
        }

        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}

public class SecondLargest {
    public static void main(String[] args) {

    }
}
