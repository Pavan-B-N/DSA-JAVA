package LinkedList.Hard.ReverseLLInGroupOfK;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/reverse-ll-in-group-of-given-size-k?category=faqs--hard&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/reverse-nodes-in-k-group/

// Time Complexity: O(N)
// Space Complexity: O(1) in-place
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            // find kth node
            ListNode kthNode = curr;
            int count = 1;

            while (count < k && kthNode != null) {
                kthNode = kthNode.next;
                count++;
            }

            // not able to find group of k nodes so its last group
            if (kthNode == null) {
                prev.next = curr;
                break;
            }

            ListNode next = kthNode.next;
            kthNode.next = null;

            if (prev != null) {
                prev.next = reverseLL(curr);
            } else {
                head = reverseLL(curr);
            }

            prev = curr;

            curr = next;
        }

        return head;
    }

    private ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        return prev;
    }
}

public class ReverseLLInGroupOfK {
    public static void main(String[] args) {

    }
}
