package Trie.Medium.LongestCommonPrefixUsingTrie;
// https://leetcode.com/problems/longest-common-prefix/

// recommended solution
// Time Complexity: O(N * L)
// Space Complexity: O(N * L * 26) for trie
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];

        String shortestStr = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortestStr.length()) {
                shortestStr = strs[i];
            }
        }

        for (int i = 0; i < shortestStr.length(); i++) {
            for (String s : strs) {
                if (s.charAt(i) != shortestStr.charAt(i)) {
                    return shortestStr.substring(0, i);
                }
            }
        }

        return shortestStr;
    }
}

// Trie is not necessaru here
class TrieNode {
    TrieNode[] links;
    boolean end;
    int prefixCount;

    public TrieNode() {
        links = new TrieNode[26];
        end = false;
        prefixCount = 0;
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

    public void increasePrefixCount() {
        prefixCount++;
    }

    public void decreasePrefixCount() {
        prefixCount--;
    }

    public int getPrefixCount() {
        return prefixCount;
    }
}

// Time Complexity: O(N * L)
// Space Complexity: O(N * L * 26) for trie
class Solution_Trie {
    TrieNode root;

    public Solution_Trie() {
        root = new TrieNode();
    }

    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            insert(strs[i]);
        }

        TrieNode node = root;
        for (int i = 0; i < strs[0].length(); i++) {
            node = node.get(strs[0].charAt(i));
            if (node.getPrefixCount() != strs.length) {
                return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }

    void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }

            node = node.get(ch);
            node.increasePrefixCount();
        }

        node.setEnd();
    }
}

public class LongestCommonPrefixUsingTrie {
    public static void main(String[] args) {

    }
}
