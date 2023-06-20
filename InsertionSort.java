import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={3,2,1,3,2,3};
        insertionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //Time  complexity = o(n)
    static void insertionsort(int[] arr){
        //0th element is always considered as sorted
        int j;
        int key;
        for(int i=1;i<arr.length;i++){
            key=arr[i];
            j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}