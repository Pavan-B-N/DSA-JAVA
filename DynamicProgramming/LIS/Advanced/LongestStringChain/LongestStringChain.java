package DynamicProgramming.LIS.Advanced.LongestStringChain;
import java.util.Arrays;
import java.util.Comparator;

// https://takeuforward.org/practice/dsa/longest-string-chain?category=lis-dp&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/longest-string-chain/

// Time Complexity: O(N log N + N * L^2) where L = word length
// Space Complexity: O(N) for dp map
class Solution {
    public int longestStringChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (checkPossible(words[i], words[j]) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

            if (dp[i] > maxLen)
                maxLen = dp[i];
        }

        return maxLen;
    }

    private boolean checkPossible(String s, String t) {
        if (s.length() != t.length() + 1)
            return false;

        int i = 0, j = 0;

        while (i < s.length()) {
            if (j < t.length() && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return (i == s.length() && j == t.length());
    }
}

public class LongestStringChain {
    public static void main(String[] args) {

    }
}
