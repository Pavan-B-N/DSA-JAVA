package Strings.Easy.ValidAnagrams;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/valid-anagram/
// https://takeuforward.org/practice/dsa/valid-anagram?category=basic-strings&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1) for frequency array of size 26
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> hashMap = new HashMap<>();//{ele -> freq}

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            if (!hashMap.containsKey(ch) || hashMap.get(ch) == 0) {
                return false;
            }

            hashMap.put(ch, hashMap.get(ch) - 1);
        }

        return true;

    }
}

public class ValidAnagrams {
    public static void main(String[] args) {
        
    }
}
