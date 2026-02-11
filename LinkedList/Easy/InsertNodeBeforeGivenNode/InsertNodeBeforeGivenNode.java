package LinkedList.Easy.InsertNodeBeforeGivenNode;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/insert-before-given-node-in-dll

// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public void insertBeforeGivenNode(ListNode node, int X) {
        ListNode prev = node.prev;

        ListNode newNode = new ListNode(X);

        // It is guranteed that node is not head so we can skip the condition as well
        if (prev != null) {
            prev.next = newNode;
            newNode.prev = prev;
        }

        newNode.next = node;
        node.prev = newNode;
    }
}

public class InsertNodeBeforeGivenNode {
    public static void main(String[] args) {

    }
}
