package Strings.Medium.SumOfBeautyOfStrings;
// https://takeuforward.org/practice/dsa/sum-of-beauty-of-all-substrings?category=substring-problems&source=strivers-a2z-dsa-sheet&tab=problem
// https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

// Time Complexity: O(N^2 * 26)
// Space Complexity: O(26) = O(1) frequency array
class Solution {
    public int beautySum(String s) {
        int totalBeauty = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];

            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0, minFreq = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }

                totalBeauty += maxFreq - minFreq;
            }
        }

        return totalBeauty;
    }
}

public class SumOfBeautyOfStrings {
    public static void main(String[] args) {

    }
}
