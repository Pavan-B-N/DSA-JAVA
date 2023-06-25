package BitwiseOperators;

// 1 = 01 = 5
// 2 = 10 = 25
// 3 = 11 = 25+5=30
//magic number=summ(pow(5,k)) for the binary representaion of num;

//Amazon question
public class MagicNum {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(magicNumber(n));
    }

    static int magicNumber(int n) {
        int maginNum = 0;
        int k = 1;
        while (n > 0) {
            //finding the lsb
            int lsb = n & 1;
            if (lsb == 1) {
                maginNum += Math.pow(5, k);
            }
            k++;
            //performing right shift operation because we have already considered the bit
            n = n >> 1;
        }
        return maginNum;
    }
}