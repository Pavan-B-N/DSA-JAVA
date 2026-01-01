package Hashing.Easy.SecondHightestOccuringElement;
// https://takeuforward.org/practice/dsa/second-highest-occurring-element

import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(N)
// Space Complexity: O(N) for frequency map
class Solution {
    public int secondMostFrequentElement(int[] nums) {
        int n = nums.length;

        int maxFreq = 0, secMaxFreq = 0;

        int maxEle = -1, secEle = -1;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> it : hashMap.entrySet()) {
            int ele = it.getKey();
            int freq = it.getValue();

            if (freq > maxFreq) {
                secMaxFreq = maxFreq;
                maxFreq = freq;

                secEle = maxEle;
                maxEle = ele;
            } else if (freq == maxFreq) {
                maxEle = Math.min(maxEle, ele);
            } else if (freq > secMaxFreq) {
                secMaxFreq = freq;
                secEle = ele;
            } else if (freq == secMaxFreq) {
                secEle = Math.min(secEle, ele);
            }
        }

        return secEle;
    }
}

public class SecondHightestOccuringElement {
    public static void main(String[] args) {

    }
}
