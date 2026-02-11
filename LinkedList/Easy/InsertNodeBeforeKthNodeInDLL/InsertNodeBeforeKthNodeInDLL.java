package LinkedList.Easy.InsertNodeBeforeKthNodeInDLL;
import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/insert-node-before-kth-node-in-dll

// Time Complexity: O(K)
// Space Complexity: O(1)
class Solution {
    public ListNode insertBeforeKthPosition(ListNode head, int X, int K) {
        if (head == null)
            return new ListNode(X);

        ListNode curr = head;
        int count = 1;

        while (curr != null) {
            if (count == K) {
                ListNode prev = curr.prev;
                ListNode newNode = new ListNode(X);

                if (count == 1)
                    head = newNode;

                if (prev != null) {
                    prev.next = newNode;
                    newNode.prev = prev;
                }
                newNode.next = curr;
                curr.prev = newNode;
            }

            curr = curr.next;
            count++;
        }

        return head;
    }
}

public class InsertNodeBeforeKthNodeInDLL {
    public static void main(String[] args) {

    }
}
