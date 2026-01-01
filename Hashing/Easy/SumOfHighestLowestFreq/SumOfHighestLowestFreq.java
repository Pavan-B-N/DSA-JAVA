package Hashing.Easy.SumOfHighestLowestFreq;
import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/practice/dsa/sum-of-highest-and-lowest-frequency?category=basic-hashing&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(N) for frequency map
class Solution {
    public int sumHighestAndLowestFrequency(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>(); // ele -> freq

        for (int ele : nums) {
            hashMap.put(ele, hashMap.getOrDefault(ele, 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int freq = entry.getValue();

            maxFreq = Math.max(maxFreq, freq);
            minFreq = Math.min(minFreq, freq);
        }

        return maxFreq + minFreq;
    }
}

public class SumOfHighestLowestFreq {
    public static void main(String[] args) {

    }
}
