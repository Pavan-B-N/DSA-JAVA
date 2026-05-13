package Graphs.Medium.FindEventualStates;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

// https://takeuforward.org/practice/dsa/find-eventual-safe-states?category=hard-problems&source=strivers-a2z-dsa-sheet
// https://leetcode.com/problems/find-eventual-safe-states/

// Time Complexity: O(V + E) - Reverse Graph Topological Sort
// Space Complexity: O(V) for in-degree array and queue
class Solution_DFS {
    public int[] eventualSafeNodes(int V, int[][] adj) {

        boolean[] safeNode = new boolean[V];
        Arrays.fill(safeNode, true);

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsDetectCycle(i, adj, visited, pathVisited, safeNode);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (safeNode[i]) {
                list.add(i);
            }
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private boolean dfsDetectCycle(
            int node, int[][] adj, boolean[] visited, boolean[] pathVisited, boolean[] safeNode) {
        visited[node] = true;
        pathVisited[node] = true;
        safeNode[node] = false;

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                if (dfsDetectCycle(neighbor, adj, visited, pathVisited, safeNode))
                    return true;
            } else if (pathVisited[neighbor]) {
                return true;
            }
        }

        pathVisited[node] = false;
        safeNode[node] = true;

        return false;
    }
}

// Time Complexity: O(V + E) - Reverse Graph Topological Sort
// Space Complexity: O(V) for in-degree array and queue
class Solution_BFS_Kahns_ReverseGraph {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        List<List<Integer>> reverseGraph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        for (int u = 0; u < V; u++) {
            for (int v : adj[u]) {
                reverseGraph.get(v).add(u);
            }
        }

        // apply topo sort
        int[] indegree = new int[V];

        for (int u = 0; u < V; u++) {
            for (int v : reverseGraph.get(u)) {
                indegree[v]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);

            for (int neighbor : reverseGraph.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        Collections.sort(list);

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;

    }
}

public class FindEventualStates {
    public static void main(String[] args) {

    }
}
