//find nth fibonacci number
//0 1 1 2 3 5 - fibonacci numbers
//0 1 2 3 4 5 - index
import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n to find the n^th fibonacci number : ");
        int n = scan.nextInt();
        System.out.println(n + " th fibonacci is " + fibo(n));
        scan.close();
    }
    //time complexity is o(n)
    static int fibo(int n) {
        if(n==0) return 0;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int res = a + b;
            a = b;
            b = res;
        }
        return b;
    }
}
