package BitwiseOperators;
//1010
//n=10 k=3 o=1110=14
//n=10 k=1 o=1011=11
public class ResetKthBit {
     public static void main(String[] args) {
        int n=10;
        int k=1;
        System.out.println(resetbit(n, k));
    }
    static int resetbit(int n,int k){
        int mask=1<<(k-1);
        return mask^n;
    }
}
