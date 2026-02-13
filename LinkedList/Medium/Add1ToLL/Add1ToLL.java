package LinkedList.Medium.Add1ToLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/add-one-to-a-number-represented-by-ll?category=faqs--medium&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1) iterative or O(N) recursion stack
class Solution {
    public ListNode addOne(ListNode head) {
        int carry = helper(head);

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    public int helper(ListNode node) {
        if (node == null)
            return 1;

        int carry = helper(node.next);

        int sum = node.val + carry;
        node.val = sum % 10;

        return sum / 10;
    }
}

public class Add1ToLL {
    public static void main(String[] args) {

    }
}
