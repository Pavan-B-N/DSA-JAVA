package Stacks_and_Queues.Easy.ImplementStackUsingLL;
// https://takeuforward.org/practice/dsa/implement-stack-using-linkedlist?category=implementation&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(1) per operation
// Space Complexity: O(N) for nodes
class LinkedListStack {
    ListNode head;

    public LinkedListStack() {
        head = null;
    }

    public void push(int x) {
        ListNode newNode = new ListNode(x);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null)
            return -1;

        int ele = head.data;
        head = head.next;
        return ele;
    }

    public int top() {
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}

// Time Complexity: O(1) per operation
// Space Complexity: O(N) for nodes
public class ImplementStackUsingLL {
    public static void main(String[] args) {

    }
}
