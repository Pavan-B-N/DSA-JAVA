package Greedy.Easy.AssignCookies;
import java.util.Arrays;

// https://leetcode.com/problems/assign-cookies/
// https://takeuforward.org/practice/dsa/assign-cookies?category=easy&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N log N + M log M)
// Space Complexity: O(1) sorting in-place
class Solution {
    // g-> greedy factor of a child
    // s-> size of the cookie
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i])
                i++;

            j++;
        }

        return i;
    }
}

public class AssignCookies {
    public static void main(String[] args) {

    }
}
