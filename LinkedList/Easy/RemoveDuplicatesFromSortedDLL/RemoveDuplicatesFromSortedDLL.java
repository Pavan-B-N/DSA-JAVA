package LinkedList.Easy.RemoveDuplicatesFromSortedDLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/remove-duplicated-from-sorted-dll?category=faqs--dll&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head.next;

        while (curr != null) {
            ListNode prev = curr.prev;
            ListNode next = curr.next;

            if (prev.val == curr.val) {
                // delete curr
                prev.next = next;

                if (next != null)
                    next.prev = prev;
            }

            curr = curr.next;
        }

        return head;
    }
}

public class RemoveDuplicatesFromSortedDLL {
    public static void main(String[] args) {

    }
}
