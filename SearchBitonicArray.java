//find a target element in the bitonic or mountain array
public class SearchBitonicArray {
    public static void main(String[] args) {
        int[] mountainArr={1,2,3,4,5,3,1,0};
        int target=3;
        int res=searchInMountainArray(mountainArr, target);
        System.out.println("Found Index : "+res);
    }

    static int searchInMountainArray(int[] arr,int target){
        int peakIndex=peakOfMountainArray(arr);
        System.out.println("peakIndex = "+peakIndex + " value = "+arr[peakIndex]);
        int ans;

        //search in ascending order sorted array
        ans=orderAgnosticBS(arr, target,0,peakIndex);
        //if target not found in ascending order part search in descending order part
        if(ans==-1){
            System.out.println("Element not found in ascending order , so searching in descending order");
            ans=orderAgnosticBS(arr, target, peakIndex+1, arr.length-1);
        }
        return ans;
    }
    static int orderAgnosticBS(int[] arr, int target,int start,int end) {
        int mid;
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                if (isAsc) {
                    if (target > arr[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (target < arr[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
    static int peakOfMountainArray(int[] arr){
        int start=0;
        int end=arr.length-1;
        int mid;
        while(start<end){
            mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}
