package Recursion_and_Backtracking.Medium.GenerateBinaryStrings;
import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/practice/dsa/generate-binary-strings-without-consecutive-1s?category=subsequence-pattern-problems&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(2^N)
// Space Complexity: O(N) recursion stack
class Solution {
    public List<String> generateBinaryStrings(int n) {
        List<String> res = new ArrayList<>();

        generateBinaryStrings(n, true, "", res);

        return res;
    }

    private void generateBinaryStrings(int n, boolean canPickOne, String s, List<String> res) {
        if (n == 0) {
            res.add(s);
            return;
        }

        // notPick
        generateBinaryStrings(n - 1, true, s + "0", res);

        // pick
        if (canPickOne) {
            generateBinaryStrings(n - 1, false, s + "1", res);
        }
    }
}

public class GenerateBinaryStrings {
    public static void main(String[] args) {

    }
}
