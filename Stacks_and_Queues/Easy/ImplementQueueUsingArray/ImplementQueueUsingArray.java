package Stacks_and_Queues.Easy.ImplementQueueUsingArray;
// https://takeuforward.org/practice/dsa/implement-queue-using-arrays?category=implementation&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(1) per enqueue, dequeue, peek
// Space Complexity: O(N) for array storage
class ArrayQueue {
    int[] arr;
    int front, rear;
    int capacity = 100;

    public ArrayQueue() {
        arr = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void push(int x) {
        if (isEmpty()) {
            front = (front + 1) % capacity;
        }
        rear = (rear + 1) % capacity;

        arr[rear] = x;
    }

    public int pop() {
        int ele = arr[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        return ele;
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return arr[front];
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }
}

// Time Complexity: O(1) per enqueue, dequeue, peek
// Space Complexity: O(N) for array storage
public class ImplementQueueUsingArray {
    public static void main(String[] args) {

    }
}
