package Stacks_and_Queues.Easy.ImplementQueueUsingStack;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/implement-queue-using-stacks/description/
// https://takeuforward.org/practice/dsa/implement-queue-using-stack?category=implementation&source=strivers-a2z-dsa-sheet

// Time Complexity: Amortized O(1) per operation
// Space Complexity: O(N) for stacks
class MyQueue {

    Deque<Integer> s1 = new ArrayDeque<>();// primary
    Deque<Integer> s2 = new ArrayDeque<>();// secondary

    public MyQueue() {

    }

    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.peek());
            s1.pop();
        }

        s1.push(x);

        while (!s2.isEmpty()) {
            s1.push(s2.peek());
            s2.pop();
        }
    }

    public int pop() {
        int ele = s1.peek();

        s1.pop();

        return ele;
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

// Time Complexity: Amortized O(1) per operation
// Space Complexity: O(N) for stacks
public class ImplementQueueUsingStack {
    public static void main(String[] args) {

    }
}
