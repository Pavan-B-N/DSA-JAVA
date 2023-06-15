import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr={
            {1,5,6,9},
            {20,40,90,30},
            {14,80,730}
        };
        int[] ans=linearSearch2D(arr, 30);
        System.out.println(Arrays.toString(ans));
        
    }   
    static int[] linearSearch2D(int arr[][],int target){
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[row].length;col++){
                if(arr[row][col]==target){
                    return new int[]{row,col};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
