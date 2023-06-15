public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 9, 11, 12, 14, 20, 36, 48 };
        int[] arr2={60,40,5,2};
        System.out.println(binarySearch(arr, 36));
        System.out.println(orderAgnosticBS(arr, 36));
        System.out.println(orderAgnosticBS(arr2, 5));

    }

    // this is for ascending order
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target < arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}