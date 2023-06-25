package BitwiseOperators;
//find kth bit of a number
// 1 0 1 1 0 1 = num
// 6 5 4 3 2 1 = index
//k=3 output = 1
public class FindKthBitOfNum {
    public static void main(String[] args) {
        int k=4;
        int n=14;//1110
        System.out.println(kthBitOfNum(n,k));
    }
    static int kthBitOfNum(int n,int k){
        int mask=1<<(k-1);
        System.out.println(mask+" "+n);
        int ans=n&mask;
        //ans is the value of that bit
        return ans!=0 ? 1 : 0;
    }
}
