package Strings.Medium.MinimumNumberOfBracketsReversalToMakeExpressionBalanced;
// https://takeuforward.org/practice/dsa/minimum-number-of-bracket-reversals-to-make-an-expression-balanced?category=medium-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1) using counter or stack
class Solution {
    public int countRev(String s) {
        if (s.length() % 2 == 1) {
            return -1;
        }

        int open = 0;
        int close = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }

        return (open / 2) + (open % 2) + (close / 2) + (close % 2);
    }
}

public class MinimumNumberOfBracketsReversalToMakeExpressionBalanced {
    public static void main(String[] args) {

    }
}
