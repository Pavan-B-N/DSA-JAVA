public class FindMinMaxInArray {
    public static void main(String[] args) {
        int[] arr = { 8, 6, 44, 22, 33, 66, 20, 15, 98, 44, 99, 5,5 };
        System.err.println(min(arr));
        System.err.println(max(arr));
    }

    static int min(int[] arr) {
        int minNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (minNum > arr[i]) {
                minNum = arr[i];
            }
        }
        return minNum;
    }

    static int max(int[] arr){
        int maxNum=arr[0];
        for(int i=1;i<arr.length;i++){
            if(maxNum<arr[i]){
                maxNum=arr[i];
            }
        }
        return maxNum;
    }
}
