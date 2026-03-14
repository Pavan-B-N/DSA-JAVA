package SlidingWindow_TwoPointer.Medium.MaxPointsFromCard;
// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
// https://takeuforward.org/practice/dsa/maximum-points-you-can-obtain-from-cards-?category=constant-window&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(K)
// Space Complexity: O(1) sliding window
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxSum = 0;
        int currSum = 0;

        int n = cardPoints.length;

        for (int i = 0; i < k; i++) {
            currSum += cardPoints[i];
        }

        maxSum = currSum;

        for (int j = 0; j < k; j++) {
            currSum += cardPoints[n - 1 - j];
            currSum -= cardPoints[k - j - 1];
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;

    }
}

public class MaxPointsFromCard {
    public static void main(String[] args) {

    }
}
