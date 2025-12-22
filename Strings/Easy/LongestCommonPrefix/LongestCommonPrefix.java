package Strings.Easy.LongestCommonPrefix;
// https://leetcode.com/problems/longest-common-prefix/
// https://takeuforward.org/practice/dsa/longest-common-prefix?category=basic-strings&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N * M) where N = words count, M = length
// Space Complexity: O(1)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];

        String shortestStr = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortestStr.length()) {
                shortestStr = strs[i];
            }
        }

        for (int i = 0; i < shortestStr.length(); i++) {
            for (String s : strs) {
                if (s.charAt(i) != shortestStr.charAt(i)) {
                    return shortestStr.substring(0, i);
                }
            }
        }

        return shortestStr;
    }
}

public class LongestCommonPrefix {
    public static void main(String[] args) {

    }
}
