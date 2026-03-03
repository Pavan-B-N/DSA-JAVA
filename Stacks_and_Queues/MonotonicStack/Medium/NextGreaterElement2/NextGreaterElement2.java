package Stacks_and_Queues.MonotonicStack.Medium.NextGreaterElement2;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/next-greater-element-ii/description/
// https://takeuforward.org/practice/dsa/next-greater-element---2?category=monotonic-stack&source=strivers-a2z-dsa-sheet/

// Time Complexity: O(N) - Monotonic Stack on 2*N circular array
// Space Complexity: O(N) for stack
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        Deque<Integer> stack = new ArrayDeque<>();

        int[] res = new int[nums.length];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }

            res[i % n] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i % n]);
        }

        return res;
    }
}

public class NextGreaterElement2 {
    public static void main(String[] args) {

    }
}
