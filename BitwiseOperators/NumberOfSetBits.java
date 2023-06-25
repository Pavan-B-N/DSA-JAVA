package BitwiseOperators;
//  1010 = 2
//  100 = 1
public class NumberOfSetBits {
    public static void main(String[] args) {
        int n=3;
        System.out.println(findNumeberOfSetBits(n));
    }
    static int findNumeberOfSetBits(int n){
        int setbits=0;
        while(n>0){
            int lsb=n&1;
            if(lsb==1){
                setbits++;
            }
            n>>=1;
        }
        return setbits;
    }
}
