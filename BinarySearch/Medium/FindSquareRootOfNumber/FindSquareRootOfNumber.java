package BinarySearch.Medium.FindSquareRootOfNumber;
// https://leetcode.com/problems/sqrtx/
// https://takeuforward.org/practice/dsa/find-square-root-of-a-number?category=on-answers&source=strivers-a2z-dsa-sheet


// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution_Linear_Path {
    public int floorSqrt(int n) {
        int ans = 0;

        for (long i = 1; i <= n; i++) {
            long sqrt = i * i;
            if (sqrt > n) {
                break;
            }

            ans = (int) i;
        }

        return ans;
    }
}

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution_BinarySearchOnAnswer {
    public int floorSqrt(int n) {
        long start = 0;
        long end = n;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sqrt = mid * mid;

            if (sqrt == n) {
                return (int) mid;
            } else if (sqrt < n) {
                // ans = mid
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (int) end;
    }
}

public class FindSquareRootOfNumber {
    public static void main(String[] args) {

    }
}
