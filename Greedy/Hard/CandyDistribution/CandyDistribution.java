package Greedy.Hard.CandyDistribution;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/candy?category=hard&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/candy/

// Time Complexity: O(N)
// Space Complexity: O(1) peak and valley greedy single-pass
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candyDistribution = new int[n];
        Arrays.fill(candyDistribution, 1);

        // kid rating > left neighbor so increase candies
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyDistribution[i] = candyDistribution[i - 1] + 1;
            }
        }

        // kid rating > right neighbor so increase candies
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyDistribution[i] = Math.max(candyDistribution[i], candyDistribution[i + 1] + 1);
            }
        }

        return Arrays.stream(candyDistribution).sum();
    }
}

public class CandyDistribution {
    public static void main(String[] args) {

    }
}
