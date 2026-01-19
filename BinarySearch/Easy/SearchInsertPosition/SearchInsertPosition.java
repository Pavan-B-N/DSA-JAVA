package BinarySearch.Easy.SearchInsertPosition;
// https://leetcode.com/problems/search-insert-position/description/
// https://takeuforward.org/practice/dsa/search-insert-position?category=logic-building&source=strivers-a2z-dsa-sheet

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return start;
    }
}

public class SearchInsertPosition {
    public static void main(String[] args) {
        
    }
}
