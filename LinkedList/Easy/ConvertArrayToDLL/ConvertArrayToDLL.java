package LinkedList.Easy.ConvertArrayToDLL;
import java.util.List;

import LinkedList.ListNode;

// https://takeuforward.org/practice/dsa/convert-array-to-dll

// Time Complexity: O(N)
// Space Complexity: O(1) auxiliary space excluding DLL nodes
class Solution {
  public ListNode arrayToDoublyLinkedList(List<Integer> arr) {
    if(arr.size() == 0) return null;

    ListNode dummy = new ListNode();
    ListNode tail = dummy;

    for (int ele : arr) {
      ListNode newNode = new ListNode(ele);
      tail.next = newNode;
      newNode.prev = tail;

      tail = tail.next;
    }

    ListNode head = dummy.next;
    head.prev = null;

    return head;
  }
}


public class ConvertArrayToDLL {
    public static void main(String[] args) {
        
    }
}
