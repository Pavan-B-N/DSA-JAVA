package LinkedList.Medium.StartPointOfLoopInLL;
import LinkedList.ListNode;

// https://leetcode.com/problems/linked-list-cycle-ii/
// https://takeuforward.org/practice/dsa/find-the-starting-point-in-ll?category=faqs--medium&source=strivers-a2z-dsa-sheet&sidebar=0&tab=solution&solution=optimal

// Time Complexity: O(N) - Floyd's Cycle-Finding Algorithm
// Space Complexity: O(1)
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return fast;
            }
        }

        return null;

    }
}

public class StartPointOfLoopInLL {
    public static void main(String[] args) {
        
    }
}
