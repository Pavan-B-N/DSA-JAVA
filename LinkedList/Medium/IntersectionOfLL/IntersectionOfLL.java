package LinkedList.Medium.IntersectionOfLL;
// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
// https://takeuforward.org/practice/dsa/find-the-intersection-point-of-y-ll?category=faqs--medium&source=strivers-a2z-dsa-sheet

import LinkedList.ListNode;

// Time Complexity: O(N1 + N2)
// Space Complexity: O(1) using two pointers
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;

        while (l1 != null || l2 != null) {

            if (l1 == null)
                l1 = headB;
            if (l2 == null)
                l2 = headA;

            if (l1 == l2)
                return l1;

            l1 = l1.next;
            l2 = l2.next;

        }

        return null;
    }
}

public class IntersectionOfLL {
    public static void main(String[] args) {

    }
}
