package LinkedList.Easy.TraversalOfLL;
// https://takeuforward.org/practice/dsa/traversal-in-linked-list

import java.util.ArrayList;
import java.util.List;
import LinkedList.ListNode;

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public List<Integer> LLTraversal(ListNode head) {
        List<Integer> res = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            res.add(curr.data);
            curr = curr.next;
        }

        return res;
    }
}

public class TraversalOfLL {
    public static void main(String[] args) {

    }
}
