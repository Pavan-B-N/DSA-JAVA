package Heaps.Hard.HandOfStraights;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/hand-of-straights/
// https://takeuforward.org/practice/dsa/hand-of-straights?category=faqs&source=strivers-a2z-dsa-sheet&sidebar=0&tab=solution&solution=optimal

// Time Complexity: O(N log N)
// Space Complexity: O(N) for TreeMap / frequency map
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();// ele -> freq

        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> entry = map.firstEntry();
            int card = entry.getKey();

            for (int i = 0; i < groupSize; i++) {
                if (!map.containsKey(card))
                    return false;

                // Consume 1 card to arrange
                map.put(card, map.get(card) - 1);

                if (map.get(card) == 0)
                    map.remove(card);

                card++;
            }
        }

        return true;
    }
}

public class HandOfStraights {
    public static void main(String[] args) {

    }
}
