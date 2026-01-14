package Recursion_and_Backtracking.Hard.PalindromePartitioning;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/palindrome-partitioning?category=faqs-hard&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/palindrome-partitioning/description/

// Time Complexity: O(2^N * N)
// Space Complexity: O(N) recursion stack
class Solution {
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        partition(0, s, path, res);

        return res;
    }

    private void partition(int index, String s, List<String> path, List<List<String>> res) {

        if (index == s.length()) {
            res.add(new ArrayList<>(path));
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(index, i, s)) {
                path.add(s.substring(index, i + 1));

                partition(i + 1, s, path, res);

                path.remove(path.size() - 1);
            }
        }
    }

    boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}

public class PalindromePartitioning {
    public static void main(String[] args) {

    }
}
