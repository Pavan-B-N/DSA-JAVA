package Strings.Medium.CountAndSay;
// https://takeuforward.org/practice/dsa/count-and-say?category=medium-problems&source=strivers-a2z-dsa-sheet&sidebar=0&tab=solution

// Time Complexity: O(N * M)
// Space Complexity: O(M) for string building
class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        // freq then number

        StringBuilder curr = new StringBuilder("1");
        StringBuilder next = new StringBuilder("");

        while (n > 1) {

            int count = 1;
            for (int i = 1; i <= curr.length(); i++) {
                if (i == curr.length() || curr.charAt(i) != curr.charAt(i - 1)) {
                    next.append(Integer.toString(count));
                    next.append(curr.charAt(i - 1));
                    count = 1;
                } else {
                    count++;
                }
            }

            curr = new StringBuilder(next);
            next.setLength(0);

            n--;
        }

        return curr.toString();
    }
}

public class CountAndSay {
    public static void main(String[] args) {

    }
}
