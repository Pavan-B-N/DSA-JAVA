package Graphs.Hard.WordLadder;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://takeuforward.org/practice/dsa/word-ladder-i?category=hard-problems&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/word-ladder/description/

// Time Complexity: O(N * L * 26) where N = word list size, L = word length
// Space Complexity: O(N) for word set and queue
class Solution {
    public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
        Set<String> hashSet = new HashSet<>();

        for (String word : wordList) {
            hashSet.add(word);
        }

        // edge case
        if (!hashSet.contains(targetWord) || startWord == targetWord) {
            return 0;
        }

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(startWord);
        hashSet.remove(startWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                String word = queue.poll();

                for (int j = 0; j < word.length(); j++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == word.charAt(j))
                            continue;
                        String transformWord = word.substring(0, j) + ch + word.substring(j + 1);

                        if (transformWord.equals(targetWord))
                            return level + 1;

                        if (hashSet.contains(transformWord)) {
                            hashSet.remove(transformWord);
                            queue.offer(transformWord);
                        }
                    }
                }
            }

            level++;
        }

        return 0;
    }
}

public class WordLadder {
    public static void main(String[] args) {

    }
}
