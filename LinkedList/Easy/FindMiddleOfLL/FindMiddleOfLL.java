package LinkedList.Easy.FindMiddleOfLL;
import LinkedList.ListNode;

// https://leetcode.com/problems/middle-of-the-linked-list/
// https://takeuforward.org/practice/dsa/find-middle-of-linked-list?category=faqs--medium&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N) - Tortoise and Hare algorithm
// Space Complexity: O(1)
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

public class FindMiddleOfLL {
    public static void main(String[] args) {

    }
}
