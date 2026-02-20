package LinkedList.Hard.FlattenLL;
import java.util.PriorityQueue;

import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/flattening-of-ll?category=faqs--hard&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N * M) - Merge Sort approach
// Space Complexity: O(1) auxiliary space excluding recursion stack
class Solution {
    public ListNode flattenLinkedList(ListNode head) {
        if (head == null)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.val, node2.val));

        ListNode curr = head;

        // Note: we are breaking the next pointer here
        while (curr != null) {
            ListNode next = curr.next;
            minHeap.offer(curr);

            curr.next = null;

            curr = next;
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();

            tail.child = node;
            tail = tail.child;

            if (node.child != null) {
                minHeap.offer(node.child);
            }
        }

        return dummy.child;
    }
}

public class FlattenLL {
    public static void main(String[] args) {

    }
}
