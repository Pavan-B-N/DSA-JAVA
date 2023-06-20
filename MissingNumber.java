//given an array nums containing n distinct numbers in the range (0,n) , return the only number in the range that is missing from the array
//range is (0,n) -> cyclic sort
//if nums=[3,0,1] then output=2
//Hint : missing number is the position or index of zero +1
//i.e MissingNumber=indexOF(0)+1 after cyclic sort
//0 indicates missing number

//Awazon question
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr1 = { 0, 1 };//2
        int[] arr2 = { 3,0, 1 };//2
        int[] arr3 = { 9,6,4,2,3,5,7,0,1 };//8
        int[] arr4 = { 4,0,2,1};//3
        System.out.println(findMissingNUmber(arr1));
        System.out.println(findMissingNUmber(arr2));
        System.out.println(findMissingNUmber(arr3));
        System.out.println(findMissingNUmber(arr4));
    }

    // cyclic sort
    static int findMissingNUmber(int[] arr) {
        int n = arr.length;
        //assuming 0th position as missing number position
        int missingNumIndex = 0;
        for (int index = 0; index < n; index++) {
            while (index != (arr[index] - 1)) {
                if (arr[index] == 0) {
                    missingNumIndex = index;
                    break;
                }
                swap(arr, index, arr[index] - 1);
            }
        }
        return missingNumIndex+1;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
