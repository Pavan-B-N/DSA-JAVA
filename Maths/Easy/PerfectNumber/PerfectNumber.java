package Maths.Easy.PerfectNumber;
// https://leetcode.com/problems/perfect-number/
// https://takeuforward.org/practice/dsa/check-for-perfect-number

// Time Complexity: O(√n)
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;

        int sumOfPositiveDivisors = 1;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sumOfPositiveDivisors += i;
                sumOfPositiveDivisors += (num / i);
            }
        }

        return sumOfPositiveDivisors == num;
    }
}

public class PerfectNumber {
    public static void main(String[] args) {

    }
}
