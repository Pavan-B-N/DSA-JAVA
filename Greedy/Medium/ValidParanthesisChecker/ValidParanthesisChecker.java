package Greedy.Medium.ValidParanthesisChecker;
import java.util.ArrayDeque;
import java.util.Deque;

// https://takeuforward.org/practice/dsa/valid-paranthesis-checker?category=hard&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1) tracking min and max open count
class Solution {
    public boolean isValid(String s) {
        Deque<Integer> startStack = new ArrayDeque<>(); // stores indices
        Deque<Integer> openStack = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openStack.push(i);
            } else if (ch == ')') {
                if (!openStack.isEmpty())
                    openStack.pop();
                else if (!startStack.isEmpty())
                    startStack.pop();
                else
                    return false;
            } else {
                startStack.push(i);
            }
        }

        while (!openStack.isEmpty()) {
            int index = openStack.pop();

            if (index > startStack.peek()) {
                return false;
            }

            startStack.pop();
        }

        return openStack.isEmpty();
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1) tracking min and max open count
class Solution_Optimal {
    public boolean isValid(String s) {
        int minOpens = 0;
        int maxOpens = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                minOpens++;
                maxOpens++;
            } else if (ch == ')') {
                minOpens--;
                maxOpens--;
            } else {
                minOpens--;
                maxOpens++;

            }
            if (minOpens < 0)
                minOpens = 0;
            if (maxOpens < 0)
                return false;
        }

        return minOpens == 0;
    }
}

public class ValidParanthesisChecker {
    public static void main(String[] args) {

    }
}
