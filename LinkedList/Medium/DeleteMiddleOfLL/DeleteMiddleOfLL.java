package LinkedList.Medium.DeleteMiddleOfLL;
// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

import LinkedList.ListNode;

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow.next != null)
            slow.next = slow.next.next;

        return head;
    }
}

public class DeleteMiddleOfLL {
    public static void main(String[] args) {

    }
}
