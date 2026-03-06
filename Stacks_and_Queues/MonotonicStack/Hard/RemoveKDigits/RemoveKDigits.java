package Stacks_and_Queues.MonotonicStack.Hard.RemoveKDigits;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/remove-k-digits/
// https://takeuforward.org/practice/dsa/remove-k-digits?category=monotonic-stack&source=strivers-a2z-dsa-sheet&tab=problem

// Time Complexity: O(N) - Monotonic Stack
// Space Complexity: O(N) for stack and string builder
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.peek());
            stack.pop();
        }

        // reverse
        sb.reverse();

        int i = 0;

        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String res = sb.substring(i);

        return res.isEmpty() ? "0" : res;

    }
}

public class RemoveKDigits {
    public static void main(String[] args) {

    }
}
