package Stacks_and_Queues.Medium.InfixToPostfixConversion;
// https://takeuforward.org/practice/dsa/infix-to-postfix-conversion?category=expression-conversions&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(N)
// Space Complexity: O(N) for stack
class Solution {
    public String infixToPostfix(String s) {
        StringBuilder postfix = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }

                stack.pop();
            } else {
                // operator

                while (!stack.isEmpty() && prec(stack.peek()) >= prec(ch) && !isRightAssociative(ch)) {
                    postfix.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
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

    private boolean isRightAssociative(char op) {
        return op == '^';
    }
}

public class InfixToPostfixConversion {
    public static void main(String[] args) {

    }
}
