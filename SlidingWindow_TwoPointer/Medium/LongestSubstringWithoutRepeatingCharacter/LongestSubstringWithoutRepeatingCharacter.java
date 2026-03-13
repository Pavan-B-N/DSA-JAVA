package SlidingWindow_TwoPointer.Medium.LongestSubstringWithoutRepeatingCharacter;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// https://takeuforward.org/practice/dsa/longest-substring-without-repeating-characters?category=longest-and-smallest-window-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(min(N, 256)) for character index map
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();

        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            while (hashSet.contains(ch)) {
                hashSet.remove(s.charAt(i));
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);

            hashSet.add(ch);
        }

        return maxLen;
    }
}

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {

    }
}
