package Arrays.Hard.MaximumProductSubArray;
// https://leetcode.com/problems/maximum-product-subarray/
// https://takeuforward.org/practice/dsa/maximum-product-subarray-in-an-array?category=faqs-hard&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int prefixProd = 1;
        int suffixProd = 1;

        int maxProd = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefixProd *= nums[i];
            suffixProd *= nums[n - i - 1];

            maxProd = Math.max(maxProd, Math.max(prefixProd, suffixProd));

            if (prefixProd == 0)
                prefixProd = 1;
            if (suffixProd == 0)
                suffixProd = 1;
        }

        return maxProd;
    }
}

public class MaximumProductSubArray {
    public static void main(String[] args) {
        
    }
}
