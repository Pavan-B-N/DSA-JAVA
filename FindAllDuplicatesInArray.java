import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Amazon and microsoft
public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};
        //[2,3]
        List<Integer> duplicates=findAllDuplicates(arr);
        System.out.println(duplicates);
    }
    static List<Integer> findAllDuplicates(int[] arr){
        cyclicsort(arr);
        System.out.println(Arrays.toString(arr));
        List<Integer> list=new ArrayList<Integer>();
        for(int index=0;index<arr.length;index++){
            if(index!=arr[index]-1){
                list.add(arr[index]);
            }
        }
        return list;
    }
    static void cyclicsort(int[] arr) {
        int n = arr.length;
        for (int index = 0; index < n; index++) {
            while (index != (arr[index] - 1)) {
                // since array consist of duplicates so it may cause infinite loop
                if (arr[index] != arr[arr[index] - 1])
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
