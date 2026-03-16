package SlidingWindow_TwoPointer.Hard.LongestRepeatingCharacterReplacement;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-repeating-character-replacement/

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> hashMap = new HashMap<>();// {ch -> freq}

        int i = 0;
        int maxLen = 0;
        int maxFreq = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, hashMap.get(ch));

            while ((j - i + 1) - maxFreq > k) {
                char chi = s.charAt(i++);
                hashMap.put(chi, hashMap.get(chi) - 1);

                if (hashMap.get(chi) == 0) {
                    hashMap.remove(chi);
                }

                // update the maxFreq
                maxFreq = 0;
                for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
                    maxFreq = Math.max(maxFreq, entry.getValue());
                }
            }

            maxLen = Math.max(maxLen, j - i + 1);

        }

        return maxLen;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution_Remove_MaxFreqScan {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> hashMap = new HashMap<>();// {ch -> freq}

        int i = 0;
        int maxLen = 0;
        int maxFreq = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, hashMap.get(ch));

            while ((j - i + 1) - maxFreq > k) {
                char chi = s.charAt(i++);
                hashMap.put(chi, hashMap.get(chi) - 1);

                if (hashMap.get(chi) == 0) {
                    hashMap.remove(chi);
                }
                // We dont have to update the frequency because (WindowLength - lesserMaxFreq >
                // k) so until we get the maxFreq incremented it never contributes
            }

            maxLen = Math.max(maxLen, j - i + 1);

        }

        return maxLen;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution_Remove_While {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> hashMap = new HashMap<>();// {ch -> freq}

        int i = 0;
        int maxLen = 0;
        int maxFreq = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, hashMap.get(ch));

            if ((j - i + 1) - maxFreq > k) {
                char chi = s.charAt(i++);
                hashMap.put(chi, hashMap.get(chi) - 1);

                if (hashMap.get(chi) == 0) {
                    hashMap.remove(chi);
                }
                // We dont have to update the frequency because (WindowLength - lesserMaxFreq >
                // k) so until we get the maxFreq incremented it never contributes
            }

            maxLen = Math.max(maxLen, j - i + 1);

        }

        return maxLen;
    }
}

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

    }
}
