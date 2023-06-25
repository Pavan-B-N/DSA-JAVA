package BitwiseOperators;
//find whether the given number is even or odd
//4 - 100 
//5 - 101
//we can notice that for odd number the first bit (2^0)th bit is set to 1
public class isEven {
    public static void main(String[] args) {
        int n=19;
        // boolean ans=checkByXOR(n);
        boolean ans=chechByAND(n);
        System.out.println(ans);
    }
    //using xor operation
    //4 ^ 1 = 101 =5 
    //so for even res>n 
    //i.e if res > n then it's even else its odd
    static boolean checkByXOR(int n){
        int res=n^1;
        return res>n;
    }
    //a&1 = 1 ? odd : even
    static boolean chechByAND(int n){
        int res=n&1;
        return res==0;
    }
}
