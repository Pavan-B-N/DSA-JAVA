package BinarySearch.Medium.KthMissingPositiveNumber;
// https://takeuforward.org/practice/dsa/kth-missing-positive-number?category=on-answers&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/kth-missing-positive-number/

// Time Complexity: O(n)
class Solution_Brute {
    public static int findKthPositive(int[] arr, int k) {
        if (k < arr[0])
            return k;

        int floorEleIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            int missingCount = arr[i] - (i + 1); // actualNumber - expectedNumber
            if (missingCount < k) {
                floorEleIndex = i;
            } else {
                break;
            }
        }

        int missingCountOfFloorEleIndex = arr[floorEleIndex] - (floorEleIndex + 1);
        int missingNumber = arr[floorEleIndex] + (k - missingCountOfFloorEleIndex);

        return missingNumber;
    }
}

// Time Complexity: O(logn)
class Solution_Optimal_BS {
    public static int findKthPositive(int[] arr, int k) {
        if (k < arr[0])
            return k;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // mid represents the choosen element from array
            int missingCount = arr[mid] - (mid + 1); // actualNumber - expectedNumber

            if (missingCount < k) {
                // ans
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        int floorEleIndex = end;
        int missingCountOfFloorEleIndex = arr[floorEleIndex] - (floorEleIndex + 1);
        int missingNumber = arr[floorEleIndex] + (k - missingCountOfFloorEleIndex);

        return missingNumber;
    }
}

public class KthMissingPositiveNumber {
    public static void main(String[] args) {

    }
}
