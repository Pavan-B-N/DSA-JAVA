package Arrays.Easy.RightRotateArray;
// https://leetcode.com/problems/rotate-array/description/

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        if (k == 0 || k == n)
            return;

        this.reverse(nums, 0, n - 1);
        this.reverse(nums, 0, k - 1);
        this.reverse(nums, k, n - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            // swap
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}

public class RightRotateArray {
    public static void main(String[] args) {

    }
}
