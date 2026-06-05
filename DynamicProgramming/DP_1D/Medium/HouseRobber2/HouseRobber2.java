package DynamicProgramming.DP_1D.Medium.HouseRobber2;
import java.util.Arrays;

// https://takeuforward.org/practice/dsa/house-robber?category=1d-dp&source=strivers-a2z-dsa-sheet&tab=problem&solution=memoization
// https://leetcode.com/problems/house-robber-ii/

// Time Complexity: O(N)
// Space Complexity: O(1) space optimized
class Solution {
    public int houseRobber(int[] money) {
        int n = money.length;

        int excludeFirst = houseRobber(n - 1, 1, money);
        int excludeLast = houseRobber(n - 2, 0, money);

        return Math.max(excludeFirst, excludeLast);
    }

    private int houseRobber(int index, final int startIndex, int[] money) {
        if (index == startIndex) {
            return money[startIndex];
        }

        int notPick = houseRobber(index - 1, startIndex, money);

        int pick = money[index];

        if (index - 2 >= startIndex) {
            pick += houseRobber(index - 2, startIndex, money);
        }

        return Math.max(notPick, pick);
    }
}

// Doesnt work in TUF due to stack overflow
// Time Complexity: O(N)
// Space Complexity: O(N) for dp table + recursion stack space
class Solution_Memoization {
    public int houseRobber(int[] money) {
        int n = money.length;

        if (n == 1) {
            return money[0];
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int excludeFirst = houseRobber(n - 1, 1, money, dp1);
        int excludeLast = houseRobber(n - 2, 0, money, dp2);

        return Math.max(excludeFirst, excludeLast);
    }

    private int houseRobber(int index, final int startIndex, int[] money, int[] dp) {

        if (index == startIndex) {
            return money[startIndex];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int notPick = houseRobber(index - 1, startIndex, money, dp);

        int pick = money[index];

        if (index - 2 >= startIndex) {
            pick += houseRobber(index - 2, startIndex, money, dp);
        }

        return dp[index] = Math.max(notPick, pick);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) for dp table
class Solution_Tabulation {
    public int houseRobber(int[] money) {
        int n = money.length;

        if (n == 1) {
            return money[0];
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        int excludeFirst = houseRobber(n - 1, 1, money, dp1);
        int excludeLast = houseRobber(n - 2, 0, money, dp2);

        return Math.max(excludeFirst, excludeLast);
    }

    private int houseRobber(int endIndex, final int startIndex, int[] money, int[] dp) {

        if (endIndex == startIndex) {
            return money[startIndex];
        }

        dp[startIndex] = money[startIndex];

        for (int i = startIndex + 1; i <= endIndex; i++) {
            int notPick = dp[i - 1];

            int pick = money[i];

            if (i - 2 >= startIndex) {
                pick += dp[i - 2];
            }

            dp[i] = Math.max(notPick, pick);
        }

        return dp[endIndex];
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1) auxiliary space
class Solution_SpaceOptimized {
    public int houseRobber(int[] money) {
        int n = money.length;

        if (n == 1) {
            return money[0];
        }

        int excludeFirst = houseRobber(n - 1, 1, money);
        int excludeLast = houseRobber(n - 2, 0, money);

        return Math.max(excludeFirst, excludeLast);
    }

    private int houseRobber(int endIndex, final int startIndex, int[] money) {

        if (endIndex == startIndex) {
            return money[startIndex];
        }

        int a = money[startIndex]; // index-2;
        int b = Math.max(money[startIndex], money[startIndex + 1]); // index-1

        for (int i = startIndex + 2; i <= endIndex; i++) {
            int notPick = b;

            int pick = money[i];

            if (i - 2 >= startIndex) {
                pick += a;
            }

            int c = Math.max(notPick, pick);
            a = b;
            b = c;
        }

        return b;
    }
}

public class HouseRobber2 {
    public static void main(String[] args) {

    }
}
