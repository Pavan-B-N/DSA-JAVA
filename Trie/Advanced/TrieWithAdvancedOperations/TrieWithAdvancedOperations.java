package Trie.Advanced.TrieWithAdvancedOperations;
// https://takeuforward.org/practice/dsa/trie-implementation-and-advanced-operations?category=triessubc&source=strivers-a2z-dsa-sheet&sidebar=0

class TrieNode {
    TrieNode[] links;

    private int wordCount;
    private int prefixCount;

    public TrieNode() {
        links = new TrieNode[26];
        wordCount = 0;
        prefixCount = 0;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void increaseWordCount() {
        wordCount++;
    }

    public void decreaseWordCount() {
        wordCount--;
    }

    public void increasePrefixCount() {
        prefixCount++;
    }

    public void decreasePrefixCount() {
        prefixCount--;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getPrefixCount() {
        return prefixCount;
    }
}

// Time Complexity: O(L) per insert, countWordsEqualTo, countWordsStartingWith, erase
// Space Complexity: O(N * L * 26)
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }

            node = node.get(ch);
            node.increasePrefixCount();
        }

        node.increaseWordCount();
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                return 0;
            }

            node = node.get(ch);
        }

        return node.getWordCount();
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (!node.containsKey(ch)) {
                return 0;
            }

            node = node.get(ch);
        }

        return node.getPrefixCount();
    }

    public void erase(String word) {
        TrieNode node = root;

        if (countWordsEqualTo(word) == 0)
            return;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            node = node.get(ch);
            node.decreasePrefixCount();
        }

        node.decreaseWordCount();
    }
}

// Time Complexity: O(L) per insert, countWordsEqualTo, countWordsStartingWith, erase
// Space Complexity: O(N * L * 26)
public class TrieWithAdvancedOperations {
    public static void main(String[] args) {

    }
}
