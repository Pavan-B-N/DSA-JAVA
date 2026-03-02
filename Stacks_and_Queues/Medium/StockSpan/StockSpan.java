package Stacks_and_Queues.Medium.StockSpan;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://takeuforward.org/practice/dsa/stock-span-problem?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0
// Time Complexity: Amortized O(1) per next call
// Space Complexity: O(N) for stack
class Solution {
    public int[] stockSpan(int[] arr, int n) {
        int[] res = new int[n];

        Deque<Integer> stack = new ArrayDeque<>(); // store indices

        // previous greater element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            int pge = stack.isEmpty() ? -1 : stack.peek();
            res[i] = i - pge;

            stack.push(i);
        }

        return res;
    }
}

// https://leetcode.com/problems/online-stock-span/description/
class StockSpanner {
    List<Integer> arr;
    Deque<Integer> stack;

    public StockSpanner() {
        arr = new ArrayList<>();
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        while (!stack.isEmpty() && arr.get(stack.peek()) <= price) {
            stack.pop();
        }

        arr.add(price);

        int currIndex = arr.size() - 1;

        int pge = stack.isEmpty() ? -1 : stack.peek();

        stack.push(currIndex);

        return (currIndex - pge);
    }
}

public class StockSpan {
    public static void main(String[] args) {

    }
}
