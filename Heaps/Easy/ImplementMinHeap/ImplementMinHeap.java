package Heaps.Easy.ImplementMinHeap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://takeuforward.org/practice/dsa/implement-min-heap?category=theory-and-implementation&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(log N) insert/delete, O(1) peek
// Space Complexity: O(N) for heap array
class Solution {

    List<Integer> list;

    private void heapifyUp(int index) {
        if (index == 0)
            return;

        int parentIndex = (index - 1) / 2;

        if (parentIndex >= 0 && list.get(index) < list.get(parentIndex)) {
            Collections.swap(list, index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        if (index >= list.size())
            return;

        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < list.size() && list.get(leftChild) < list.get(smallest)) {
            smallest = leftChild;
        }

        if (rightChild < list.size() && list.get(rightChild) < list.get(smallest)) {
            smallest = rightChild;
        }

        if (smallest != index) {
            Collections.swap(list, index, smallest);
            heapifyDown(smallest);
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
            heapifyUp(index);
        } else {
            list.set(index, newVal);
            heapifyDown(index);
        }
    }

    public void extractMin() {
        Collections.swap(list, 0, list.size() - 1);
        list.remove(list.size() - 1); // remove takes an index for list

        heapifyDown(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getMin() {
        return list.get(0);
    }

    public int heapSize() {
        return list.size();
    }
}

public class ImplementMinHeap {
    public static void main(String[] args) {

    }
}
