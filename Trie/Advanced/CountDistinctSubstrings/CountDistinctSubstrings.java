package Trie.Advanced.CountDistinctSubstrings;
import java.util.HashSet;
import java.util.Set;

// https://takeuforward.org/practice/dsa/number-of-distinct-substrings-in-a-string?category=problems&source=strivers-a2z-dsa-sheet&sidebar=0

// Time Complexity: O(n^3)
// Space Complexity: O(n^2) distinct substrings
class Solution {
    public int countDistinctSubstring(String s) {
        Set<String> hashSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                // substring() creates a new String: O(n)
                hashSet.add(s.substring(i, j + 1));
            }
        }

        return hashSet.size() + 1;
    }
}

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

// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution_Trie {
    public int countDistinctSubstring(String s) {
        TrieNode root = new TrieNode();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            TrieNode node = root;

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);

                if (!node.containsKey(ch)) {
                    count++;
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
        }

        return count + 1;
    }
}

public class CountDistinctSubstrings {
    public static void main(String[] args) {

    }
}
