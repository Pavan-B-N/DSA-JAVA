package Hashing.Medium.CountSubArraysWithGivenXOR;
import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/practice/dsa/count-subarrays-with-given-xor-k?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(N) for prefix XOR map
class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();// {prefixXor -> count}

        int prefixXor = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixXor ^= nums[i];

            if (prefixXor == k)
                count++;

            int remainderSum = prefixXor ^ k;

            if (hashMap.containsKey(remainderSum)) {
                count += hashMap.get(remainderSum);
            }

            hashMap.put(prefixXor, hashMap.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}

public class CountSubArraysWithGivenXOR {
    public static void main(String[] args) {

    }
}
