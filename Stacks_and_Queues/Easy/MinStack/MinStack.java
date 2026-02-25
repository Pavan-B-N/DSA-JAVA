package Stacks_and_Queues.Easy.MinStack;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/min-stack/
// https://takeuforward.org/practice/dsa/implement-min-stack?category=faqs&source=strivers-a2z-dsa-sheet

// Time Complexity: O(1) for push, pop, top, getMin
// Space Complexity: O(N) for stack elements / pair
class Solution {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public Solution() {

    }

    public void push(int value) {
        if (stack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
        stack.push(value);
    }

    public void pop() {
        // Do not use ==, which comapres references not content
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

class MinStack_Optimal {
    Deque<Long> stack = new ArrayDeque<>();
    long minEle;

    public MinStack_Optimal() {
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            minEle = value;
            stack.push((long) value);
        } else if (value < minEle) {
            stack.push(2L * value - minEle);
            minEle = value;
        } else {
            stack.push((long) value);
        }
    }

    public void pop() {
        if (stack.peek() < minEle) {
            minEle = 2 * minEle - stack.peek();
        }

        stack.pop();
    }

    public int top() {
        if (stack.peek() < minEle) {
            return (int) minEle;
        }

        return stack.peek().intValue();
    }

    public int getMin() {
        return (int) minEle;
    }
}

public class MinStack {
    public static void main(String[] args) {

    }
}
