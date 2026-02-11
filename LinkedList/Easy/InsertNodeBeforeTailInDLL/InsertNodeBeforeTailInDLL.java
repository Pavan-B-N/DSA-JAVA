package LinkedList.Easy.InsertNodeBeforeTailInDLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/insert-node-before-tail-in-dll

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public ListNode insertBeforeTail(ListNode head, int X) {
        ListNode curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        // now curr == tail
        ListNode prev = curr.prev;
        ListNode newNode = new ListNode(X);

        if (prev != null) {
            prev.next = newNode;
            newNode.prev = prev;
        } else {
            head = newNode;
        }

        newNode.next = curr;
        curr.prev = newNode;

        return head;
    }
}

public class InsertNodeBeforeTailInDLL {
    public static void main(String[] args) {

    }
}
