package Hashing.Medium.LongestConsecutiveSequence;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
// https://takeuforward.org/practice/dsa/longest-consecutive-sequence-in-an-array?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(N) for HashSet
class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> hashSet = new HashSet<>();

        for (int ele : nums) {
            hashSet.add(ele);
        }

        int maxLen = 0;

        for (Integer ele : hashSet) {
            if (!hashSet.contains(ele - 1)) {
                int count = 1;
                int next = ele + 1;

                while (hashSet.contains(next)) {
                    count++;
                    next++;
                }

                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }
}
