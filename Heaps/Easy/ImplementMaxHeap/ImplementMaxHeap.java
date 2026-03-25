package Heaps.Easy.ImplementMaxHeap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://takeuforward.org/practice/dsa/implement-max-heap?category=theory-and-implementation&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(log N) insert/delete, O(1) peek
// Space Complexity: O(N) for heap array
class Solution {
    List<Integer> list;

    private void heapifyUp(int index) {
        if (index == 0)
            return;

        int parentIndex = (index - 1) / 2;

        if (parentIndex >= 0 && list.get(index) > list.get(parentIndex)) {
            Collections.swap(list, index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        if (index >= list.size())
            return;

        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < list.size() && list.get(leftChild) > list.get(largest)) {
            largest = leftChild;
        }

        if (rightChild < list.size() && list.get(rightChild) > list.get(largest)) {
            largest = rightChild;
        }

        if (largest != index) {
            Collections.swap(list, index, largest);
            heapifyDown(largest);
        }
    }

    public void initializeHeap() {
        list = new ArrayList<>();
    }

    public void insert(int key) {
        list.add(key);
        heapifyUp(list.size() - 1);
    }

    public void changeKey(int index, int newVal) {
        if (newVal < list.get(index)) {
            list.set(index, newVal);
            heapifyDown(index);
        } else {
            list.set(index, newVal);
            heapifyUp(index);
        }
    }

    public void extractMax() {
        Collections.swap(list, 0, list.size() - 1);
        list.remove(list.size() - 1); // removing by index
        heapifyDown(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getMax() {
        return list.get(0);
    }

    public int heapSize() {
        return list.size();
    }
}

public class ImplementMaxHeap {
    public static void main(String[] args) {

    }
}
