//given an array nums=[1,2,2,4] ,output=[2,3]
//find the number that occurs twice and the number that is missing and return them in the form of array

//error - repetition + disappeared

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 4 };
        // int[] arr1={1,1};
        int[] error = findErrorNums(arr);
        System.out.println(Arrays.toString(error));
    }

    static int[] findErrorNums(int[] arr) {
        cyclicSort(arr);
        for (int index = 0; index < arr.length; index++) {
            if (index != arr[index] - 1) {
                return new int[] { arr[index], index + 1 };// [repetated,disapperead]
            }
        }
        return new int[] { -1, -1 };
    }

    // 1-n
    static void cyclicSort(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            while (index != arr[index] - 1) {
                // before swappig make sure that it's not a duplicate value if it's duplicate it
                // causes infinite loop
                if (arr[index] == arr[arr[index] - 1])
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
