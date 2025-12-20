package Strings.Easy.IsValidPalindrome;
// https://leetcode.com/problems/valid-palindrome/
// https://takeuforward.org/practice/dsa/palindrome-check?category=basic-strings&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;

            i++;
            j--;
        }

        return true;
    }
}

public class IsValidPalindrome {
    public static void main(String[] args) {
        
    }
}
