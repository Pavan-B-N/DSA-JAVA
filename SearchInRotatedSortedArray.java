//search in rotated sorted array 
//Note : array doesn't contains duplicates
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        // int[] arr = { 3, 4, 5, 6, 7, 0, 1, 2 };
        int[] arr={15,18,2,3,6,12};
        int target=5;
        System.out.println(searchInRotatedArray(arr, target));

    }

    static int searchInRotatedArray(int[] arr, int target) {
        // in case of rotated sorted array both part of the array are in ascending order
        // so orderAgnosticBS is not required
        int pivot = findPivot(arr);
        //pivot may be -1 is array is not rotated then 2nd condition will be executed
        System.out.println("pivot = " + pivot);
        int ans;
        ans=binarySearch(arr, target, 0, pivot);
        if(ans==-1){
            System.out.println("Target not found in first part of the array so searching in second part of the array");
            ans=binarySearch(arr, target, pivot+1, arr.length-1);
        }
        return ans;
    }

    //pivot element means peak element in tghe array
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            // 4 cases
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                // anyhow 2nd case will resolves the issue
                start = mid + 1;
                // start=mid;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
