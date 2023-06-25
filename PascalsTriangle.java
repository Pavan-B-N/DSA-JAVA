// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
public class PascalsTriangle {
    public static void main(String[] args) {
        int n=5;
        printPascalsTriangle(n);
        System.out.println("Sum of row "+n+"  is "+sumOfNthRow(n));
    }

    static void printPascalsTriangle(int order) {
        int[][] c = new int[order][order];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
                }
                System.out.print(c[i][j] + " ");
            }
            System.err.println();       
        }
    }
    static int sumOfNthRow(int n){
        //sum of nth row = 2^(n-1)
        return 1<<(n-1);// 1*2^(n-1)
    }
}