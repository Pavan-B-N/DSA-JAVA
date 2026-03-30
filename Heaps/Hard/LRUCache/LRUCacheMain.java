package Heaps.Hard.LRUCache;
import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/practice/dsa/lru-cache?category=faqs&source=strivers-a2z-dsa-sheet&tab=problem&sidebar=0
// https://leetcode.com/problems/lru-cache/

// Time Complexity: O(1) for get and put
// Space Complexity: O(capacity) for Doubly Linked List and HashMap
class LRUCache {
    ListNode head, tail;

    Map<Integer, ListNode> hashMap;

    int capacity;

    private void removeNode(ListNode node) {
        if (node == null)
            return;

        ListNode prev = node.prev;
        ListNode next = node.next;

        if (prev != null) {
            prev.next = next;
        } else {
            head = head.next;
        }

        if (next != null) {
            next.prev = prev;
        } else {
            tail = tail.prev;
            if (tail != null)
                tail.next = null;
        }

        node.next = null;
        node.prev = null;
    }

    private void insertAtFront(ListNode node) {
        node.next = head;

        if (head != null) {
            head.prev = node;
        } else {
            tail = node;
        }

        head = node;
    }

    public LRUCache(int capacity) {
        this.head = null;
        this.tail = null;
        this.hashMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }

        ListNode node = hashMap.get(key);

        removeNode(node);
        insertAtFront(node);

        return node.value;

    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            ListNode node = hashMap.get(key);
            node.value = value;

            removeNode(node);
            insertAtFront(node);

            return;
        }

        if (hashMap.size() == capacity) {
            // evit least recently used
            hashMap.remove(tail.key);
            removeNode(tail);
        }

        ListNode newNode = new ListNode(key, value);
        insertAtFront(newNode);
        hashMap.put(key, newNode);
    }

}

class ListNode {
    int key, value;
    ListNode next, prev;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

// Time Complexity: O(1) for get and put
// Space Complexity: O(capacity) for Doubly Linked List and HashMap
public class LRUCacheMain {
    public static void main(String[] args) {

    }
}
