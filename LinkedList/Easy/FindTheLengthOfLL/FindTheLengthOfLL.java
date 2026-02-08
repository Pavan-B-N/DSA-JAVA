package LinkedList.Easy.FindTheLengthOfLL;
// https://takeuforward.org/plus/dsa/problems/find-the-length-of-the-linked-list?source=strivers-a2z-dsa-track
import LinkedList.ListNode;

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int getLength(ListNode head) {
        ListNode curr = head;
        int len = 0;

        while(curr!=null){
            curr = curr.next;
            len++;
        }

        return len;
    }
}



public class FindTheLengthOfLL {
    public static void main(String[] args) {
        
    }   
}
