package LinkedList.Easy.DeleteTailOfDLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/delete-tail-of-dll

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode deleteTail(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode curr = head;
        ListNode prev = null;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        curr.prev = null;

        return head;
    }
}

public class DeleteTailOfDLL {
    public static void main(String[] args) {

    }
}
