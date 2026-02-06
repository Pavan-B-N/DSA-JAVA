package LinkedList.Easy.DeleteNodeInList;
import LinkedList.ListNode;

// https://leetcode.com/problems/delete-node-in-a-linked-list/description/

// Time Complexity: O(1) given node pointer
// Space Complexity: O(1)
class Solution {
    // node -> node to be deleted, head is not given
    // All values of the LL is unique & its guaranteed that the given node is not the last node in LL
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

public class DeleteNodeInList {
    public static void main(String[] args) {
        
    }
}
