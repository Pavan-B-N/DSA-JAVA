package LinkedList.Easy.DeleteAllOccurancesOfKeyInDLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/delete-all-occurrences-of-a-key-in-dll?category=faqs--dll&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        if (head == null)
            return null;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val == target) {
                ListNode prev = curr.prev;
                ListNode next = curr.next;

                if (prev != null) {
                    prev.next = next;
                } else {
                    head = next;
                }

                if (next != null) {
                    next.prev = prev;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}

public class DeleteAllOccurancesOfKeyInDLL {
    public static void main(String[] args) {

    }
}
