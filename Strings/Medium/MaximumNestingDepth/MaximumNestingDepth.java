package Strings.Medium.MaximumNestingDepth;
// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
// https://takeuforward.org/practice/dsa/maximum-nesting-depth-of-the-parentheses?category=parentheses&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int maxDepth(String s) {
        int open = 0;
        int maxOpen = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
            }else if(s.charAt(i)==')'){
                open--;
            }

            maxOpen = Math.max(open,maxOpen);
        }

        return maxOpen;
    }
}

public class MaximumNestingDepth {
    public static void main(String[] args) {
        
    }
}
