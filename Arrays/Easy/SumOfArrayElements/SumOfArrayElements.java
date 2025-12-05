package Arrays.Easy.SumOfArrayElements;
// https://takeuforward.org/practice/dsa/sum-of-array-elements

// Time Complexity: O(N)
// Space Complexity: O(N) recursion stack
class Solution {
    public int sum(int arr[], int n) {
        int res = 0;

        for (int i = 0; i < n; i++) {
            res += arr[i];
        }

        return res;
    }
}

public class SumOfArrayElements {
    public static void main(String[] args) {

    }
}
