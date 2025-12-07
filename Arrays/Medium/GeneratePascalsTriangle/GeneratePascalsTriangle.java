package Arrays.Medium.GeneratePascalsTriangle;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/description/
// https://takeuforward.org/practice/dsa/pascals-triangle-iii

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> matrix = new ArrayList<>(numRows);

        for(int i=0;i<numRows;i++){
            matrix.add(new ArrayList<>(i+1));
        }

        for(int i=0;i<numRows;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || i==j){
                    matrix.get(i).add(1);
                }else{
                    matrix.get(i).add( matrix.get(i-1).get(j-1) + matrix.get(i-1).get(j)  );
                }
            }
        }

        return matrix;

    }
}

public class GeneratePascalsTriangle {
    public static void main(String[] args) {
        
    }
}
