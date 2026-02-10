package LinkedList.Easy.InsertAtKthPositionOfLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/insertion-at-the-kth-position-of-ll

// Time Complexity: O(K)
// Space Complexity: O(1)
class Solution {
    public ListNode insertAtKthPosition(ListNode head, int X, int K) {
        if (head == null || K == 1) {
            ListNode newNode = new ListNode(X);
            newNode.next = head;
            return newNode;
        }

        int count = 1;
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (count == K) {
                ListNode newNode = new ListNode(X);
                prev.next = newNode;
                newNode.next = curr;

                return head;
            }
            prev = curr;
            curr = curr.next;

            count++;
        }

        prev.next = new ListNode(X);

        return head;
    }
}

public class InsertAtKthPositionOfLL {

    public static void main(String[] args) {

    }
}