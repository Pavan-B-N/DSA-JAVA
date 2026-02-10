package LinkedList.Easy.InsertAtTheHeadOfLL;
// https://takeuforward.org/practice/dsa/insertion-at-the-head-of-ll
import LinkedList.ListNode;

// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public ListNode insertAtHead(ListNode head, int X) {
        ListNode newNode = new ListNode(X);
        newNode.next = head;

        return newNode;
    }
}


public class InsertAtTheHeadOfLL {
    public static void main(String[] args) {
        
    }
}
