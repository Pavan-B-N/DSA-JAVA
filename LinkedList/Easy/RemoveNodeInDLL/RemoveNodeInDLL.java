package LinkedList.Easy.RemoveNodeInDLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/removing-given-node-in-dll

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public void deleteGivenNode(ListNode node) {
        if (node == null)
            return;

        ListNode prev = node.prev;
        ListNode next = node.next;

        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
    }
}

public class RemoveNodeInDLL {
    public static void main(String[] args) {

    }
}
