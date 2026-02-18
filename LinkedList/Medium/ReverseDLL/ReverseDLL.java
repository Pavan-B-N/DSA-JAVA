package LinkedList.Medium.ReverseDLL;
// https://takeuforward.org/practice/dsa/reverse-a-doubly-linked-list
import LinkedList.ListNode;

// Time Complexity: O(N)
// Space Complexity: O(1) in-place
class Solution {
    public ListNode reverseDLL(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;

            curr = curr.prev;
        }

        return prev.prev;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1) in-place
class Solution_3Pointer {
    public ListNode reverseDLL(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr != null) {
            prev = curr.prev;
            next = curr.next;

            curr.next = prev;
            curr.prev = next;

            curr = next;

        }

        return prev.prev;
    }
}

public class ReverseDLL {
    public static void main(String[] args) {

    }
}
