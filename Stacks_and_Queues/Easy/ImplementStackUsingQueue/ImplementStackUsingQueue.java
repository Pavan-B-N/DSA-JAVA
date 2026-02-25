package Stacks_and_Queues.Easy.ImplementStackUsingQueue;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/implement-stack-using-queues/
// https://takeuforward.org/practice/dsa/implement-stack-using-queue?category=implementation&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N) push or O(N) pop
// Space Complexity: O(N) for queues
class MyStack {

    Deque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

// Time Complexity: O(N) push or O(N) pop
// Space Complexity: O(N) for queues
public class ImplementStackUsingQueue {
    public static void main(String[] args) {

    }
}
