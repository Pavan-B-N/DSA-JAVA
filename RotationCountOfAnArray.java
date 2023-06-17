//find the rotation count of an rotated sorted array
public class RotationCountOfAnArray {
    public static void main(String[] args) {
        int[] arr = { 15, 18, 2, 3, 6, 12 };
        int rotationCount=findRotationCount(arr);
        System.out.println(rotationCount);
    }
    static int findRotationCount(int[] arr){
        int pivotIndex=findPivot(arr);
        return pivotIndex+1;
    }
    //finding peak index of an rotated sorted array
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2; 
            if (arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid;
                // start=mid+1
            }
        }
        return -1;
    }
}
