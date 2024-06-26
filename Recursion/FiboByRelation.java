package Recursion;

import java.util.Scanner;

public class FiboByRelation {
    //0 1 1 2 3 5 8 13 21 34
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter n to find nth fibonacci : ");
        int n=scan.nextInt();
        long ans=findFiboUsingRelation(n);
        System.out.println(n+"th fibonacci is "+ans);
        scan.close();
    }
    static long findFiboUsingRelation(int n){
        float root5=(float)Math.sqrt(5);
        float c1=1/root5;
        float c2=-c1;
        float alpha1=(float)Math.pow(((1+root5)/2), n);
        float alpha2=(float)Math.pow(((1-root5)/2), n);
        return (long)(c1*alpha1+c2*alpha2);
    }
}