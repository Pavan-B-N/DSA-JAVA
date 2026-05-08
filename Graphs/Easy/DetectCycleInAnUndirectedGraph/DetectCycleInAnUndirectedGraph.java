package Graphs.Easy.DetectCycleInAnUndirectedGraph;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

// https://takeuforward.org/practice/dsa/detect-a-cycle-in-an-undirected-graph?category=cycles&source=strivers-a2z-dsa-sheet

// Time Complexity: O(V + 2E)
// Space Complexity: O(V) for visited array
class Solution_DFS {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, -1, adj, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(int node, int parent, List<Integer>[] adj, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, adj, visited))
                    return true;
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }
}

// Time Complexity: O(V + 2E)
// Space Complexity: O(V) for visited array
class Solution_BFS {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && bfs(i, adj, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean bfs(int src, List<Integer>[] adj, boolean[] visited) {
        Deque<Pair> queue = new ArrayDeque<>();

        queue.offer(new Pair(src, -1));
        visited[src] = true;

        while (!queue.isEmpty()) {
            Pair pr = queue.poll();
            int node = pr.node;
            int parent = pr.parent;

            for (Integer neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    queue.offer(new Pair(neighbor, node));
                    visited[neighbor] = true;
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }

        return false;
    }
}

class Pair {
    int node;
    int parent;

    public Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class DetectCycleInAnUndirectedGraph {
    public static void main(String[] args) {

    }
}
