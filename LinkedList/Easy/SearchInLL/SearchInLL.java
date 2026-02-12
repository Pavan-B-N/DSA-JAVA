package LinkedList.Easy.SearchInLL;
import LinkedList.ListNode;

// https://takeuforward.org/plus/dsa/problems/search-in-linked-list?source=strivers-a2z-dsa-track

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public boolean searchKey(ListNode head, int key) {
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == key) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}

public class SearchInLL {
    public static void main(String[] args) {

    }
}
