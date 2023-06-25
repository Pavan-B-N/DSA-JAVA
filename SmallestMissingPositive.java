//given an unsorted array nums,return the smallest positive integer
//you must implement an algorithm that runs in o(n) time and uses constant extra space
//nums=[1,2,0] output=3
//nums=[3,4,-1,1] output=2
//nums=[7,8,9,11,12] output=1

//ignore the elements that are -ve and greater than n

import java.util.Arrays;

public class SmallestMissingPositive {
    public static void main(String[] args) {
        // int[] arr = { 3, 4, -1, 1 };//2
        // int[] arr = { 7,8,9,11,12 };//1
        int[] arr = { 1,2,0 };//3
        System.out.println(smallestMissingPositiveNum(arr));
    }
 
    //first missing positive number
    static int smallestMissingPositiveNum(int[] arr){
         cyclicsort(arr);
        System.out.println(Arrays.toString(arr));
         for (int index = 0; index < arr.length; index++) {
            if (index != arr[index] - 1) {
                return index+1;
            }
        }
        return -1;
    }

    static void cyclicsort(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            while (index != arr[index] - 1) {
                // ignore the elements that are -ve and greater than n
                if (arr[index] <= 0 || arr[index] > arr.length)
                    break;
                swap(arr, index, arr[index] - 1);
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
