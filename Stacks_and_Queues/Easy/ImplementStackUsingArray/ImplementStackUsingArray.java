package Stacks_and_Queues.Easy.ImplementStackUsingArray;
// https://takeuforward.org/practice/dsa/implement-stack-using-arrays?category=implementation&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(1) per push, pop, top
// Space Complexity: O(N) for array storage
class ArrayStack {
    int[] arr;
    int topEleIndex = -1;

    public ArrayStack() {
        arr = new int[100];
        topEleIndex = -1;
    }

    public void push(int x) {
        arr[++topEleIndex] = x;
    }

    public int pop() {
        return arr[topEleIndex--];
    }

    public int top() {
        if (topEleIndex == -1)
            return -1;
        return arr[topEleIndex];
    }

    public boolean isEmpty() {
        return topEleIndex == -1;
    }
}

// Time Complexity: O(1) per push, pop, top
// Space Complexity: O(N) for array storage
public class ImplementStackUsingArray {
    public static void main(String[] args) {

    }
}
