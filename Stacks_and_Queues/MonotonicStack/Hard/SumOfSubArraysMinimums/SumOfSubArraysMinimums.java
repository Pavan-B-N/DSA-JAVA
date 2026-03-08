package Stacks_and_Queues.MonotonicStack.Hard.SumOfSubArraysMinimums;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/sum-of-subarray-minimums/
// https://takeuforward.org/practice/dsa/sum-of-subarray-minimums?category=monotonic-stack&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N) - Monotonic Stack
// Space Complexity: O(N) for stacks and arrays
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        int MOD = (int) (1e9 + 7);

        Deque<Integer> stack = new ArrayDeque<>();// stores indices
        int n = arr.length;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] > arr[i])) {
                int curr = stack.peek();
                stack.pop();

                int pse = stack.isEmpty() ? -1 : stack.peek();
                int nse = i;

                int totalContribition = (curr - pse) * (nse - curr);
                res = (res + (long) totalContribition * arr[curr]) % MOD;
            }

            stack.push(i);
        }

        return (int) res;

    }
}

public class SumOfSubArraysMinimums {
    public static void main(String[] args) {

    }
}
