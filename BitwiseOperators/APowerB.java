package BitwiseOperators;
// a^b
public class APowerB {
    public static void main(String[] args) {
        System.out.println(powerof(2, 3));
    }
    static int powerof(int a,int b){
        int base=a;
        int ans=1;
        while(b>0){
            int lsb=b&1;
            if(lsb==1){
                ans*=base;
            }
            base*=base;
            b=b>>1;
        }
        return ans;
    }
}
