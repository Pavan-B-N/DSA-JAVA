package LinkedList.Medium.DetectLoopInLL;
import LinkedList.ListNode;

// https://leetcode.com/problems/linked-list-cycle/
// https://takeuforward.org/practice/dsa/detect-a-loop-in-ll?category=faqs--medium&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N) - Floyd's Cycle-Finding Algorithm
// Space Complexity: O(1)
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}

public class DetectLoopInLL {
    public static void main(String[] args) {
        
    }
}
