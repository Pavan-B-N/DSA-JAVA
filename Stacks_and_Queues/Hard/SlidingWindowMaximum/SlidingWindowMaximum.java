package Stacks_and_Queues.Hard.SlidingWindowMaximum;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.com/problems/sliding-window-maximum/description/
// https://takeuforward.org/practice/dsa/sliding-window-maximum?category=faqs&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N) - Monotonic Deque
// Space Complexity: O(K) for deque
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();// store indices

        List<Integer> list = new ArrayList<>();

        // first window
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        list.add(nums[deque.peekFirst()]);

        for (int i = k; i < nums.length; i++) {
            // remove not part of the window
            while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }

            // process
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // store max guy
            list.add(nums[deque.peekFirst()]);

        }

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}


public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }
}
