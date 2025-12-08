package Arrays.Medium.MajorityElement2;
// https://leetcode.com/problems/majority-element-ii/
// https://takeuforward.org/practice/dsa/majority-element-ii?category=faqs-hard&source=strivers-a2z-dsa-sheet

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();// ele -> freq

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int ele = entry.getKey();
            int freq = entry.getValue();

            if (freq > n / 3) {
                list.add(ele);
            }
        }

        return list;
    }
}

// Modified Version of Moores
// Time Complexity: O(N) - Extended Boyer-Moore Voting
// Space Complexity: O(1)
class Solution_Optimal {
    public List<Integer> majorityElement(int[] nums) {
        int a1 = Integer.MIN_VALUE;
        int c1 = 0;

        int a2 = Integer.MIN_VALUE;
        int c2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (c1 == 0 && a2 != nums[i]) {
                a1 = nums[i];
                c1 = 1;
            } else if (c2 == 0 && a1 != nums[i]) {
                a2 = nums[i];
                c2 = 1;
            } else if (nums[i] == a1) {
                c1++;
            } else if (nums[i] == a2) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a1)
                c1++;
            if (nums[i] == a2)
                c2++;
        }

        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        if (c1 > n / 3)
            list.add(a1);
        if (c2 > n / 3)
            list.add(a2);

        return list;

    }
}

public class MajorityElement2 {
    public static void main(String[] args) {

    }
}
