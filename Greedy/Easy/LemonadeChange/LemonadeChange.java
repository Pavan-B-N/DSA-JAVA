package Greedy.Easy.LemonadeChange;
// https://takeuforward.org/practice/dsa/lemonade-change?category=easy&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/lemonade-change/

// Time Complexity: O(N)
// Space Complexity: O(1) tracking 5 and 10 dollar bills
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;

                if (five == 0)
                    return false;
                five--;

            } else {
                // 20$
                if ((ten >= 1 && five >= 1)) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

public class LemonadeChange {
    public static void main(String[] args) {

    }
}
