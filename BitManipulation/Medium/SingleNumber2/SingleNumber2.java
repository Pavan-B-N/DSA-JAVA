package BitManipulation.Medium.SingleNumber2;
import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/practice/dsa/single-number---ii?category=problems&source=strivers-a2z-dsa-sheet&tab=problem&sidebar=0&solution=brute
// https://leetcode.com/problems/single-number-ii/


// Every number appears 3 times except 1 number
// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution_HashMap {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int ele = entry.getKey();
            int freq = entry.getValue();

            if (freq == 1)
                return ele;
        }

        return -1;
    }
}

// Time Complexity: O(32 * n)
class Solution_BitManipulation_Optimal {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & (1 << bitIndex)) != 0) {
                    count++;
                }
            }

            if (count % 3 == 1) {
                ans = ans | (1 << bitIndex);
            }
        }

        return ans;
    }
}

public class SingleNumber2 {
    public static void main(String[] args) {

    }
}
