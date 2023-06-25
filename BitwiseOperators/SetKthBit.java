package BitwiseOperators;
//1010 = num =10
//1011 = set 1st bit = 11
//num=10 k=1 output=11
//num=10 k=3 output=14
public class SetKthBit {
    public static void main(String[] args) {
        int n=10;
        int k=3;
        System.out.println(setbit(n, k));
    }
    static int setbit(int n,int k){
        int mask=1<<(k-1);
        return mask|n;
    }
}
