package BitwiseOperators;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        int n=4;
        System.out.println(isPowerof2(n));
    }
    static boolean isPowerof2(int n){
        if(n<=0){
            return false;
        }
        return (n&(n-1))==0;
    }
}
