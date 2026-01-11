package Recursion_and_Backtracking.Medium.LetterCombinationOfPhoneNumber;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/letter-combinations-of-a-phone-number?category=hard&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

// Time Complexity: O(4^N * N)
// Space Complexity: O(N) recursion stack
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] keyPad = {
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> res = new ArrayList<>();
        letterCombinations(0, "", digits, keyPad, res);
        return res;
    }

    private void letterCombinations(
            int index, String combination, String digits, String[] keyPad, List<String> res) {
        if (index == digits.length()) {
            res.add(combination);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String keys = keyPad[digit];

        for (int i = 0; i < keys.length(); i++) {
            letterCombinations(index + 1, combination + keys.charAt(i), digits, keyPad, res);
        }
    }
}

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {

    }
}
