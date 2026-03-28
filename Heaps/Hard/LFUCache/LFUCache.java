package Heaps.Hard.LFUCache;
// https://takeuforward.org/practice/dsa/lfu-cache?category=faqs&source=strivers-a2z-dsa-sheet

import java.util.*;

class Node {
    int key, value, cnt;
    Node next, prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.cnt = 1;
    }
}

// Time Complexity: O(1) for get and put
// Space Complexity: O(capacity) for HashMaps and Doubly Linked Lists
class List {
    int size;
    Node head, tail;

    List() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void addFront(Node node) {
        Node temp = head.next;
        node.next = temp;
        node.prev = head;
        head.next = node;
        temp.prev = node;
        size++;
    }

    void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
}

// Time Complexity: O(1) for get and put
// Space Complexity: O(capacity) for HashMaps and Doubly Linked Lists
class LFUCache_Solution {
    private Map<Integer, Node> keyNode;
    private Map<Integer, List> freqListMap;
    private int maxSizeCache;
    private int minFreq;
    private int curSize;

    public LFUCache_Solution(int capacity) {
        maxSizeCache = capacity;
        minFreq = 0;
        curSize = 0;
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    private void updateFreqListMap(Node node) {
        keyNode.remove(node.key);

        List currentList = freqListMap.get(node.cnt);
        currentList.removeNode(node);

        if (node.cnt == minFreq && currentList.size == 0) {
            minFreq++;
        }

        List nextHigherFreqList = freqListMap.getOrDefault(
                node.cnt + 1, new List());

        node.cnt++;
        nextHigherFreqList.addFront(node);

        freqListMap.put(node.cnt, nextHigherFreqList);
        keyNode.put(node.key, node);
    }

    public int get(int key) {
        if (!keyNode.containsKey(key)) {
            return -1;
        }

        Node node = keyNode.get(key);
        int value = node.value;

        updateFreqListMap(node);

        return value;
    }

    public void put(int key, int value) {
        if (maxSizeCache == 0) {
            return;
        }

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreqListMap(node);
        } else {
            if (curSize == maxSizeCache) {
                List list = freqListMap.get(minFreq);
                Node lruNode = list.tail.prev;

                keyNode.remove(lruNode.key);
                list.removeNode(lruNode);
                curSize--;
            }

            curSize++;
            minFreq = 1;

            List listFreq = freqListMap.getOrDefault(minFreq, new List());
            Node node = new Node(key, value);

            listFreq.addFront(node);
            keyNode.put(key, node);
            freqListMap.put(minFreq, listFreq);
        }
    }
}

// Time Complexity: O(1) for get and put
// Space Complexity: O(capacity) for HashMaps and Doubly Linked Lists
public class LFUCache {
    public static void main(String[] args) {

    }
}
