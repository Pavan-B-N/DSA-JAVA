package SlidingWindow_TwoPointer.Medium.NumberOfSubstringContainingAll3Characters;
// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
// https://takeuforward.org/practice/dsa/number-of-substrings-containing-all-three-characters?category=counting-subarrays-and-substrings-problems&source=strivers-a2z-dsa-sheet

import java.util.Map;
import java.util.HashMap;

// Time Complexity: O(N)
// Space Complexity: O(1) for tracking last seen indices
class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();// {ch -> freq}

        int i = 0;
        int count = 0;
        int n = s.length();

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);

            while (hashMap.size() == 3) {
                count += (n - j);
                char chi = s.charAt(i++);

                hashMap.put(chi, hashMap.get(chi) - 1);
                if (hashMap.get(chi) == 0) {
                    hashMap.remove(chi);
                }
            }
        }

        return count;
    }
}

public class NumberOfSubstringContainingAll3Characters {
    public static void main(String[] args) {

    }
}
