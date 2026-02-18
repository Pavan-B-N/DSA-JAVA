package LinkedList.Medium.ReverseLL;
import LinkedList.ListNode;

// https://leetcode.com/problems/reverse-linked-list/
// https://takeuforward.org/practice/dsa/reverse-a-ll?category=logic-building&source=strivers-a2z-dsa-sheet&tab=problem&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1) iterative in-place
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        return prev;
    }
}

public class ReverseLL {
    public static void main(String[] args) {

    }
}
