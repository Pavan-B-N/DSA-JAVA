package LinkedList.Easy.DeletekthElementInLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/deletion-of-the-kth-element-of-ll

// Time Complexity: O(K)
// Space Complexity: O(1)
class Solution {
    public ListNode deleteKthNode(ListNode head, int k) {
        if (head == null || head.next == null)
            return null;

        if (k == 1)
            return head.next;

        ListNode curr = head;

        int count = 1;

        while (curr != null) {
            if (count == k - 1)
                break;
            curr = curr.next;
            count++;
        }

        curr.next = curr.next.next;

        return head;
    }
}

public class DeletekthElementInLL {
    public static void main(String[] args) {

    }
}
