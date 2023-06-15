//for the given array return how many of them contains even number of digits
public class EvenNumberOfDigits {
    public static void main(String[] args) {
        int[] arr = { 1, 20, 0, 9, 2, -60, -50, -10 };

        // count holds how many numbers conatins the even number of digits
        int count = 0;
        int nod;
        for (int element : arr) {
            nod = numberOfDigits(element);
            if (nod % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    // numberOfDigits means finding length of the number
    static int numberOfDigits(int num) {
        if (num < 0) {
            num *= -1;
        }
        int len = 0;
        do {
            len++;
            num /= 10;
        } while (num > 0);
        
        return len;
    }
}
