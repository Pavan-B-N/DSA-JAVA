package Patterns;
//         1 
//       2 1 2 
//     3 2 1 2 3 
//   4 3 2 1 2 3 4 
// 5 4 3 2 1 2 3 4 5 
public class p9 {
    public static void main(String[] args) {
        int n = 4;
        for (int row = 1; row <= n; row++) {
            int colCount = row + row - 1;
            int spaces = (n - row);
            for (int col = 1; col <= spaces; col++) {
                System.out.print("  ");
            }
            for (int col = spaces + 1; col <= (colCount + spaces); col++) {
                int val = col > n ? (col - n + 1) : (n - col + 1);
                System.out.print(val + " ");
            }

            // for(int col=row; col>=1;col--){
            // System.out.print(col + " ");
            // }
            // for(int col=2; col<=row;col++){
            // System.out.print(col + " ");
            // }

            System.out.println();
        }
    }
}
