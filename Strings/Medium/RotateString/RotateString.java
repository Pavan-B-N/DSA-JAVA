package Strings.Medium.RotateString;
// https://leetcode.com/problems/rotate-string/description/
// https://takeuforward.org/practice/dsa/rotate-string?category=basic-strings&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem

// Time Complexity: O(N)
// Space Complexity: O(N) for concatenated string
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String dblS = s + s;

        return dblS.contains(goal);
    }
}

public class RotateString {
    public static void main(String[] args) {

    }
}
