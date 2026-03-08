package Stacks_and_Queues.MonotonicStack.Hard.SubOfSubArrayRanges;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/sum-of-subarray-ranges/description/
// https://takeuforward.org/practice/dsa/sum-of-subarray-ranges?category=monotonic-stack&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N) - Monotonic Stack
// Space Complexity: O(N) for stacks and arrays
class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }

    private long sumSubarrayMins(int[] arr) {
        long res = 0;

        Deque<Integer> stack = new ArrayDeque<>();// stores indices
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] > arr[i])) {
                int curr = stack.peek();
                stack.pop();

                long pse = stack.isEmpty() ? -1 : stack.peek();
                long nse = i;

                long totalContribition = (curr - pse) * (nse - curr);
                res = (res + totalContribition * arr[curr]);
            }

            stack.push(i);
        }

        return res;

    }

    private long sumSubarrayMax(int[] arr) {
        long res = 0;

        Deque<Integer> stack = new ArrayDeque<>();// stores indices
        int n = arr.length;

        // iterating to find PGE
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] <= arr[i])) {
                int curr = stack.peek();
                stack.pop();

                long pge = stack.isEmpty() ? -1 : stack.peek();
                long nge = i;

                long totalContribition = (curr - pge) * (nge - curr);
                res = (res + totalContribition * arr[curr]);
            }

            stack.push(i);
        }

        return res;

    }
}

public class SubOfSubArrayRanges {
    public static void main(String[] args) {

    }
}
