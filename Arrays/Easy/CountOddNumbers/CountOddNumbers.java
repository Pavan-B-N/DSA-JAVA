package Arrays.Easy.CountOddNumbers;
// https://takeuforward.org/practice/dsa/count-of-odd-numbers-in-array

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int countOdd(int[] arr, int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 1)
                count++;
        }
        return count;
    }
}

public class CountOddNumbers {
    public static void main(String[] args) {

    }
}
