package Strings.Easy.ReverseWordsInString;
// https://leetcode.com/problems/reverse-words-in-a-string/
// https://takeuforward.org/practice/dsa/reverse-every-word-in-a-string?category=medium-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(N) for words storage
class Solution {
    public String reverseWords(String str) {
        str = str.replaceAll("\\s+"," ");
        str = str.trim();

        String[] arr = str.split(" ");

        StringBuilder res = new StringBuilder();

        for(int i=arr.length-1;i>=0;i--){
            res.append(arr[i]);
            if(i!=0) res.append(" ");
        }

        return res.toString();
    }
}

public class ReverseWordsInString {
    public static void main(String[] args) {
        
    }
}
