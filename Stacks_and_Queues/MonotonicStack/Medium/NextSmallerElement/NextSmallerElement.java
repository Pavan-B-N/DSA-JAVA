package Stacks_and_Queues.MonotonicStack.Medium.NextSmallerElement;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://takeuforward.org/practice/dsa/next-smaller-element?category=monotonic-stack&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N) - Monotonic Stack
// Space Complexity: O(N) for stack
class Solution {
    public int[] nextSmallerElements(int[] arr) {
        int n = arr.length;

        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return res;
    }
}

public class NextSmallerElement {
    public static void main(String[] args) {

    }
}
