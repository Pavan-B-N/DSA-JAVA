//find the peak index of bitonic or mountain array
//indirectly its about finding the maximum number in the array but we should use binary search for it
//half array is in ascending order and rest of them in descending order
public class BitonicArray {
    public static void main(String[] args) {
        int[] arr={0,1,0};
        System.out.println(findPeak(arr));
    }   
    static int findPeak(int[] arr){
        int start=0;
        int end=arr.length-1;
        int mid;
        while(start<end){
            mid=(start+end)/2;
            //largest element can be mid or its in left side
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        //return start or end because both points to the same element
        return end;
    }
}
 