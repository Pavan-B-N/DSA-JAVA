import java.lang.Math;
public class IsPrimeNum {
    public static void main(String arg[]) {
        int num = 11;
        if (checkPrime(num)) {
            System.out.print(num + " is a prime number");
        } else {
            System.out.print(num + " is a not prime number");
        }
    }

    static boolean checkPrime(int num) {
        int c = 2;
        int squareofnum=(int)Math.sqrt(num);
        //optimized 
        while (c <= squareofnum) { 
            if (num % c == 0) {
                return false;// its not a prime number
            }
            c++;
        }
        return true;// its a prime number
    }
}