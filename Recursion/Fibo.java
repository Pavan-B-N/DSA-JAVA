package Recursion;
//find nth fibonacci number
public class Fibo {
    public static void main(String[] args) {
        //0,1,1,2,3,5,8,12,20
        int ans=fibo(5);
        System.out.println(ans);
    }   
    //Time complexity : (> exponential) or (golden ratio raise to power)
    static int fibo(int n){
        //base condition
        if(n<=1){
            return n;
        }
        //recurence relation
        return fibo(n-1)+fibo(n-2);
    }
}
