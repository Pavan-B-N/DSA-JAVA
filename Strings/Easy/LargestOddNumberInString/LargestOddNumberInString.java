package Strings.Easy.LargestOddNumberInString;
// https://leetcode.com/problems/largest-odd-number-in-string/
// https://takeuforward.org/practice/dsa/largest-odd-number-in-a-string?category=basic-strings&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public String largestOddNumber(String num) {
        int i = num.length()-1;

        while(i>=0){
            int val = num.charAt(i) - '0';

            if(val%2==1) break;
            i--;
        }

        return num.substring(0,i+1);
    }
}

// TUF had an additional requirement to skip leading zeros
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution_TUF {    
    public String largeOddNum(String s) {
        int i = 0;
        int j = s.length() - 1;

        // skip leading zeros
        while(i<=j && s.charAt(i)=='0'){
            i++;
        }

        // find odd
        while(i<=j){
            int val = s.charAt(j)-'0';

            if(val%2==1) break;
            j--;
        }

        return s.substring(i,j+1);


    }
}

public class LargestOddNumberInString {
    public static void main(String[] args) {
        
    }
}
