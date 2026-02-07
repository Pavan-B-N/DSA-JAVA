package LinkedList.Easy.DeleteTailOfLL;
// https://takeuforward.org/practice/dsa/deletion-of-the-tail-of-ll
import LinkedList.ListNode;

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode deleteTail(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode curr = head;

        while (curr.next.next != null) {
            curr = curr.next;
        }

        curr.next = null;

        return head;
    }
}

public class DeleteTailOfLL {
    public static void main(String[] args) {

    }
}
