public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 1, 8, 6, 44, 22, 33, 66, 20, 15, 98 ,44,99,55};
        System.out.println(linearSearch(arr, 44));
        System.out.println(searchInRange(arr, 44,4,12));
    }

    // linear search for an integer
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //search in the given range
    static int searchInRange(int[] arr,int target,int start,int end){
        for(int i=start;i<=end;i++){
            if(arr[i]==target)
                return i;
        }
        return -1;
    }
}
