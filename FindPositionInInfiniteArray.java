//find position of an element  in a sorted array of infinite numbers
public class FindPositionInInfiniteArray {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        System.out.println(findPositionOfInfiniteArray(arr, target));
    }

    static int findPositionOfInfiniteArray(int[] arr, int target) {
        //find the range of the start and end then apply the binary search
        int start=0;
        int end=1;
       while(target>arr[end]){
        int newstart=end+1;
        //end=pre+lenth of box *2 i.e double the box size
        end=end+(end-start)+1*2;
        start=newstart;
       }
       return binarySearch(arr, target, start, end);

    }
       static int binarySearch(int[] arr, int target,int start,int end) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == target) {
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