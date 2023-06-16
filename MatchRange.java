//find first and last position of an element in the sorted array
//nums=[5,7,7,8,8,10] target=8
//output =[3,4]
//Note we should implement using Binary Search Algorithm
import java.util.Arrays;

public class MatchRange {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int target = 98;
        int[] res = matchRangeByBS(arr, target);
        System.out.println(Arrays.toString(res));
    }

    static int[] matchRangeByBS(int[] arr, int target) {
        int start=search(arr, target, true);
        int end=search(arr, target, false);
        return new int[]{start,end};
    }

    static int search(int[] arr,int target,boolean findFirstIndex){
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int ans=-1;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (target == arr[mid]) {
                ans=mid;
                if(findFirstIndex){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return ans;
    }
    // easily solved by LS but time complexity=o(n)
    static int[] matchRangeByLS(int[] arr, int target) {
        int sp = -1;
        int ep = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (sp < 0) {
                    sp = i;
                }
                ep = i;
            }
        }
        return new int[] { sp, ep };
    }
}
