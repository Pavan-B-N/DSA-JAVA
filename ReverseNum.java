import java.util.Scanner;

public class ReverseNum{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter any number : ");
        int num=scan.nextInt();
        System.out.println("Reverse of "+num+" is "+reverse(num));
        scan.close();
    }
    static int reverse(int n){
        int rn=0;
        int lastdigit;
        while(n>0){
            lastdigit=n%10;
            rn=rn*10+lastdigit;
            n=n/10;
        }
        return rn;
    }
}