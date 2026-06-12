package DynamicProgramming.KnapSack.Hard.WordBreak;
// https://leetcode.com/problems/word-break/
// https://takeuforward.org/practice/dsa/word-break?category=dp-on-strings&source=strivers-a2z-dsa-sheet&sidebar=0&tab=submissions

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Time Complexity: O(2^N) exponential
// Space Complexity: O(N) recursion stack space
class Solution_Recursive {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        return wordBreak(0, s, wordSet);
    }

    private boolean wordBreak(int index, String s, Set<String> wordSet) {
        if (index == s.length()) {
            return true;
        }

        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);

            if (wordSet.contains(subStr)) {
                if (wordBreak(i + 1, s, wordSet))
                    return true;
            }
        }

        return false;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);

        Boolean[] dp = new Boolean[n];

        return wordBreak(0, s, wordSet, dp);
    }

    private boolean wordBreak(int index, String s, Set<String> wordSet, Boolean[] dp) {
        if (index == s.length()) {
            return true;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);

            if (wordSet.contains(subStr)) {
                if (wordBreak(i + 1, s, wordSet, dp))
                    return dp[index] = true;
            }
        }

        return dp[index] = false;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];

        dp[n] = true;

        for (int index = n - 1; index >= 0; index--) {
            for (int i = index; i < s.length(); i++) {
                String subStr = s.substring(index, i + 1);

                if (wordSet.contains(subStr)) {
                    if (dp[i + 1])
                        dp[index] = true;
                }
            }
        }

        return dp[0];
    }

}

public class WordBreak {
    public static void main(String[] args) {

    }
}
