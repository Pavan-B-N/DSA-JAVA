package Stacks_and_Queues.MonotonicStack.Medium.NextGreaterElement;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/practice/dsa/next-greater-element?category=monotonic-stack&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem&solution=optimal

// Time Complexity: O(N) - Monotonic Stack
// Space Complexity: O(N) for stack and result
class Solution {
    public int[] nextLargerElement(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        int n = arr.length;
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return res;
    }
}

// https://leetcode.com/problems/next-greater-element-i/

// Time Complexity: O(N) - Monotonic Stack
// Space Complexity: O(N) for stack and result
class Solution_V2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();

        int n1 = nums1.length;
        int n2 = nums2.length;

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = n2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {

                hashMap.put(nums2[i], stack.peek());
            } else {
                hashMap.put(nums2[i], -1);
            }
            stack.push(nums2[i]);
        }

        int[] res = new int[n1];

        for (int i = 0; i < n1; i++) {
            res[i] = hashMap.get(nums1[i]);
        }

        return res;
    }
}

public class NextGreaterElement {
    public static void main(String[] args) {

    }
}
