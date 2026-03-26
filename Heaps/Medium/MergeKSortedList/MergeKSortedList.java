package Heaps.Medium.MergeKSortedList;
import java.util.PriorityQueue;

import LinkedList.ListNode;

// https://leetcode.com/problems/merge-k-sorted-lists/
// https://takeuforward.org/practice/dsa/merge-k-sorted-lists?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0&tab=solution&solution=min-heap

// Time Complexity: O(N log K) where N = total nodes, K = number of lists
// Space Complexity: O(K) for min-heap
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));

        for(ListNode node:lists){
            if(node!=null) minHeap.offer(node);
        }

        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();

            tail.next = node;
            tail = tail.next;

            if(node.next!=null) minHeap.add(node.next);
        }

        return dummy.next;
    }
}

public class MergeKSortedList {
    public static void main(String[] args) {
        
    }
}
