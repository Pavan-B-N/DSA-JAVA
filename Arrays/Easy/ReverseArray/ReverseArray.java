package Arrays.Easy.ReverseArray;
// https://takeuforward.org/practice/dsa/reverse-an-array

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public void reverse(int[] arr, int n) {
        int i = 0;
        int j = n - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
}

public class ReverseArray {
    public static void main(String[] args) {

    }
}
