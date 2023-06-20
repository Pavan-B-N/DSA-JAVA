import java.util.Arrays;

//Note : cyclic sort is only for 1-n array
public class CyclicSort {
    public static void main(String[] args) {
        // it works only for 1-n array
        // negative values are also not allowed
        int[] arr = { 3, 5, 2, 1, 4, 6, 9, 8, 12, 10, 11, 7 };
        cyclicsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicsort(int[] arr) {
        int n = arr.length;
        for (int index = 0; index < n; index++) {
            while (index != (arr[index] - 1)) {
                // since array consist of duplicates so it may cause infinite loop
                //no <=0 and >length and no duplicates
                if (arr[index] <= 0 || arr[index] > arr.length || arr[index] == arr[arr[index] - 1])
                    break;
                swap(arr, index, arr[index] - 1);
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
