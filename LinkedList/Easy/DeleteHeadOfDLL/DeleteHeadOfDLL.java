package LinkedList.Easy.DeleteHeadOfDLL;
import LinkedList.ListNode;

// https://takeuforward.org/plus/dsa/problems/delete-head-of-dll?source=strivers-a2z-dsa-track


// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public ListNode deleteHead(ListNode head) {
        if(head==null || head.next == null) return null;

        head = head.next;
        head.prev = null;

        return head;

    }
}


public class DeleteHeadOfDLL {
    public static void main(String[] args) {
        
    }
}
