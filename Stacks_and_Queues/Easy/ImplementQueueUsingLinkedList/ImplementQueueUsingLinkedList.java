package Stacks_and_Queues.Easy.ImplementQueueUsingLinkedList;
// https://takeuforward.org/practice/dsa/implement-queue-using-linkedlist?category=implementation&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(1) per operation
// Space Complexity: O(N) for nodes
class LinkedListQueue {
    ListNode head;
    ListNode tail;

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    public void push(int x) {
        ListNode newNode = new ListNode(x);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public int pop() {
        if (isEmpty())
            return -1;
        int ele = head.data;
        head = head.next;

        if (head == null)
            tail = null;

        return ele;
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return head.data;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
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
public class ImplementQueueUsingLinkedList {
    public static void main(String[] args) {

    }
}
