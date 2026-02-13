package LinkedList.Medium.CheckIfLLIsPalindrome;
import LinkedList.ListNode;

// https://leetcode.com/problems/palindrome-linked-list/description/
// https://takeuforward.org/practice/dsa/check-if-ll-is-palindrome-or-not?category=faqs--medium&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1) using reverse half
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode head2 = breakListAtMid(head);

        ListNode l1 = head;
        ListNode l2 = reverseLL(head2);

        while (l1 != null && l2 != null) {
            if (l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }

    private ListNode breakListAtMid(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        return head2;
    }

    private ListNode reverseLL(ListNode head) {
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

public class CheckIfLLIsPalindrome {
    public static void main(String[] args) {

    }
}
