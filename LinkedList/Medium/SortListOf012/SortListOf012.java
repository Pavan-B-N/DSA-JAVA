package LinkedList.Medium.SortListOf012;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/sort-a-ll-of-0's-1's-and-2's?category=logic-building&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1) by linking pointers
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;

        ListNode zeroHead = new ListNode();
        ListNode zeroTail = zeroHead;

        ListNode oneHead = new ListNode();
        ListNode oneTail = oneHead;

        ListNode twoHead = new ListNode();
        ListNode twoTail = twoHead;

        ListNode curr = head;

        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }

            curr = curr.next;
        }

        twoTail.next = null;
        oneTail.next = twoHead.next;
        zeroTail.next = oneHead.next;

        return zeroHead.next;
    }
}

public class SortListOf012 {
    public static void main(String[] args) {

    }
}
