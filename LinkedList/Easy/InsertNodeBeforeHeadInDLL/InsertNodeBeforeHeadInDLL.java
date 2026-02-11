package LinkedList.Easy.InsertNodeBeforeHeadInDLL;
// https://takeuforward.org/practice/dsa/insert-node-before-head-in-dll
import LinkedList.ListNode;

// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public ListNode insertBeforeHead(ListNode head, int X) {
        ListNode newNode = new ListNode(X);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        return newNode;
    }
}

public class InsertNodeBeforeHeadInDLL {
    public static void main(String[] args) {

    }
}
