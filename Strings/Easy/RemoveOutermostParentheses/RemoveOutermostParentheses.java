package Strings.Easy.RemoveOutermostParentheses;
// https://takeuforward.org/plus/dsa/problems/remove-outermost-parentheses?source=strivers-a2z-dsa-track
// https://leetcode.com/problems/remove-outermost-parentheses/description/

// Time Complexity: O(N)
// Space Complexity: O(N) for result string
class Solution {
    public String removeOuterParentheses(String s) {
        int openBraces = 0;

        StringBuilder res = new StringBuilder();
        StringBuilder curr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            curr.append(s.charAt(i));

            if (s.charAt(i) == '(') {
                openBraces++;
            } else {
                openBraces--;
            }

            // We got one of the premitive decomposition
            if (openBraces == 0) {
                res.append(curr.substring(1, curr.length() - 1));
                curr.setLength(0);
            }
        }

        return res.toString();
    }
}

public class RemoveOutermostParentheses {
    public static void main(String[] args) {

    }
}
