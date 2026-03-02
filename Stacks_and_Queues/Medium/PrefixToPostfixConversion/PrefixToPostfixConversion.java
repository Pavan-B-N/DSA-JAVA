package Stacks_and_Queues.Medium.PrefixToPostfixConversion;
// https://takeuforward.org/practice/dsa/prefix-to-postfix-conversion?category=expression-conversions&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(N)
// Space Complexity: O(N) for stack

class Solution {
    public String prefixToPostfix(String s) {
        Deque<String> st = new ArrayDeque<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char symbol = s.charAt(i);

            if (Character.isLetterOrDigit(symbol)) {
                st.push(String.valueOf(symbol));
            } else {
                String top1 = st.pop();
                String top2 = st.pop();

                String res = top1 + top2 + symbol;
                st.push(res);
            }
        }

        return st.peek();
    }
}

public class PrefixToPostfixConversion {
    public static void main(String[] args) {

    }
}
