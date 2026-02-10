package LinkedList.Easy.InsertAtTheTailOfLL;
// https://takeuforward.org/practice/dsa/insertion-at-the-tail-of-ll

import LinkedList.ListNode;

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode insertAtTail(ListNode head, int X) {
        ListNode newNode = new ListNode(X);

        if (head == null)
            return newNode;

        ListNode curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;

        return head;
    }
}

public class InsertAtTheTailOfLL {
    public static void main(String[] args) {

    }
}
