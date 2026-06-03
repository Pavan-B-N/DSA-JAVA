package Trie.Advanced.MaximumXOROfTwoNumbersInArray;
// https://takeuforward.org/practice/dsa/maximum-xor-of-two-numbers-in-an-array?category=problems&source=strivers-a2z-dsa-sheet

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

// Time Complexity: O(N * 32)
// Space Complexity: O(N * 32) for binary trie
class Solution {
    private Node root = new Node();

    public int findMaximumXOR(int[] nums) {
        for (int ele : nums) {
            insert(ele);
        }

        int maxi = 0;

        for (int ele : nums) {
            maxi = Math.max(maxi, getMax(ele));
        }

        return maxi;
    }

    public int getMax(int num) {
        Node node = root;
        int maxNum = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = ((num >>> i) & 1);

            if (node.containsKey(1 - bit)) {
                maxNum |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }

        return maxNum;
    }

    public void insert(int num) {
        Node node = root;

        for (int i = 31; i >= 0; i--) {
            int bit = ((num >>> i) & 1);

            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }

            node = node.get(bit);
        }
    }
}

public class MaximumXOROfTwoNumbersInArray {
    public static void main(String[] args) {

    }
}
