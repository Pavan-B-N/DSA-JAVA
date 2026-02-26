package Stacks_and_Queues.Medium.InfixToPrefixConversion;
// https://takeuforward.org/practice/dsa/infix-to-prefix-conversion?category=expression-conversions&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(N)
// Space Complexity: O(N) for stack

class Solution {
    public String infixToPrefix(String s) {
        StringBuilder prefix = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                prefix.append(ch);
            } else if (ch == ')') {
                stack.push(ch);
            } else if (ch == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.append(stack.pop());
                }

                stack.pop();
            } else {
                // operator
                while (!stack.isEmpty() && prec(stack.peek()) > prec(ch)) {
                    prefix.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }

        return prefix.reverse().toString();
    }

    private int prec(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else if (op == '^') {
            return 3;
        } else {
            return 0;
        }
    }
}

public class InfixToPrefixConversion {
    public static void main(String[] args) {

    }
}
