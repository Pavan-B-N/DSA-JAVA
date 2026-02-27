package Stacks_and_Queues.Medium.PostfixToInfixConversion;
// https://takeuforward.org/practice/dsa/postfix-to-infix-conversion?category=expression-conversions&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(N)
// Space Complexity: O(N) for stack
class Solution {
    public String postToInfix(String s) {
        Deque<String> stack = new ArrayDeque<>(); // stores expression

        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);

            if (Character.isLetterOrDigit(symbol)) {
                stack.push(String.valueOf(symbol));
                // stack.push(Character.toString(symbol));
            } else {
                String top1 = stack.pop();
                String top2 = stack.pop();

                String expression = "(" + top2 + symbol + top1 + ")";

                stack.push(expression);
            }
        }

        return stack.peek();
    }
}

public class PostfixToInfixConversion {
    public static void main(String[] args) {

    }
}
