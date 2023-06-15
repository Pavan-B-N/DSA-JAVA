import java.util.Scanner;

public class NumLen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number : ");
        int num = scan.nextInt();
        System.out.println("length of " + num + "by division is " + lenByDivision(num));
        System.out.println("length of " + num + "by logarithmic method is " + lenByLog(num));
        scan.close();
    }

    static int lenByDivision(int num) {
        if (num < 0) {
            num *= -1;
        }
        int len = 0;
        do {
            len++;
            num /= 10;
        } while (num > 0);

        return len;
    }

    static int lenByLog(int num) {
        return (int) Math.ceil(Math.log10(num));
    }
}
