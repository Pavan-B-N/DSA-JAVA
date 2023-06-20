public class StringPlaindrome {
    public static void main(String[] args) {
        checkPlaindrome("moooooom");
    }
    static void checkPlaindrome(String s){
        int count=0;
        int i=0;
        int j=s.length()-1;
        //loop will run n/2 times
        while(i<=j){
            char start=s.charAt(i);
            char end=s.charAt(j);
            if(start!=end){
                System.out.println("Its not palindrome");
                System.out.println("Count = "+(count));
                return;
            }
            i++;
            j--;
            count++;
        }
        System.out.println("Count = "+(count));
        System.out.println("given string is palindrome");
    }
}
