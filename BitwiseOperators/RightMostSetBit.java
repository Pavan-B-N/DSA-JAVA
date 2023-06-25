package BitwiseOperators;
//find the position of the right most set bit
//11110000 = 5
//10100 = 3
//1010 = 2
//01 = 1
public class RightMostSetBit {
    public static void main(String[] args) {
        int n=16;
        System.out.println(rightmostSetBit(n));
    }

    static int rightmostSetBit(int n){
        if(n==0){
            return -1;
        }
        int k=1;
        while(true){
            int kthbit=findKthBit(n, k);
            if(kthbit!=0)
                return k;
            k++;
        }
    }
    static int findKthBit(int n,int k){
        int mask=1<<k-1;
        int ans=mask&n;
        return ans!=0 ? 1 : 0;
    }
}
