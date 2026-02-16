package LinkedList.Medium.LengthOfLoopInLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/length-of-loop-in-ll?category=faqs--medium&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int findLengthOfLoop(ListNode head) {
        if (head == null)
            return 0;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                int len = 0;

                do {
                    slow = slow.next;
                    len++;
                } while (slow != fast);

                return len;
            }
        }

        return 0;

    }
}

public class LengthOfLoopInLL {
    public static void main(String[] args) {

    }
}
