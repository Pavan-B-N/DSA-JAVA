package Arrays.Easy.LinearSearch;
// https://takeuforward.org/practice/dsa/linear-search

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int linearSearch(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }
}

public class LinearSearch {
    public static void main(String[] args) {

    }
}
