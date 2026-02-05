package LinkedList.Easy.DeleteHeadOfLL;
// https://takeuforward.org/practice/dsa/deletion-of-the-head-of-ll

import LinkedList.ListNode;

// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public ListNode deleteHead(ListNode head) {
        if (head == null)
            return null;
        return head.next;
    }
}

public class DeleteHeadOfLL {
    public static void main(String[] args) {

    }
}
