package Recursion_and_Backtracking.Easy.ReverseStack;
import java.util.Stack;

// https://takeuforward.org/practice/dsa/reverse-a-stack?category=implementation-problems&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N^2)
// Space Complexity: O(N) recursion stack
class Solution {
    public void reverseStack(Stack<Integer> st) {
        if (st.isEmpty())
            return;

        int ele = st.peek();
        st.pop();

        reverseStack(st);

        insertAtBottom(ele, st);
    }

    private void insertAtBottom(int ele, Stack<Integer> st) {
        if (st.isEmpty()) {
            st.push(ele);
            return;
        }

        int value = st.peek();
        st.pop();

        insertAtBottom(ele, st);

        st.push(value);
    }
}

public class ReverseStack {
    public static void main(String[] args) {

    }
}
