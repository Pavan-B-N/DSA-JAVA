package Recursion;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 8, 7, 10 };
        int target=100;
        int ans=binarysearch(arr, target, 0, arr.length);
        System.out.println(ans);
    }
    //type of relation : divide and conquer recurrence relation 
    static int binarysearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
           return binarysearch(arr, target, mid + 1, end);
        } else {
           return binarysearch(arr, target,start, mid-1);
        }
    }
}
