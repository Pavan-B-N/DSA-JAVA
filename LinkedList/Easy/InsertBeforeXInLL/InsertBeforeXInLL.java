package LinkedList.Easy.InsertBeforeXInLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/insertion-before-the-value-x-in-ll

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode insertBeforeX(ListNode head, int X, int val) {
        if (head == null)
            return null;

        if (head.data == X) {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            return newNode;
        }

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (curr.data == X) {
                ListNode newNode = new ListNode(val);
                prev.next = newNode;
                newNode.next = curr;
            }

            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}

public class InsertBeforeXInLL {
    public static void main(String[] args) {

    }
}
