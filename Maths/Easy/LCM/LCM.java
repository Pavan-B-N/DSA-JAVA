package Maths.Easy.LCM;
// https://takeuforward.org/practice/dsa/lcm-of-two-numbers?tab=problem&solution=optimal

// Time Complexity: O(log(min(A, B)))
// Space Complexity: O(1)
class Solution {
    public int LCM(int n1, int n2) {
        return (n1 * n2) / GCD(n1, n2);
    }

    private int GCD(int a, int b) {
        // Euclidean Algo: GCD(a,b) = GCD(b,a%b)

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}

public class LCM {
    public static void main(String[] args) {

    }
}
