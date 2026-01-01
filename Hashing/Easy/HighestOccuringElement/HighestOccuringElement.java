package Hashing.Easy.HighestOccuringElement;
import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/practice/dsa/highest-occurring-element-in-an-array?tab=problem
// tag: [revise]

// Time Complexity: O(N)
// Space Complexity: O(N) for frequency map
class Solution {
    public int mostFrequentElement(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>(); // {ele -> freq}

        int maxFreq = 0;
        int maxEle = -1;

        for (int ele : nums) {
            hashMap.put(ele, hashMap.getOrDefault(ele, 0) + 1);

            if (hashMap.get(ele) > maxFreq) {
                maxEle = ele;
                maxFreq = hashMap.get(ele);
            } else if (hashMap.get(ele) == maxFreq && ele < maxEle) {
                maxEle = ele;
            }
        }

        return maxEle;
    }
}

public class HighestOccuringElement {
    public static void main(String[] args) {

    }
}
