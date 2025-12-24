package Strings.Medium.IsomorphicStrings;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/isomorphic-strings/
// https://takeuforward.org/practice/dsa/isomorphic-string?category=basic-strings&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1) for character mapping arrays
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (hashMap.containsKey(ch1)) {
                if (hashMap.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if (hashMap.containsValue(ch2)) {
                    return false;
                }

                hashMap.put(ch1, ch2);
            }

        }

        return true;
    }
}

public class IsomorphicStrings {
    public static void main(String[] args) {

    }
}
