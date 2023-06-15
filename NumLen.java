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
        int l = 0;
        while (num > 0) {
            num = num / 10;// removing last digit
            l++;
        }
        return l;
    }

    static int lenByLog(int num) {
        return (int) Math.ceil(Math.log10(num));
    }
}
