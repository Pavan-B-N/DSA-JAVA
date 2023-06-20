package Patterns;
//     *
//    * *
//   * * *
//  * * * *
// * * * * *
public class p7 {
    public static void main(String[] args) {
        int n=5;
        for(int row=1;row<=n;row++){
            int spaces=n-row;
            //printing spaces
            for(int col=1;col<=spaces;col++){
                System.out.print(" ");
            }
            //printing start
              for(int col=1;col<=row;col++){
                //with space
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
