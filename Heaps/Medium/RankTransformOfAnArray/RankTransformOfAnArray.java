package Heaps.Medium.RankTransformOfAnArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/rank-transform-of-an-array/
// https://takeuforward.org/practice/dsa/replace-elements-by-their-rank?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0

// Time: O(n log n)
// Space: O(n)
// Time Complexity: O(N log N)
// Space Complexity: O(N) for sorted copy and rank map
class Solution {
    public int[] arrayRankTransform(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        int rank = 1;
        Map<Integer, Integer> hashMap = new HashMap<>();// {ele -> rank}

        for (int i = 0; i < arr.length; i++) {
            if (!hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], rank++);
            }
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = hashMap.get(nums[i]);
        }

        return res;

    }
}

// Time Complexity: O(N log N)
// Space Complexity: O(N) for sorted copy and rank map
class Solution_List {
    public List<Integer> replaceWithRank(List<Integer> list) {
        // Your code goes here
        List<Integer> arr = new ArrayList<>(list);
        Collections.sort(arr);

        int rank = 1;
        Map<Integer, Integer> hashMap = new HashMap<>(); // {ele -> rank}

        for (int i = 0; i < arr.size(); i++) {
            if (!hashMap.containsKey(arr.get(i))) {
                hashMap.put(arr.get(i), rank++);
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            res.add(hashMap.get(list.get(i)));
        }

        return res;
    }
}

public class RankTransformOfAnArray {
    public static void main(String[] args) {

    }
}
