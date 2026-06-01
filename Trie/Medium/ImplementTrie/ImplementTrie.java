package Trie.Medium.ImplementTrie;
// https://leetcode.com/problems/implement-trie-prefix-tree/
// https://leetcode.com/problems/implement-trie-prefix-tree/description/

class TrieNode {
    TrieNode[] links;
    boolean end;

    public TrieNode() {
        links = new TrieNode[26];
        end = false;
    }

    public void setEnd() {
        this.end = true;
    }

    public boolean isEnd() {
        return this.end;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode TrieNode) {
        links[ch - 'a'] = TrieNode;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
}

// Time Complexity: O(L) per insert, search, startsWith where L = word length
// Space Complexity: O(N * L * 26) for trie nodes
class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }

            node = node.get(ch);
        }

        node.setEnd();
    }

    boolean search(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return false;
            }

            node = node.get(ch);
        }

        return node.isEnd();

    }

    boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containsKey(ch)) {
                return false;
            }

            node = node.get(ch);
        }

        return true;
    }
}

// Time Complexity: O(L) per insert, search, startsWith where L = word length
// Space Complexity: O(N * L * 26) for trie nodes
public class ImplementTrie {
    public static void main(String[] args) {

    }
}
