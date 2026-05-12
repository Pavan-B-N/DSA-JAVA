package Graphs.Medium.DetectCycleInDirectedGraph;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

// https://takeuforward.org/practice/dsa/detect-a-cycle-in-a-directed-graph?category=cycles&source=strivers-a2z-dsa-sheet

// Time Complexity: O(V + E)
// Space Complexity: O(V) for path visited array or Kahn's in-degrees
class Solution_DFS {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        boolean[] visited = new boolean[N];
        boolean[] pathVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i] && dfs(i, adj, visited, pathVisited)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, pathVisited))
                    return true;
            } else if (pathVisited[neighbor]) {
                return true;
            }
        }

        pathVisited[node] = false;

        return false;
    }
}

// Time Complexity: O(V + E)
// Space Complexity: O(V) for path visited array or Kahn's in-degrees
class Solution_TopoSort_BFS {
    public boolean isCyclic(int N, List<List<Integer>> adj) {

        int[] indegree = new int[N];

        for (int i = 0; i < N; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int topoLen = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            topoLen++;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return topoLen != N;
    }
}

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {

    }
}
