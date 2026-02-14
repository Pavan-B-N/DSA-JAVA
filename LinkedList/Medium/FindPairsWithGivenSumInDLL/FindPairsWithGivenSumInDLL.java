package LinkedList.Medium.FindPairsWithGivenSumInDLL;
import java.util.ArrayList;
import java.util.List;

import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/find-pairs-with-given-sum-in-doubly-linked-list?category=faqs--dll&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1) using two pointers
class Solution {
    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        ListNode left = head;
        ListNode right = getTail(head);

        List<List<Integer>> res = new ArrayList<>();

        while (left != right && left.val <= right.val) {
            int sum = left.val + right.val;

            if (sum == target) {
                res.add(new ArrayList<>(List.of(left.val, right.val)));
                left = left.next;
                right = right.prev;
            } else if (sum > target) {
                right = right.prev;
            } else {
                left = left.next;
            }
        }

        return res;
    }

    private ListNode getTail(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            curr = curr.next;
        }

        return curr;
    }
}

public class FindPairsWithGivenSumInDLL {
    public static void main(String[] args) {

    }
}
