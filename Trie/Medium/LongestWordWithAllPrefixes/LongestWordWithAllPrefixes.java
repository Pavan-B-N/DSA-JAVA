package Trie.Medium.LongestWordWithAllPrefixes;
import java.util.List;

// https://takeuforward.org/practice/dsa/longest-word-with-all-prefixes?category=problems&source=strivers-a2z-dsa-sheet&sidebar=0

class TrieNode {
    private final TrieNode[] links;
    private boolean end;

    public TrieNode() {
        links = new TrieNode[26];
        end = false;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd() {
        end = true;
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
}

// Time Complexity: O(N * L)
// Space Complexity: O(N * L * 26) for trie
class Solution {
    TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    public String completeString(List<String> nums) {
        for (String s : nums) {
            insert(s);
        }

        String res = "";

        for (String s : nums) {
            if (s.length() >= res.length() && isCompleteString(s)) {
                if (s.length() == res.length() && s.compareTo(res) >= 0) {
                    continue;
                }
                res = s;
            }
        }

        return res.isEmpty() ? "None" : res;
    }

    private void insert(String s) {
        TrieNode node = root;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }

            node = node.get(ch);
        }

        node.setEnd();
    }

    private boolean isCompleteString(String s) {
        TrieNode node = root;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!node.containsKey(ch)) {
                return false;
            }

            node = node.get(ch);

            if (!node.isEnd()) {
                return false;
            }
        }

        return true;
    }

}

public class LongestWordWithAllPrefixes {
    public static void main(String[] args) {

    }
}
