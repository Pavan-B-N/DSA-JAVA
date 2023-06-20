package Patterns;
// *
// **
// ***
// ****
// *****
// ****
// ***
// **
// *
public class p5 {
    public static void main(String[] args) {
        int n=4;
        for(int row=1;row<=2*n-1;row++){
            int colCount=row>n ? 2*n-row : row;
            for(int col=1;col<=colCount;col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
