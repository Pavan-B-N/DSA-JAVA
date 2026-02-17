package LinkedList.Medium.RemoveNthNodeFromEndOfLL;
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
// https://takeuforward.org/practice/dsa/remove-nth-node-from-the-back-of-the-ll?category=logic-building&source=strivers-a2z-dsa-sheet&sidebar=0

import LinkedList.ListNode;

// Time Complexity: O(N) single pass
// Space Complexity: O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // compute len
        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int stopingPoint = len - n;

        if (stopingPoint == 0) {
            return head.next;
        }

        curr = head;
        for (int i = 1; i < stopingPoint; i++) {
            curr = curr.next;
        }

        if (curr.next != null)
            curr.next = curr.next.next;

        return head;
    }
}

// Time Complexity: O(N) single pass
// Space Complexity: O(1)
class Solution_Optimal {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}

public class RemoveNthNodeFromEndOfLL {
    public static void main(String[] args) {

    }
}
