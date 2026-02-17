package LinkedList.Medium.MergeTwoSortedLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/merge-sorted-lists-?category=faqs--hard&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/merge-two-sorted-lists/

// Time Complexity: O(N1 + N2)
// Space Complexity: O(1) in-place pointer manipulation
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

public class MergeTwoSortedLL {
    public static void main(String[] args) {

    }
}
