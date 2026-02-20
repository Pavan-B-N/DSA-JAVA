package LinkedList.Hard.RotateLL;
import LinkedList.ListNode;

// https://leetcode.com/problems/rotate-list/description/
// https://takeuforward.org/practice/dsa/rotate-a-ll?category=faqs--hard&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = findLen(head);

        if (head == null || k == 0 || (k % len) == 0)
            return head;

        k = k % len;

        ListNode tail = getTail(head);
        tail.next = head;

        ListNode curr = head;

        for (int i = 1; i < (len - k); i++) {
            curr = curr.next;
        }

        ListNode next = curr.next;

        curr.next = null;

        return next;

    }

    private int findLen(ListNode head) {
        int len = 0;

        ListNode curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        return len;
    }

    private ListNode getTail(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            curr = curr.next;
        }

        return curr;

    }
}

public class RotateLL {
    public static void main(String[] args) {

    }
}
