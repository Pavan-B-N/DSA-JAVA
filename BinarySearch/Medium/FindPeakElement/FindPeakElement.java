package BinarySearch.Medium.FindPeakElement;
// https://takeuforward.org/practice/dsa/find-peak-element?category=faqs&source=strivers-a2z-dsa-sheet&tab=submissions
// https://leetcode.com/problems/find-peak-element/

// Time Complexity: O(log N)
// Space Complexity: O(1)
class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int start =0;
        int end = n-1;

        while(start < end){
            int mid = start + (end-start)/2;

            if(mid+1 < n && arr[mid] > arr[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
        }

        return end;
    }
}

public class FindPeakElement {
    public static void main(String[] args) {
        
    }
}
