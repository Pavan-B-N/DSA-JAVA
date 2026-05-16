package Graphs.Medium.TopoSort_DFS_Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

// Time Complexity: O(V + E)
// Space Complexity: O(V) for stack and visited array
class Solution {
  public int[] topoSort(int V, List<List<Integer>> adj) {
    Deque<Integer> stack = new ArrayDeque<>();

    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, adj, stack, visited);
      }
    }

    int[] res = new int[stack.size()];

    int i = 0;

    while (!stack.isEmpty()) {
      res[i++] = stack.peek();
      stack.pop();
    }

    return res;
  }

  private void dfs(int node, List<List<Integer>> adj, Deque<Integer> stack, boolean[] visited) {
    visited[node] = true;

    for (int neighbor : adj.get(node)) {
      if (!visited[neighbor]) {
        dfs(neighbor, adj, stack, visited);
      }
    }

    stack.push(node);
  }
}

public class TopoSort_DFS_Stack {
  public static void main(String[] args) {

  }
}
