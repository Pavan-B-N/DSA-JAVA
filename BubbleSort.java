import java.util.Arrays;

public class BubbleSort{
    public static void main(String[] args) {
        int[] arr={3,2,1,3,2,3};
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //Time complexity 
    //best case - o(n)
    //worst case - o(n^2)
    static void bubblesort(int[] arr){
        int n=arr.length;
        //take each element and compare with adjacent , therefore last element is not considered because last element doesn't have any adjacent and it's already compared with previous element
        for(int i=0;i<n-1;i++){
            //start from 0 to j-i i.e until the sorted array which is largest elements get sorted
            boolean swapped=false;
            //j=n-1 because we are comparing the next elemnet
            //j=n-i because we should search until the sorted array but not inside the sorted array
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    swapped=true;
                }
                if(!swapped){
                    break;
                }
            }
        }
    }
    static void swap(int[] arr,int a,int b){
        int temp=arr[b];
        arr[b]=arr[a];
        arr[a]=temp;
    }
}