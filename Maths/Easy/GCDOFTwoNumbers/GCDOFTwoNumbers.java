package Maths.Easy.GCDOFTwoNumbers;
// https://takeuforward.org/practice/dsa/gcd-of-two-numbers

// Time Complexity: O(min(n1,n2))
class Solution {
    public int GCD(int n1, int n2) {
        int res = 1;
        int minEle = Math.min(n1, n2);

        for (int i = 2; i <= minEle; i++) {
            if (n1 % i == 0 && n2 % i == 0)
                res = i;
        }

        return res;
    }
}

// O(log(min(a, b)))
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution_EuclideanAlgorithm {
    public int GCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}

public class GCDOFTwoNumbers {
    public static void main(String[] args) {

    }
}
