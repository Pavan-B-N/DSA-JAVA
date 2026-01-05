package Recursion_and_Backtracking.Easy.ReverseStringusingRecursion;
import java.util.ArrayList;

// https://takeuforward.org/practice/dsa/reverse-a-string-i?category=basic-recursion&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(N)
// Space Complexity: O(N) recursion stack
class Solution {
    public ArrayList<Character> reverseString(ArrayList<Character> s) {
        int n = s.size();

        reverse(0, n - 1, s);

        return s;
    }

    private void reverse(int i, int j, ArrayList<Character> s) {
        if (i >= j)
            return;

        char temp = s.get(i);
        s.set(i, s.get(j));
        s.set(j, temp);

        reverse(i + 1, j - 1, s);
    }
}

public class ReverseStringusingRecursion {
    public static void main(String[] args) {

    }
}
