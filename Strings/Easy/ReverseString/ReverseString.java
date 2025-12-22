package Strings.Easy.ReverseString;
// https://leetcode.com/problems/reverse-string/description/
// https://takeuforward.org/practice/dsa/reverse-a-string-ii?category=basic-strings&source=strivers-a2z-dsa-sheet

import java.util.List;;

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }

    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution_List_Version {
    public void reverseString(List<Character> s) {
        int i = 0;
        int j = s.size() - 1;

        while (i < j) {
            char temp = s.get(i);
            s.set(i, s.get(j));
            s.set(j, temp);

            i++;
            j--;
        }
    }
}

public class ReverseString {
    public static void main(String[] args) {

    }
}
