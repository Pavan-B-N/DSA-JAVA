package LinkedList.Hard.CloneLLWithRandomPointer;
import java.util.HashMap;
import java.util.Map;

import LinkedList.ListNode;

// https://leetcode.com/problems/copy-list-with-random-pointer/description/
// https://takeuforward.org/practice/dsa/clone-a-ll-with-random-and-next-pointer?category=faqs--hard&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution_Brute {
    public ListNode copyRandomList(ListNode head) {
        if (head == null)
            return null;

        Map<ListNode, ListNode> hashMap = new HashMap<>();

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        ListNode curr = head;

        // Performs the shallow copy
        while (curr != null) {
            ListNode newNode = new ListNode(curr.val);
            tail.next = newNode;
            tail = tail.next;
            hashMap.put(curr, newNode);

            curr = curr.next;
        }

        // copy the randrom pointer
        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                ListNode copyNode = hashMap.get(curr);

                copyNode.random = hashMap.get(curr.random);
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public ListNode copyRandomList(ListNode head) {
        if (head == null)
            return null;

        // copy next pointer
        ListNode curr = head;

        while (curr != null) {
            ListNode newNode = new ListNode(curr.val);

            ListNode next = curr.next;

            newNode.next = next; // curr.next
            curr.next = newNode;

            curr = next; // newNode.next
        }

        // copy randrom pointer
        curr = head;

        while (curr != null) {
            ListNode copyNode = curr.next;

            if (curr.random != null) {
                copyNode.random = curr.random.next;
            }

            curr = copyNode.next;
        }

        // detach the list
        ListNode newHead = head.next;

        curr = head;

        while (curr != null) {
            ListNode copyNode = curr.next;

            curr.next = copyNode.next;

            curr = curr.next;

            if (curr != null) {
                copyNode.next = curr.next;
            }
        }

        return newHead;
    }
}

public class CloneLLWithRandomPointer {
    public static void main(String[] args) {

    }
}
