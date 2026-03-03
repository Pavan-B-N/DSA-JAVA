package Stacks_and_Queues.MonotonicStack.Medium.AsteroidCollision;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/asteroid-collision/

// Time Complexity: O(N)
// Space Complexity: O(N) for stack
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = asteroids.length;

        for (int i = 0; i < n; i++) {
            boolean survive = true;
            while (!stack.isEmpty() && asteroids[i] < 0 && survive && stack.peek() > 0) {
                if (stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                    survive = false;
                } else if (stack.peek() > Math.abs(asteroids[i])) {
                    survive = false;
                } else if (stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }
            }

            if (survive)
                stack.push(asteroids[i]);
        }

        int[] res = new int[stack.size()];
        int i = 0;

        while (!stack.isEmpty()) {
            res[i++] = stack.peek();
            stack.pop();
        }

        reverse(res);

        return res;
    }

    private void reverse(int[] res) {
        int i = 0;
        int j = res.length - 1;

        while (i < j) {
            // swap
            int temp = res[i];
            res[i] = res[j];
            res[j] = temp;

            i++;
            j--;
        }

    }
}

public class AsteroidCollision {
    public static void main(String[] args) {

    }
}
