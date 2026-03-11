package SlidingWindow_TwoPointer.Medium.FruitsIntoBasket;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fruit-into-baskets/
// https://takeuforward.org/practice/dsa/fruit-into-baskets?category=longest-and-smallest-window-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1) hash map of size at most 3
class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> hashMap = new HashMap<>();// ele -> freq

        int i = 0;
        int maxFruits = 0;

        for (int j = 0; j < fruits.length; j++) {
            hashMap.put(fruits[j], hashMap.getOrDefault(fruits[j], 0) + 1);

            while (hashMap.size() > 2) {
                hashMap.put(fruits[i], hashMap.get(fruits[i]) - 1);

                if (hashMap.get(fruits[i]) == 0) {
                    hashMap.remove(fruits[i]);
                }
                i++;
            }

            maxFruits = Math.max(maxFruits, j - i + 1);
        }

        return maxFruits;

    }
}

public class FruitsIntoBasket {
    public static void main(String[] args) {

    }
}
