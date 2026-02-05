package LinkedList.Easy.DeleteKthElementInDLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/delete-kth-element-of-dll

// Time Complexity: O(K)
// Space Complexity: O(1)
class Solution {
    public ListNode deleteKthElement(ListNode head, int k) {
        if (head == null)
            return null;

        int count = 1;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (count == k)
                break;

            count++;
            prev = curr;
            curr = curr.next;
        }

        if (prev == null) {
            head = head.next;
            if (head != null)
                head.prev = null;
        } else {
            ListNode next = curr.next;

            prev.next = next;
            if (next != null)
                next.prev = prev;

            // optionally
            curr.prev = null;
            curr.next = null;
        }

        return head;
    }
}

public class DeleteKthElementInDLL {
    public static void main(String[] args) {

    }
}
