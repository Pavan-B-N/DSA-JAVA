package LinkedList.Hard.SortLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/sort-ll?category=faqs--hard&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem&solution=optimal
// https://leetcode.com/problems/sort-list/

// Time Complexity: O(N log N) - Merge Sort on Linked List
// Space Complexity: O(log N) recursion stack
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = getMid(head);
        ListNode head2 = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(head2);

        return mergeLL(left, right);
    }

    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode mergeLL(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        tail.next = list1 != null ? list1 : list2;

        return dummy.next;
    }
}

public class SortLL {
    public static void main(String[] args) {

    }
}
