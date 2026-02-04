package LinkedList.Easy.DeleteElementWithValueX;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/delete-the-element-with-value-x

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode deleteNodeWithValueX(ListNode head, int X) {
        if (head == null)
            return null;
        if (head.data == X)
            return head.next;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (curr.data == X) {
                prev.next = curr.next;
                break;
            }

            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}

public class DeleteElementWithValueX {
    public static void main(String[] args) {

    }
}
