import java.util.ArrayList;
import java.util.Arrays;
//google question
public class FindDisappearedNumberInArray {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };// 8
        // output - [5,6]
     
        cyclicsort(arr);
        System.out.println(Arrays.toString(arr));
 
        ArrayList<Integer> list=new ArrayList<Integer>();
        //the elements which are not at correct index return those indices
        for(int index=0;index<arr.length;index++){
            if(index!=arr[index]-1){
                list.add(index+1);
            }
        }
        System.out.println("Missing Numbers are : "+list);
    }

    static void cyclicsort(int[] arr) {
        int n = arr.length;
        for (int index = 0; index < n; index++) {
            while (index != (arr[index] - 1)) {
                //since array consist of duplicates so it ay cause infinite loop
                if(arr[index]!=arr[arr[index]-1])
                    swap(arr, index, arr[index] - 1);
                else
                    break;   
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
