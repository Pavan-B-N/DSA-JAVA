package SlidingWindow_TwoPointer.Hard.MinimumWindowSubString;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/
// https://takeuforward.org/practice/dsa/minimum-window-substring-?category=longest-and-smallest-window-problems&source=strivers-a2z-dsa-sheet&sidebar=0&tab=problem

// Time Complexity: O(N + M)
// Space Complexity: O(1) frequency array of size 128
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> hashMap = new HashMap<>();// {ch -> freq}

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            hashMap.put(ch, hashMap.getOrDefault(ch, 0) - 1);

            if (hashMap.get(ch) >= 0) {
                count++;
            }

            while (count == t.length()) {
                if ((j - i + 1) < minLen) {
                    startIndex = i;
                    minLen = (j - i + 1);
                }

                char chi = s.charAt(i++);
                hashMap.put(chi, hashMap.get(chi) + 1);

                if (hashMap.get(chi) > 0) {
                    count--;
                }
            }

        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}

public class MinimumWindowSubString {
    public static void main(String[] args) {

    }
}
