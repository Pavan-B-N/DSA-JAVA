package Graphs.Medium.BipartiteGraph;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

// https://takeuforward.org/practice/dsa/bipartite-graph?category=cycles&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/is-graph-bipartite/description/

// Time Complexity: O(V + 2E)
// Space Complexity: O(V) for color array
class Solution_BFS {
    public boolean isBipartite(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            Integer u = edge.get(0);
            Integer v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] colors = new int[V];
        Arrays.fill(colors, -1);

        for (int i = 0; i < V; i++) {
            if (colors[i] == -1 && !bfs(i, colors, adj)) {
                return false;
            }
        }

        return true;
    }

    boolean bfs(int src, int[] colors, List<List<Integer>> adj) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(src);
        colors[src] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (colors[neighbor] == -1) {
                    int colorOfNeighbor = colors[node] == 1 ? 0 : 1;
                    colors[neighbor] = colorOfNeighbor;
                    queue.offer(neighbor);
                } else if (colors[node] == colors[neighbor]) {
                    return false;
                }
            }
        }

        return true;
    }
}

// Time Complexity: O(V + 2E)
// Space Complexity: O(V) for color array
class Solution_DFS {
    public boolean isBipartite(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            Integer u = edge.get(0);
            Integer v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] colors = new int[V];
        Arrays.fill(colors, -1);

        for (int i = 0; i < V; i++) {
            if (colors[i] == -1 && !dfs(i, 0, colors, adj)) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(int node, int colorOfNode, int[] colors, List<List<Integer>> adj) {
        colors[node] = colorOfNode;

        for (int neighbor : adj.get(node)) {
            if (colors[neighbor] == -1) {
                int neighborColor = colorOfNode == 1 ? 0 : 1;
                if (!dfs(neighbor, neighborColor, colors, adj)) {
                    return false;
                }
            } else if (colors[neighbor] == colorOfNode) {
                return false;
            }
        }

        return true;
    }
}

public class BipartiteGraph {
    public static void main(String[] args) {

    }
}
