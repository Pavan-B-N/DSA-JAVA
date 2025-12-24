package Strings.Medium.FrequencySort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://takeuforward.org/practice/dsa/sort-characters-by-frequency?category=basic-strings&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public List<Character> frequencySort(String s) {
        Pair[] freqArr = new Pair[26];
        for (int i = 0; i < 26; i++) {
            freqArr[i] = new Pair(0, (char) (i + 'a'));
        }

        for (int i = 0; i < s.length(); i++) {
            freqArr[s.charAt(i) - 'a'].freq++;
        }

        Arrays.sort(
                freqArr,
                (a, b) -> {
                    if (a.freq == b.freq)
                        return Character.compare(a.ch, b.ch);

                    return Integer.compare(b.freq, a.freq);
                });

        List<Character> res = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (freqArr[i].freq == 0)
                break;
            res.add(freqArr[i].ch);
        }

        return res;
    }

    class Pair {
        int freq;
        char ch;

        Pair(int f, char c) {
            this.freq = f;
            this.ch = c;
        }
    }
}

public class FrequencySort {
    public static void main(String[] args) {

    }
}
