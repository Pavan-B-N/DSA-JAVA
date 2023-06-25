public class NoOfDigitOfBase {
    public static void main(String[] args) {
        int n=16;
        int base=2;
        int d=numberOfDigits(n, base);
        System.out.println("Number of digits for number n="+n+" and base b="+base+" is "+d);
    }
    static int numberOfDigits(int n,int base){
        int digits=(int)(Math.log(n)/Math.log(base))+1;
        return digits;
    }
}
