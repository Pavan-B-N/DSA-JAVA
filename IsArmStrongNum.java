import java.util.Scanner;

public class IsArmStrongNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number to check if it is an armstrong number or not : ");
        int n = scan.nextInt();
        if (isArmStrongNumber(n)) {
            System.out.println(n + " is an Armstrong number");
        } else {
            System.out.println(n + " is not an Armstrong number");
        }
        scan.close();
    }

    static boolean isArmStrongNumber(int n) {
        int sum = 0;
        int num=n;
        int lastdigit;
        while (n > 0) {
            lastdigit = n % 10;
            sum += cubic(lastdigit);
            n = n / 10;
        }
        if (sum == num)
            return true;
        return false;
    }

    static int cubic(int n) {
        return n * n * n;
    }
}
