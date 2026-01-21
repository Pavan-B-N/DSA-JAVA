package BinarySearch.Medium.FindNthRootOfNumber;
// https://takeuforward.org/practice/dsa/find-nth-root-of-a-number?category=on-answers&source=strivers-a2z-dsa-sheet

// Time Complexity: O(log M * log N)
// Space Complexity: O(1)
class Solution {
    public int NthRoot(int N, int M) {
        int start = 1;
        int end = M;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long powVal = XPowN(mid, N, M);
            // long powVal =(long) Math.pow(mid,N);

            if (powVal == M) {
                return mid;
            } else if (powVal > M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    // Binary exponetiation
    long XPowN(long x, long n, final int M) {
        long res = 1;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
                x = x * x;
                if (x > M)
                    return x;
            } else {
                n--;
                res = res * x;
                if (x > M)
                    return res;
            }
        }

        return res;
    }

}

public class FindNthRootOfNumber {
    public static void main(String[] args) {

    }
}
