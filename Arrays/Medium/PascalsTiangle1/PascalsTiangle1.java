package Arrays.Medium.PascalsTiangle1;
// https://leetcode.com/problems/pascals-triangle-ii/

// nCr -> Combination
// nCr = n! / (r! * (n-r)!)

// Causes Integer Overflow at early test cases itself because factorial grows exponetially
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {

    public int pascalTriangleI(int row, int col) {

        return factorial(row - 1) /
               (factorial(col - 1) * factorial(row - col));
    }

    private int factorial(int n) {
        int res = 1;

        for (int i = 2; i <= n; i++) {
            res *= i;
        }

        return res;
    }
}
// calculate nCr progressively
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution_ProgressiveAlgorithm {

  public int pascalTriangleI(int row, int col) {
    return factorial(row - 1, col - 1);
  }

  private int factorial(long n, long r) {
    long res = 1;

    r = Math.min(r, n - r);

    for (long i = 0; i < r; i++) {
      res = res * (n - i);
      res = res / (i + 1);
    }

    return (int) res;
  }
}


public class PascalsTiangle1 {
    public static void main(String[] args) {

    }
}
