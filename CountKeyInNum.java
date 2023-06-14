import java.util.Scanner;
public class CountKeyInNum {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num=scan.nextInt();
        System.out.print("Enter key to count : ");
        int key=scan.nextInt();
        System.out.println("Occurances of "+key+" in "+num+" is "+countOccurances(num, key));
        scan.close();
    }
    static int countOccurances(int num,int key){
        int count=0;
        int lastdigit;
        while(num>0){
            lastdigit=num%10;
            num=num/10;
            if(key==lastdigit){
                count++;
            }
        }
        return count;
    }
}
