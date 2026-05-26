package Graphs.Hard.WordLadder2;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://takeuforward.org/practice/dsa/word-ladder-ii?category=hard-problems&source=strivers-a2z-dsa-sheet&sidebar=0
// https://leetcode.com/problems/word-ladder-ii/

// Time Complexity: O(N*M*26)
class Solution {
    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
        Set<String> hashSet = new HashSet<>(wordList);

        if (!hashSet.contains(endWord) || beginWord == endWord) {
            return new ArrayList<>();
        }

        Deque<List<String>> queue = new ArrayDeque<>();

        queue.offer(new ArrayList<>(List.of(beginWord)));

        boolean targetFound = false;

        List<List<String>> res = new ArrayList<>();

        while (!queue.isEmpty() && !targetFound) {
            int levelSize = queue.size();

            Set<String> innerHashSet = new HashSet<>();

            for (int i = 0; i < levelSize; i++) {
                List<String> list = queue.poll();

                String word = list.get(list.size() - 1);

                for (int j = 0; j < word.length(); j++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == word.charAt(j))
                            continue;

                        String transformedWord = word.substring(0, j) + ch + word.substring(j + 1);

                        if (hashSet.contains(transformedWord)) {
                            List<String> newList = new ArrayList<>(list);
                            newList.add(transformedWord);
                            innerHashSet.add(transformedWord);

                            if (transformedWord.equals(endWord)) {
                                targetFound = true;
                                res.add(newList);
                            } else {
                                queue.offer(newList);
                            }
                        }
                    }
                }
            }

            for (String word : innerHashSet) {
                hashSet.remove(word);
            }
        }

        return res;
    }
}

public class WordLadder2 {
    public static void main(String[] args) {

    }
}
