package Trie.Advanced.MaximumXorWithElemenentInArray;
// https://takeuforward.org/practice/dsa/maximum-xor-with-an-element-from-an-array?category=problems&source=strivers-a2z-dsa-sheet&tab=problem

import java.util.*;

class Node {
    Node[] links = new Node[2];

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }

    Node get(int bit) {
        return links[bit];
    }
}

class Trie {
    Node root = new Node();

    void insert(int num) {
        Node node = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;

            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }

            node = node.get(bit);
        }
    }

    int getMax(int num) {
        Node node = root;
        int maxNum = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;

            if (node.containsKey(1 - bit)) {
                maxNum |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }

        return maxNum;
    }
}

// Time Complexity: O(N * 32 + Q * 32 + Q log Q)
// Space Complexity: O(N * 32) for binary trie
class Solution {
    public List<Integer> maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int m = queries.length;
        int[][] sortedQueries = new int[m][3];

        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i][0];
            sortedQueries[i][1] = queries[i][1];
            sortedQueries[i][2] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[1], b[1]));

        Trie trie = new Trie();
        int[] ans = new int[m];
        Arrays.fill(ans, -1);

        int index = 0;

        for (int[] q : sortedQueries) {
            int xi = q[0];
            int mi = q[1];
            int originalIndex = q[2];

            while (index < nums.length && nums[index] <= mi) {
                trie.insert(nums[index++]);
            }

            if (index > 0) {
                ans[originalIndex] = trie.getMax(xi);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int value : ans) {
            result.add(value);
        }

        return result;
    }
}

public class MaximumXorWithElemenentInArray {
    public static void main(String[] args) {

    }
}
