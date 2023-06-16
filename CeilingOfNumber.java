//find ceiling of a given number - binary search
//arr=[2,3,5,9,14,16,18]
//ceiling of 14 = 14
//ceiling of 15 = 16
//ceiling means smallest element in the given array that is greater than or equal to the target number
//FLOOR means greatest element in the given array that is lesser than or equal to the target number
public class CeilingOfNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, 9 };
        int target = 4;
        int ceil = ceilingOfNumber(arr, target);
        int floor = floorOfNumber(arr, target);
        System.out.println("Ceiling of a Number = " + ceil);
        System.out.println("Floor of a Number = " + floor);
    }

    static int ceilingOfNumber(int[] arr, int target) {
        // if the given target is greater than last element the return -1
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        // Note : once the loop get over start->ceil and end->floor for the given target
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (target == arr[mid]) {
                return arr[mid];
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        // it is possible to return the start which acts as a ceil of a number because
        // condition fails when start becomes start>end i.e start is pointing to the
        // next element which is obiously the next largets element
        return arr[start];
    }

    static int floorOfNumber(int[] arr, int target) {
        // if the given target is greater than last element the return -1
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (target == arr[mid]) {
                return arr[mid];
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return arr[end];
    }
}
