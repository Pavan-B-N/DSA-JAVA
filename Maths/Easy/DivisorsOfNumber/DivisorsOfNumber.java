package Maths.Easy.DivisorsOfNumber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://takeuforward.org/practice/dsa/divisors-of-a-number?category=basic-maths&source=strivers-a2z-dsa-sheet

// Time Complexity: O(sqrt(N))
// Space Complexity: O(1)
class Solution {
    public int[] divisors(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        Arrays.sort(res);

        return res;
    }
}

public class DivisorsOfNumber {
    public static void main(String[] args) {

    }
}
