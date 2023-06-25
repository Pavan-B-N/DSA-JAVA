package BitwiseOperators;

import java.util.Arrays;

//flip means reversing the each row
//invert means 0 becomes 1 and 1 becomes 0
public class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 0, 1 },
                { 0, 1, 1 },
                { 0, 1, 0 }
        };
        //output
        // [0, 1, 0]
        // [0, 0, 1]
        // [1, 0, 1]
        flipAndInvertMatrix(arr);
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
            ;
        }
    }

    static void flipAndInvertMatrix(int[][] arr) {
        for (int[] row : arr) {
            // reverse and invert the array
            for (int i = 0; i <= (row.length / 2); i++) {
                int lastIndex = row.length - 1;
                int temp = row[i] ^ 1;// storing inverted value
                row[i] = row[lastIndex - i] ^ 1;// storing inverted value using xor operation
                row[lastIndex - i] = temp;
            }
        }
    }

}
