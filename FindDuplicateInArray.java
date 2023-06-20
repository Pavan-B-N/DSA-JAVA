//find duplicate element in array
//cyclic sort
//Amazon question
class FindDuplicateInArray {
    public static void main(String[] args) {
        int[] arr={1,3,4,2,2};
        int d=findDuplicate(arr);
        System.out.println(d);
    }
    static int findDuplicate(int[] arr){
        cyclicsort(arr);
        for(int index=0;index<arr.length;index++){
            if(index!=arr[index]-1){
                return arr[index];
            }
        }
        return -1;
    }

    static void cyclicsort(int[] arr) {
        int n = arr.length;
        for (int index = 0; index < n; index++) {
            while (index != (arr[index] - 1)) {
                // since array consist of duplicates so it ay cause infinite loop
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