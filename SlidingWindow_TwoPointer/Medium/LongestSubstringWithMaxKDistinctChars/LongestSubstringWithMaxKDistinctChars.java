package SlidingWindow_TwoPointer.Medium.LongestSubstringWithMaxKDistinctChars;
import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/practice/dsa/longest-substring-with-at-most-k-distinct-characters?category=longest-and-smallest-window-problems&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(K) for frequency map
class Solution {
    public int kDistinctChar(String s, int k) {
        Map<Character, Integer> hashMap = new HashMap<>(); // ele -> freq

        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);

            while (hashMap.size() > k) {
                char chi = s.charAt(i);
                hashMap.put(chi, hashMap.get(chi) - 1);

                if (hashMap.get(chi) == 0) {
                    hashMap.remove(chi);
                }
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(K) for frequency map
class Solution_Optimal {
    public int kDistinctChar(String s, int k) {
        Map<Character, Integer> hashMap = new HashMap<>(); // ele -> freq

        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);

            if (hashMap.size() > k) {
                char chi = s.charAt(i);
                hashMap.put(chi, hashMap.get(chi) - 1);

                if (hashMap.get(chi) == 0) {
                    hashMap.remove(chi);
                }
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}

public class LongestSubstringWithMaxKDistinctChars {
    public static void main(String[] args) {

    }
}
