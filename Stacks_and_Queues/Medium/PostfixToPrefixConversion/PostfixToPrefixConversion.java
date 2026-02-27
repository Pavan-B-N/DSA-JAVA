package Stacks_and_Queues.Medium.PostfixToPrefixConversion;
// https://takeuforward.org/practice/dsa/postfix-to-prefix-conversion?category=expression-conversions&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(N)
// Space Complexity: O(N) for stack
class Solution {
    public String postToPre(String postfix) {
        Deque<String> st = new ArrayDeque<>();

        for (char ch : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String top1 = st.pop();
                String top2 = st.pop();

                String exp = ch + top2 + top1;
                st.push(exp);
            }
        }

        return st.peek();
    }
}

public class PostfixToPrefixConversion {
    public static void main(String[] args) {

    }
}
