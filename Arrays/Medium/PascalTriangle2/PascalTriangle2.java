package Arrays.Medium.PascalTriangle2;
// https://takeuforward.org/practice/dsa/pascals-triangle-ii?category=faqs-medium&source=strivers-a2z-dsa-sheet&sidebar=0&tab=solution

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle-ii/

// Time Complexity: O(N^2)
// Space Complexity: O(1)
class Solution_BruteForce {
    public int[] pascalTriangleII(int r) {
        int[] triangleRow = new int[r];

        for (int c = 1; c <= r; c++) {
            triangleRow[c - 1] = factorial(r - 1, c - 1);
        }

        return triangleRow;
    }

    // bruteForce
    private int factorial(int n, int r) {
        long res = 1;
        r = Math.min(r, n - r);

        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return (int) res;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution_Progessive {
    public int[] pascalTriangleII(int n) {
        int[] ans = new int[n];
        ans[0] = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = (ans[i - 1] * (n - i)) / i;
        }

        return ans;
    }
}

// 0 based indexing
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution_Progressive_Leetcode {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        ans.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            long valueOfCell = (ans.get(i - 1) * ((rowIndex - i) + 1L)) / i;
            ans.add((int) valueOfCell);
        }

        return ans;
    }
}

public class PascalTriangle2 {
    public static void main(String[] args) {

    }
}
