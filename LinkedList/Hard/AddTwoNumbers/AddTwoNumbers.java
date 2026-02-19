package LinkedList.Hard.AddTwoNumbers;
import LinkedList.ListNode;

// https://leetcode.com/problems/add-two-numbers/description/
// https://takeuforward.org/practice/dsa/add-two-numbers-in-ll?category=logic-building&source=strivers-a2z-dsa-sheet

// Time Complexity: O(max(N1, N2))
// Space Complexity: O(1) auxiliary space excluding output list
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int sum = a + b + carry;

            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;

            tail.next = newNode;
            tail = tail.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        return dummy.next;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {

    }
}
