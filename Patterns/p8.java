package Patterns;
//     * 
//    * * 
//   * * * 
//  * * * * 
// * * * * * 
//  * * * * 
//   * * * 
//    * * 
//     * 
public class p8 {
    public static void main(String[] args) {
        int n=5;
        for(int row=1;row<=2*n-1;row++){
            int colCount=row>n ? 2*n-row : row;
            int spaces=n-colCount;
            //printing spaces
            for(int col=1;col<=spaces;col++){
                System.out.print(" ");
            }
            //printing start
              for(int col=1;col<=colCount;col++){
                //with space
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
