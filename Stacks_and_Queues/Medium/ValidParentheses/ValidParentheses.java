package Stacks_and_Queues.Medium.ValidParentheses;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/valid-parentheses/
// https://takeuforward.org/practice/dsa/balanced-paranthesis?category=implementation&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(N) for stack in worst case
class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (char symbol : s.toCharArray()) {
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                st.push(symbol);
            } else if (!st.isEmpty() &&
                    ((st.peek() == '(' && symbol == ')') ||
                            (st.peek() == '[' && symbol == ']') ||
                            (st.peek() == '{' && symbol == '}'))) {
                st.pop();
            } else {
                return false;
            }
        }

        return st.isEmpty();
    }
}

public class ValidParentheses {
    public static void main(String[] args) {

    }
}
