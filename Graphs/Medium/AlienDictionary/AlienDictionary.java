package Graphs.Medium.AlienDictionary;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://takeuforward.org/practice/dsa/alient-dictionary?category=hard-problems&source=strivers-a2z-dsa-sheet

// Time Complexity: O(N * L + K) where K = unique characters, L = word length
// Space Complexity: O(K) for graph and in-degrees
class Solution {
    public String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            int minLen = Math.min(s1.length(), s2.length());

            if (s1.length() > s2.length() && s1.substring(0, minLen) == s2) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';

                    adj.get(u).add(v);

                    break;
                }
            }
        }

        // apply kahns algo
        int[] indegree = new int[K];

        for (int node = 0; node < K; node++) {
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int node = 0; node < K; node++) {
            if (indegree[node] == 0) {
                queue.offer(node);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            char ch = (char) (node + 'a');
            sb.append(ch + " ");

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return sb.toString();
    }
}

public class AlienDictionary {
    public static void main(String[] args) {

    }
}
