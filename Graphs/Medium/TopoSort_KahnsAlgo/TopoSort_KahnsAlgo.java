package Graphs.Medium.TopoSort_KahnsAlgo;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

// https://takeuforward.org/practice/dsa/topological-sort-or-kahns-algorithm?category=cycles&source=strivers-a2z-dsa-sheet

// Time Complexity: O(V + E)
// Space Complexity: O(V) for in-degree array and queue
class Solution {
    public int[] topoSort(int V, List<List<Integer>> adj) {

        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[V];
        int i = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            res[i++] = node;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return res;
    }
}

public class TopoSort_KahnsAlgo {
    public static void main(String[] args) {

    }
}
